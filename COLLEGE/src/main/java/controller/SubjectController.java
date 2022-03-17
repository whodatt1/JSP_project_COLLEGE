package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.SubjectVO;
import service.SubjectService;
import service.SubjectServiceImple;

@WebServlet("/subjCtrl/*")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(SubjectController.class);
	
	private SubjectService ssv;
	private RequestDispatcher rdp;
	private int isUp;
	private final String UTF8 = "utf-8";
	
	public SubjectController() {
		ssv = new SubjectServiceImple();
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		res.setContentType("text/html; charset=utf-8");
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		
		switch (path) {
		case "update":
			String[] imageFileNames = new String[2];
			SubjectVO svo = new SubjectVO();
			
			try {
				String savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath);
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(1*1024*1024);
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				
				List<FileItem> itemList = fileUpload.parseRequest(req);
				for (FileItem item : itemList) {
					switch (item.getFieldName()) {
					case "sno":
						svo.setSno(Long.parseLong(item.getString(UTF8)));
						break;
					case "title":
						svo.setTitle(item.getString(UTF8));
						break;
					case "major":
						svo.setMajor(item.getString(UTF8));
						break;
					case "description":
						svo.setDescription(item.getString(UTF8));
						break;
					case "imageFile":
						svo.setImageFile(item.getString(UTF8));
						imageFileNames[0] = svo.getImageFile();
						break;
					case "new_imageFile":
						if(item.getSize() > 0) {
							String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator)+1);
							fileName = System.currentTimeMillis() + "-" + fileName;
							
							File uploadFilePath = new File(fileDir + File.separator + fileName);
							try {
								item.write(uploadFilePath);
								svo.setImageFile(fileName);
								
							} catch (Exception e) {
								log.info(">>> WRITE FILE FAIL FROM UPDATE");
								e.printStackTrace();
							}
						}
						break;
					case "classLimit":
						svo.setClassLimit(Integer.parseInt(item.getString(UTF8)));
						break;
					case "startAt":
						svo.setStartAt(item.getString(UTF8));
						break;
					case "endAt":
						svo.setEndAt(item.getString(UTF8));
						break;

					default:
						break;
					}
				}
			} catch (Exception e) {
			}
			if (imageFileNames[1] != null) {
				if (imageFileNames[0].length() > 0 && imageFileNames[1].length() > 0) {
					String savePath2 = getServletContext().getRealPath("/_fileUpload");
					File fileDir2 = new File(savePath2);
					File removeFile = new File(fileDir2 + File.separator + imageFileNames[0]);
					
					if (removeFile.exists()) {
						removeFile.delete();
					}
				}
			}
			isUp = ssv.modify(svo);
			log.info(">>> MODIFY > {}", isUp > 0 ? "Success":"Fail");
			rdp = req.getRequestDispatcher("/subjCtrl/detail?sno=" + svo.getSno());
			rdp.forward(req, res);
			break;
		case "modify":
			req.setAttribute("svo", ssv.getDetail(Integer.parseInt(req.getParameter("sno"))));
			
			rdp = req.getRequestDispatcher("/subject/modify.jsp");
			rdp.forward(req, res);
			break;
		case "list":
			req.setAttribute("list", ssv.getList());
			
			rdp = req.getRequestDispatcher("/subject/list.jsp");
			rdp.forward(req, res);
			break;
		case "register":
			rdp = req.getRequestDispatcher("/subject/register.jsp");
			rdp.forward(req, res);
			break;
		case "insert":
			try {
				String savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath);
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(1*1024*1024); // 저장을 위한 임시 메모리 저장용량 Byte단위 
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				
				SubjectVO svo2 = new SubjectVO();
				List<FileItem> itemList = fileUpload.parseRequest(req);
				for (FileItem item : itemList) {
					switch (item.getFieldName()) {
					case "title":
						svo2.setTitle(item.getString(UTF8));
						break;
					case "id":
						svo2.setId(item.getString(UTF8));
						break;
					case "writer":
						svo2.setWriter(item.getString(UTF8));
						break;
					case "major":
						svo2.setMajor(item.getString(UTF8));
						break;
					case "description":
						svo2.setDescription(item.getString(UTF8));
						break;
					case "imageFile":
						if (item.getSize() > 0) {
							String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator)+1);
							fileName = System.currentTimeMillis() + "-" + fileName;
							
							File uploadFilePath = new File(fileDir + File.separator + fileName);
							try {
								item.write(uploadFilePath);
								svo2.setImageFile(fileName);
								
							} catch (Exception e) {
								log.info(">>> WRITE FILE FAIL");
								e.printStackTrace();
							}
						}
						break;
					case "classLimit":
						svo2.setClassLimit(Integer.parseInt(item.getString(UTF8)));
						break;
					case "startAt":
						svo2.setStartAt(item.getString(UTF8));
						break;
					case "endAt":
						svo2.setEndAt(item.getString(UTF8));
						break;

					default:
						break;
					}
				}
				ssv.register(svo2);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			rdp = req.getRequestDispatcher("/subjCtrl/list");
			rdp.forward(req, res);
			break;
		case "detail":
			req.setAttribute("svo", ssv.getDetail(Integer.parseInt(req.getParameter("sno"))));
			req.setAttribute("listCs", ssv.getList(Integer.parseInt(req.getParameter("sno"))));
			
			rdp = req.getRequestDispatcher("/subject/detail.jsp");
			rdp.forward(req, res);
			break;
		case "remove":
			try {
				String savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = 	new File(savePath);
			
				File removeFile = new File(fileDir + File.separator + req.getParameter("imageFile"));
			
				if(removeFile.exists()) {
					removeFile.delete();
				}
			isUp = ssv.remove(Integer.parseInt(req.getParameter("sno")));
			log.info(">>> REMOVE > {}", (isUp > 0 ? "Success" : "Fail"));
			} catch (Exception e) {
			}
			rdp = req.getRequestDispatcher("/subjCtrl/list");
			rdp.forward(req, res);
			break;
		case "plusAt":
			isUp = ssv.pAttends(new SubjectVO(Long.parseLong(req.getParameter("sno")), Integer.parseInt(req.getParameter("attends"))));
			
			rdp = req.getRequestDispatcher("/subjCtrl/detail?sno="+req.getParameter("sno"));
			rdp.forward(req, res);
			break;
		case "minusAt":
			isUp = ssv.mAttends(new SubjectVO(Long.parseLong(req.getParameter("sno")), Integer.parseInt(req.getParameter("attends"))));
			
			rdp = req.getRequestDispatcher("/courCtrl/list_stu?email="+req.getParameter("email"));
			rdp.forward(req, res);
			break;
			
		default:
			break;
		}
	}
	
	
}

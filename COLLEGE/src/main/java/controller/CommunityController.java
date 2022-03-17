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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommunityVO;
import net.coobird.thumbnailator.Thumbnails;
import service.CommunityService;
import service.CommunityServiceImple;

@WebServlet("/commCtrl/*")
public class CommunityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(CommunityController.class);
	
	private final CommunityService csv;
	private RequestDispatcher rdp;
	private int isUp;
	private final String UTF8 = "utf-8";
	
	public CommunityController() {
		csv = new CommunityServiceImple();
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		res.setContentType("text/html; charset=utf-8");
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		
		switch (path) {
		case "list":
			req.setAttribute("list", csv.getList());
			
			rdp = req.getRequestDispatcher("/community/list.jsp");
			rdp.forward(req, res);
			break;
		case "register":
			rdp = req.getRequestDispatcher("/community/register.jsp");
			rdp.forward(req, res);
			break;
		case "insert":
			try {
				String savePath = getServletContext().getRealPath("/_fileUpload_comm");
				File fileDir = new File(savePath);
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(1*1024*1024);
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				
				CommunityVO cvo = new CommunityVO();
				List<FileItem> itemList = fileUpload.parseRequest(req);
				for (FileItem item : itemList) {
					switch (item.getFieldName()) {
					case "id":
						cvo.setId(item.getString(UTF8));
						break;
					case "writer":
						cvo.setWriter(item.getString(UTF8));
						break;
					case "title":
						cvo.setTitle(item.getString(UTF8));
						break;
					case "content":
						cvo.setContent(item.getString(UTF8));
						break;
					case "imageFile":
						if(item.getSize() > 0) {
							String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator) + 1);
							fileName = System.currentTimeMillis() + "-" + fileName;
							
							File uploadFilePath = new File(fileDir + File.separator + fileName);
							try {
								item.write(uploadFilePath);
								cvo.setImageFile(fileName);
								
								Thumbnails.of(uploadFilePath)
								.size(60, 60)
								.toFile(new File(fileDir + File.separator + "th_" + fileName));
							} catch (Exception e) {
								log.info(">>> File Write to Disk Fail");
								e.printStackTrace();
							}
						}
						break;
					default:
						break;
					}
				}
				csv.register(cvo);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			rdp = req.getRequestDispatcher("/commCtrl/list");
			rdp.forward(req, res);
			break;
		case "detail":
			req.setAttribute("cvo", csv.getDetail(Long.parseLong(req.getParameter("cno"))));
			
			rdp = req.getRequestDispatcher("/community/detail.jsp");
			rdp.forward(req, res);
			break;
		case "remove":
			log.info(req.getParameter("cno"));
			try {
				String savePath = getServletContext().getRealPath("/_fileUpload_comm");
				File fileDir = new File(savePath);
				
				File removeFile = new File(fileDir + File.separator + req.getParameter("imageFile"));
				File removeFileThumb = new File(fileDir + File.separator + "th_" +req.getParameter("imageFile"));
				boolean rm = true;
				if (removeFile.exists() || removeFileThumb.exists()) {
						rm = removeFile.delete();
						if(rm) {
							rm = removeFileThumb.delete();
						}
				}
				rm = csv.remove(Long.parseLong(req.getParameter("cno"))) > 0 ? true : false;
			} catch (Exception e) {
				log.info(">>> File Del > Fail");
				e.printStackTrace();
			}
			rdp = req.getRequestDispatcher("/commCtrl/list");
			rdp.forward(req, res);
			break;
		case "modify":
			req.setAttribute("cvo", csv.getDetail(Long.parseLong(req.getParameter("cno"))));
			
			rdp = req.getRequestDispatcher("/community/modify.jsp");
			rdp.forward(req, res);
			break;
		case "update":
			CommunityVO cvo = new CommunityVO();
			String[] imageFileNames = new String[2];
			try {
				String savePath = getServletContext().getRealPath("/_fileUpload_comm");
				File fileDir = new File(savePath);
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(1*1024*1024);
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				
				List<FileItem> itemList = fileUpload.parseRequest(req);
				for (FileItem item : itemList) {
					switch (item.getFieldName()) {
					case "cno":
						cvo.setCno(Long.parseLong(item.getString(UTF8)));
						break;
					case "title":
						cvo.setTitle(item.getString(UTF8));
						break;
					case "content":
						cvo.setContent(item.getString(UTF8));
						break;
					case "imageFile":
						cvo.setImageFile(item.getString(UTF8));
						imageFileNames[0] = cvo.getImageFile();
						break;
					case "new_imageFile":
						if (item.getSize() > 0) {
							String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator)+1);
							fileName = System.currentTimeMillis() + "-" + fileName;
							File uploadFilePath = new File(fileDir + File.separator + fileName);
							
							try {
								item.write(uploadFilePath);
								cvo.setImageFile(fileName);
								
								imageFileNames[1] = cvo.getImageFile();
								Thumbnails.of(uploadFilePath)
								.size(60, 60)
								.toFile(new File(fileDir + File.separator + "th_" + fileName));
							} catch (Exception e) {
								log.info(">>> File Write To Disk Fail");
								e.printStackTrace();
							}
						}
						break;

					default:
						break;
					} 
				}
				if (imageFileNames[1] != null) {
					if (imageFileNames[0].length() > 0 || imageFileNames[1].length() > 0) {
						try {
							String savePath2 = getServletContext().getRealPath("/_fileUpload_comm");
							File fileDir2 = new File(savePath2);
							
							File removeFile = new File(fileDir2 + File.separator + imageFileNames[0]);
							File removeFileThumb =
									new File(fileDir2 + File.separator + "th_" + imageFileNames[0]);
							boolean rm = true;
							if(removeFile.exists() || removeFileThumb.exists()) {
								rm = removeFile.delete();
								if(rm) {
									rm = removeFileThumb.delete();
							}
							}
							log.info(">>> REMOVE FILE > {}", rm ? "Success" : "Fail");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				
			}
			isUp = csv.modify(cvo);
			log.info(">> MODIFY > {}", isUp > 0 ? "Success" : "Fail");
			rdp = req.getRequestDispatcher("/commCtrl/detail?cno="
					+ cvo.getCno());
rdp.forward(req, res);
			break;
		default:
			
			break;
		}
	}
}

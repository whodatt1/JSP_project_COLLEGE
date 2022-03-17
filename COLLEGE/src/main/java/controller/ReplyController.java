package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ReplyVO;
import service.ReplyService;
import service.ReplyServiceImple;

@WebServlet("/replCtrl/*")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(ReplyController.class);
	
	private final ReplyService rpsv;
	private RequestDispatcher rdp;
	private int isUp;
	private final String UTF8 = "utf-8";
	
	public ReplyController() {
		rpsv = new ReplyServiceImple();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		
		String uri = req.getRequestURI();
		String path = uri.substring("/replCtrl/".length());
		String pathVar = "";
		if(path.contains("/")) {
			pathVar = path.substring(path.lastIndexOf("/")+1);
			path = path.substring(0, path.lastIndexOf("/"));
		}
		
		switch (path) {
		case "register":
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				log.info(jsonObj.get("content").toString());
				isUp = rpsv.register(new ReplyVO(Long.parseLong(jsonObj.get("cno").toString()),
						jsonObj.get("id").toString(),
						jsonObj.get("replier").toString(),
						jsonObj.get("content").toString()));
				log.info(">>> REPLY REG > {}", isUp > 0 ? "Success" : "Fail");
				PrintWriter out = res.getWriter();
				out.print(isUp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "list":
			try {
				List<ReplyVO> list = rpsv.getList(Long.parseLong(pathVar));
				JSONObject[] jsonObjArr = new JSONObject[list.size()];
				JSONArray jsonObjList = new JSONArray();
				
				for (int i = 0; i < list.size(); i++) {
					jsonObjArr[i] = new JSONObject();
					jsonObjArr[i].put("rpno", list.get(i).getRpno());
					jsonObjArr[i].put("cno", list.get(i).getCno());
					jsonObjArr[i].put("id", list.get(i).getId());
					jsonObjArr[i].put("replier", list.get(i).getReplier());
					jsonObjArr[i].put("content", list.get(i).getContent());
					jsonObjArr[i].put("modAt", list.get(i).getModAt());
					
					jsonObjList.add(jsonObjArr[i]);
				}
				String jsonData = jsonObjList.toJSONString();
				
				PrintWriter out = res.getWriter();
				out.print(jsonData);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "remove":
			isUp = rpsv.remove(Long.parseLong(pathVar));
			
			PrintWriter out = res.getWriter();
			out.print(isUp);
			break;
		case "update":
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();
				
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				
				isUp = rpsv.modify(new ReplyVO(Long.parseLong(jsonObj.get("rpno").toString()),
						jsonObj.get("content").toString()));
				log.info(">>> REPLY MODIFY > {}", isUp > 0 ? "Success" : "Fail");
				PrintWriter out2 = res.getWriter();
				out2.print(isUp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		default:
			break;
		}
	}
	
	
}

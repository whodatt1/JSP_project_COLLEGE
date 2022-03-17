package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

import domain.ReviewVO;
import service.ReviewService;
import service.ReviewServiceImple;

@WebServlet("/reviCtrl/*")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(ReviewController.class);
	private final ReviewService rvsv;
	private int isUp;
	private final String UTF8 = "utf-8";
	
	public ReviewController() {
		rvsv = new ReviewServiceImple();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		
		String uri = req.getRequestURI();
		String path = uri.substring("/reviCtrl/".length());
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
					
					isUp = rvsv.register(new ReviewVO(Long.parseLong(jsonObj.get("sno").toString()), 
							jsonObj.get("title").toString(),
							jsonObj.get("id").toString(),
							jsonObj.get("writer").toString(),
							Integer.parseInt(jsonObj.get("score").toString()),
							jsonObj.get("content").toString()));
					log.info(">>> REVIEW REG > {}", isUp > 0 ? "Success" : "Fail");
					PrintWriter out = res.getWriter();
					out.print(isUp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;
		case "list":
			try {
				List<ReviewVO> list = rvsv.getList(Long.parseLong(pathVar));
				JSONObject[] jsonObjArr = new JSONObject[list.size()];
				JSONArray jsonObjList = new JSONArray();
				
				for (int i = 0; i < list.size(); i++) {
					jsonObjArr[i] = new JSONObject();
					jsonObjArr[i].put("rvno", list.get(i).getRvno());
					jsonObjArr[i].put("sno", list.get(i).getSno());
					jsonObjArr[i].put("title", list.get(i).getTitle());
					jsonObjArr[i].put("id", list.get(i).getId());
					jsonObjArr[i].put("writer", list.get(i).getWriter());
					jsonObjArr[i].put("score", list.get(i).getScore());
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
			isUp = rvsv.remove(Long.parseLong(pathVar));
			log.info(">>> REVIEW REMOVE > {}", isUp > 0 ? "Success" : "Fail");
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
				log.info(">>> {}", sb.toString());
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				log.info(">>> {}", jsonObj.toString());
				isUp = rvsv.modify(new ReviewVO(Long.parseLong(jsonObj.get("rvno").toString()),
						jsonObj.get("title").toString(),
						Integer.parseInt(jsonObj.get("score").toString()),
						jsonObj.get("content").toString()));
				log.info(">>> REVIEW UPDATE > {}", isUp > 0 ? "Success" : "Fail");
				
				PrintWriter out2 = res.getWriter();
				out2.print(isUp);
			} catch (Exception e) {
			}
			break;
			
		default:
			break;
		}
	}
	
	
}

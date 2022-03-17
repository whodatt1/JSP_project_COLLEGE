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

import domain.UserVO;
import service.UserService;
import service.UserServiceImple;

@WebServlet("/userCtrlJs/*")
public class UserControllerJs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(UserControllerJs.class);
	
	private UserService usv;
	private RequestDispatcher rdp;
	private int isUp;
	private final String UTF8 = "utf-8";
	
	public UserControllerJs() {
		usv = new UserServiceImple();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		
		switch (path) {
		case "modify":
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();
				
				while((line = br.readLine()) != null) {
					sb.append(line);
				}
				
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				
				isUp = usv.modify2(new UserVO(jsonObj.get("email").toString(),
						Integer.parseInt(jsonObj.get("grade").toString())));
				
				PrintWriter out = res.getWriter();
				out.print(isUp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "list":
			try {
				List<UserVO> list = usv.getList();
				JSONObject[] jsonObjArr = new JSONObject[list.size()];
				JSONArray jsonObjList = new JSONArray();
				
				for (int i = 0; i < list.size(); i++) {
					jsonObjArr[i] = new JSONObject();
					jsonObjArr[i].put("email", list.get(i).getEmail());
					jsonObjArr[i].put("userName", list.get(i).getUserName());
					jsonObjArr[i].put("regAt", list.get(i).getRegAt());
					jsonObjArr[i].put("lastLogin", list.get(i).getLastLogin());
					jsonObjArr[i].put("grade", list.get(i).getGrade());
					jsonObjArr[i].put("major", list.get(i).getMajor());
					
					jsonObjList.add(jsonObjArr[i]);
				}
				String jsonData = jsonObjList.toJSONString();
				
				PrintWriter out = res.getWriter();
				out.print(jsonData);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		default:
			break;
		}
	}
	
}

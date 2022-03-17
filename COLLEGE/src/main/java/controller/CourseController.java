package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CourseVO;
import service.CourseService;
import service.CourseServiceImple;

@WebServlet("/courCtrl/*")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(CourseController.class);
	
	private final CourseService cssv;
	private RequestDispatcher rdp;
	private int isUp;
	private final String UTF8 = "utf-8";

	public CourseController() {
		cssv = new CourseServiceImple();
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		res.setContentType("text/html; charset=utf-8");
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(">>> {}", path);
		
		switch (path) {
		case "list_stu":
			req.setAttribute("list", cssv.getListStu(req.getParameter("email")));
			
			rdp = req.getRequestDispatcher("/course/list_stu.jsp");
			rdp.forward(req, res);
			break;
		case "list_pro":
			req.setAttribute("list", cssv.getListPro(req.getParameter("professorId")));
			
			rdp = req.getRequestDispatcher("/course/list_pro.jsp");
			rdp.forward(req, res);
			break;
		case "insert":
			
			isUp = cssv.register(new CourseVO(Long.parseLong(req.getParameter("csSno")),
					req.getParameter("csEmail"),
					req.getParameter("csUserName"),
					req.getParameter("csName"),
					req.getParameter("csProName"),
					req.getParameter("csProId"),
					req.getParameter("csMajor"),
					req.getParameter("csStartAt"),
					req.getParameter("csEndAt")));

			log.info(">>> COURSE REGISTER > {}", isUp > 0 ? "Success" : "Fail");
			req.setAttribute("msg_reg", isUp);
			
			rdp = req.getRequestDispatcher("/subjCtrl/plusAt?sno="+req.getParameter("csSno")+"&attends=1");
			rdp.forward(req, res);
			break;
		case "remove":
			isUp = cssv.remove(Long.parseLong(req.getParameter("csno")));
			log.info(">>> COURSE DELETE > {}", isUp > 0 ? "Success" : "Fail");
			
			rdp = req.getRequestDispatcher("/subjCtrl/minusAt?sno="+req.getParameter("sno")+"&attends=1");
			rdp.forward(req, res);
			break;
			
		default:
			break;
		}
	}
	
	
}

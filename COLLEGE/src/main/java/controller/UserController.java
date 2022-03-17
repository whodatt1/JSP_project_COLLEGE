package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.UserVO;
import service.UserService;
import service.UserServiceImple;

@WebServlet("/userCtrl/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	private UserService usv;
	private RequestDispatcher rdp;
	private int isUp;
	private final String UTF8 = "utf-8";
	
	public UserController() {
		usv = new UserServiceImple();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		res.setContentType("text/html; charset=utf-8");
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		
		switch (path) {
		case "register":
			rdp = req.getRequestDispatcher("/user/register.jsp");
			rdp.forward(req, res);
			break;
		case "insert":
				isUp = usv.register(new UserVO(req.getParameter("email"),
						req.getParameter("pwd"),
						req.getParameter("userName"),
						Integer.parseInt(req.getParameter("grade")),
						req.getParameter("major")));
				log.info(">>> SIGN UP > {}", isUp > 0 ? "Success" : "Fail");
				req.setAttribute("msg_reg", isUp);
				
				rdp = req.getRequestDispatcher("/index.jsp");
				rdp.forward(req, res);
			break;
		case "list":
			req.setAttribute("list", usv.getList());
			rdp = req.getRequestDispatcher("/user/list.jsp");
			rdp.forward(req, res);
			break;
		case "detail":
			req.setAttribute("uvo", usv.getDetail(req.getParameter("email")));
			
			rdp = req.getRequestDispatcher("/user/detail.jsp");
			rdp.forward(req, res);
		case "modify":
			isUp = usv.modify(new UserVO(req.getParameter("email"),
					req.getParameter("pwd"),
					req.getParameter("userName"),
					req.getParameter("major")));
			log.info(">>> MODIFY > {}", (isUp > 0 ? "Success" : "Fail"));
			
			HttpSession currSES2 = req.getSession();
			currSES2.invalidate();
			req.setAttribute("msg_mod", 1);
			rdp = req.getRequestDispatcher("/index.jsp");
			rdp.forward(req, res);
			break;
			
		case "modify2":
			isUp = usv.modify2(new UserVO(req.getParameter("email"), req.getParameter("grade")));
			log.info(">>> MODIFY2 > {}", (isUp > 0 ? "Success" : "Fail"));
			rdp = req.getRequestDispatcher("/userCtrl/list");
			rdp.forward(req, res);
			break;
		case "remove":
			isUp = usv.remove(req.getParameter("email"));
			log.info(">>> REMOVE > {}", (isUp > 0 ? "Success" : "Fail"));
			
			HttpSession currSES = req.getSession();
			currSES.invalidate();
			req.setAttribute("msg_resign", 1);
			rdp = req.getRequestDispatcher("/index.jsp");
			rdp.forward(req, res);
			break;
		case "login":
			List<String> list = usv.getEmailList();
			String pwd = usv.getMatchPwd(req.getParameter("email"));
			boolean flag = false;
			
			if (!list.contains(req.getParameter("email"))) {
				req.setAttribute("msg_email", 1);
					
				rdp = req.getRequestDispatcher("/user/login.jsp");
				rdp.forward(req, res);
				flag = false;
			} else if (list.contains(req.getParameter("email"))) {
				flag = true;					
			}
			
			if (flag) {
				log.info(">>> pwd > {}", pwd);
				log.info(">>> typeof > {}", req.getParameter("pwd"));
				if (!req.getParameter("pwd").equals(pwd)) {
					req.setAttribute("msg_pwd", 1);
					
					rdp = req.getRequestDispatcher("/user/login.jsp");
					rdp.forward(req, res);
					flag = false;
				} else if (req.getParameter("pwd").equals(pwd)) {
					flag = true;
				}
			}
			
			if (flag) {
				UserVO uvo = usv.login(new UserVO(req.getParameter("email"),
						req.getParameter("pwd")));
				log.info(">>> mvo > {}", uvo);
				if(uvo != null) {
					HttpSession ses = req.getSession();
					ses.setAttribute("ses", uvo);
					ses.setMaxInactiveInterval(60 * 10);
				} else {
					req.setAttribute("msg_login", 0);
				}
				
				rdp = req.getRequestDispatcher("/index.jsp");
				rdp.forward(req, res);
			}
			break;
		case "logout":
			HttpSession currSes = req.getSession();
			currSes.removeAttribute("ses");
			
			req.setAttribute("msg_logout", 1);
			rdp = req.getRequestDispatcher("/index.jsp");
			rdp.forward(req, res);
			break;
		default:
			break;
		}
	}
	
}

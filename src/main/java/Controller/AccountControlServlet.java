package Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import Constant.SessionAttr;
import DAO.ShareDAO;
import DAO.UserDAO;
import DAO.VideoDAO;
import Entity.Share;
import Entity.User;
import Utils.CookieUtils;
import Utils.MailUtils;

@WebServlet({ "/youtube/sign-in", "/youtube/sign-up", "/youtube/sign-out", "/youtube/forget-password", "/youtube/change-password", "/youtube/share", "/youtube/edit-profile" })
public class AccountControlServlet extends HttpServlet {

	private static final long serialVersionUID = 5037589279838319447L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/youtube/sign-in": {
			doGetLogin(req, resp);
			break;
		}
		case "/youtube/sign-up": {
			doGetSignUp(req, resp);
			break;
		}
		case "/youtube/edit-profile": {
			doGetEditProfile(req, resp);
			break;
		}case "/youtube/forget-password": {
			doGetForgetPassword(req, resp);
			break;
		}case "/youtube/change-password": {
			doGetChangePassword(req, resp);
			break;
		}case "/youtube/share": {
			doGetShare(req, resp);
			break;
		}
		case "/youtube/sign-out": {
			doGetSignOut(session, req, resp);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/youtube/sign-in": {
			doPostLogin(session, req, resp);
			break;
		}
		case "/youtube/sign-up": {
			doPostSignUp(req, resp);
			break;
		}
		case "/youtube/edit-profile": {
			doPostEditProfile(req, resp);
			break;
		}case "/youtube/forget-password": {
			doPostForgetPassword(req, resp);
			break;
		}case "/youtube/change-password": {
			doPostChangePassword(req, resp);
			break;
		}case "/youtube/share": {
			doPostShare(req, resp);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}

	private void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// đọc giá trị của cookie
		String username = CookieUtils.get("username", req);
		String password = CookieUtils.get("password", req);
		// chuyển sang login để hiển thị lên form
		req.setAttribute("username", username);
		req.setAttribute("password", password);
		req.getRequestDispatcher("/views/layoutUser/sign-in.jsp").forward(req, resp);
	}

	private void doGetSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/layoutUser/sign-up.jsp").forward(req, resp);
	}

	private void doGetSignOut(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		session.removeAttribute(SessionAttr.CURRENT_USER);
		resp.sendRedirect("index");
	}
	
	private void doGetChangePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/views/layoutUser/change-password.jsp").forward(req, resp);
	}
	
	private void doGetForgetPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/layoutUser/forget-password.jsp").forward(req, resp);
	}
	
	private void doGetShare(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String videoid = req.getParameter("videoid");
		req.setAttribute("videoid", videoid);
		req.getRequestDispatcher("/views/layoutUser/share.jsp").forward(req, resp);
	}
	
	private void doGetEditProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/views/layoutUser/edit-profile.jsp").forward(req, resp);
	}

	private void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		// ghi nhớ hoặc xóa tài khoản đã ghi nhớ bằng cookie
		int hours = (remember == null) ? 0 : 30 * 24; // 0 = xóa
		CookieUtils.add("username", username, hours, resp);
		CookieUtils.add("password", password, hours, resp);

		UserDAO dao = new UserDAO();
		User user = dao.checkLogin(username, password);
		if (user != null) {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			if (user.getAdmin()) {
				resp.sendRedirect("/Asm_Java_Youtube/youtube/admin");
			} else {
				resp.sendRedirect("/Asm_Java_Youtube/youtube/video");
			}

		} else {
			req.setAttribute("message", "Login fail!");
//			resp.sendRedirect("/Asm_Java_Youtube/youtube/sign-up");
			req.getRequestDispatcher("/views/layoutUser/sign-in.jsp").forward(req, resp);
			
		}

	}

	private void doPostSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User entity = new User();
		try {
			BeanUtils.populate(entity, req.getParameterMap());
			UserDAO dao = new UserDAO();
			dao.create(entity);
			resp.sendRedirect("/Asm_Java_Youtube/youtube/sign-in");
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("message", "Register fail!");
			req.getRequestDispatcher("/views/layoutUser/sign-up.jsp").forward(req, resp);
		}

	}
	
	private void doPostForgetPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			UserDAO dao = new UserDAO();
			String id = req.getParameter("id");
			String email = req.getParameter("email");
			User user = dao.findById(id);
			if(user == null) {
				req.setAttribute("message", "This user no exits!");
			}else if(!user.getEmail().equals(email)) {
				req.setAttribute("message", "Incorrect Email!");
			}else {
				try {
					String sub = "Lấy lại mật khẩu: ";
					String text = user.getPassword();
					MailUtils mail = new MailUtils();
					mail.setup(sub, text, "bao10062003@gmail.com");
					resp.sendRedirect("/Asm_Java_Youtube/youtube/sign-in");
					return;
				} catch (Exception e) {
					// TODO: handle exception
					req.setAttribute("message", "Send mail fail!");
				}
			}
			req.getRequestDispatcher("/views/layoutUser/forget-password.jsp").forward(req, resp);
		
	}
	
	private void doPostShare(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		req.setAttribute("user", user);
		String videoid = req.getParameter("videoid");
		VideoDAO daoVD = new VideoDAO();
		String url = "https://www.youtube.com/embed/";
		String email = req.getParameter("email");
		try {
			String sub = "Share link";
			String text = "Link youtube: " + url + videoid;
			MailUtils mail = new MailUtils();
			mail.setup(sub, text, email);
			ShareDAO dao = new ShareDAO();
			Share entity = new Share();
			entity.setUserId(user);
			entity.setVideoId(daoVD.findById(videoid));
			entity.setShareDate(new Date());
			entity.setEmail(email);
			dao.create(entity);
			resp.sendRedirect("/Asm_Java_Youtube/youtube/detail-video?vid=" + videoid);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("message", "Send mail fail!");
		}
		req.getRequestDispatcher("/views/layoutUser/share.jsp").forward(req, resp);
	}
	
	private void doPostChangePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		req.setAttribute("user", user);
		String currentPass = req.getParameter("password");
		String newPass = req.getParameter("new-password");
		String confirmPass = req.getParameter("confirm-password");
		
		if(user == null) {
			req.setAttribute("message", "Username no exits!");
		}else if(!user.getPassword().equals(currentPass)) {
			req.setAttribute("message", "Incorrect password!");
		}else if(!newPass.equals(confirmPass)) {
			req.setAttribute("message", "Confirm password no match with new password!");
		}else {
			try {
				UserDAO dao = new UserDAO();
				user.setPassword(newPass);
				dao.update(user);
				resp.sendRedirect("/Asm_Java_Youtube/youtube/video");
				return;
			} catch (Exception e) {
				req.setAttribute("message", "Change password fail!");
			}
		}
		
		req.getRequestDispatcher("/views/layoutUser/change-password.jsp").forward(req, resp);

	}
	
	private void doPostEditProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		req.setAttribute("user", user);
		
		try {
			BeanUtils.populate(user, req.getParameterMap());
			UserDAO dao = new UserDAO();
			dao.update(user);
			resp.sendRedirect("/Asm_Java_Youtube/youtube/video");
		} catch (Exception e) {
			req.setAttribute("message", "Update account fail!");
			req.getRequestDispatcher("/views/layoutUser/edit-profile.jsp").forward(req, resp);
		}
		

	}
}

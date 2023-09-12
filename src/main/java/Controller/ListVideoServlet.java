package Controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Constant.SessionAttr;
import DAO.VideoDAO;
import Entity.Video;
import Utils.JpaUtils;

@WebServlet("/youtube/video")
public class ListVideoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		if (session.getAttribute(SessionAttr.CURRENT_USER) != null) {
			VideoDAO dao = new VideoDAO();
			List<Video> list = dao.findAll();
			req.setAttribute("videos", list);
			Video vd = list.get(0);
			req.setAttribute("video", vd);
			req.getRequestDispatcher("/views/layoutUser/user.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/Asm_Java_Youtube/youtube/sign-in");
		}
	}
	
	EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("views/layoutUser/user.jsp").forward(req, resp);
	}
}

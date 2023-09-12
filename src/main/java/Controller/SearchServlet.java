package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VideoDAO;
import Entity.Video;

@WebServlet("/youtube/search")
public class SearchServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			VideoDAO dao = new VideoDAO();
			String title = req.getParameter("searchTitle");
			List<Video> list = dao.findByTitle(title);
			req.setAttribute("titleValue", title); 
			req.setAttribute("videos", list);
			req.getRequestDispatcher("/views/layoutUser/user.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			resp.sendRedirect("/Asm_Java_Youtube/youtube/video");
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}

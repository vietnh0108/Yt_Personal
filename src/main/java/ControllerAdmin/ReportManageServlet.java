package ControllerAdmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReportFavoriteDAO;
import DAO.ReportFavoriteUserDAO;
import DAO.ReportSharedDAO;
import DAO.VideoDAO;
import Entity.ReportFavorite;
import Entity.ReportFavoriteUser;
import Entity.ReportShared;
import Entity.Video;

@WebServlet({ "/youtube/report-manage", "/youtube/video-search-user", "/youtube/video-search-shared" })
public class ReportManageServlet extends HttpServlet{
	public int flag2 = 0;
	public int flag3 = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		List<Video> list = dao.findAll();
		req.setAttribute("list", list);
		
		// fill data lên tab1
		ReportFavoriteDAO daoRF = new ReportFavoriteDAO();
		List<ReportFavorite> list1 = daoRF.findAll();
		req.setAttribute("videos", list1);
		// fill data lên tab2
		ReportFavoriteUserDAO daoRFU = new ReportFavoriteUserDAO();
		List<ReportFavoriteUser> list2;
		
		if(flag2 == 0) {
			list2 = daoRFU.findAll();
			req.setAttribute("users", list2);
		}else {
			list2 = doPostSearchVideoByUser(req, resp);
			req.setAttribute("users", list2);
		}
		
		
		// fill data lên tab3
		ReportSharedDAO daoRS = new ReportSharedDAO();
		List<ReportShared> list3;
		
		if(flag3 == 0) {
			list3 = daoRS.findAll();
			req.setAttribute("sharedVD", list3);
		}else {
			list3 = doPostSearchVideoByShared(req, resp);
			req.setAttribute("sharedVD", list3);
		}
		
		req.getRequestDispatcher("/views/layoutAdmin/report-manage.jsp").forward(req, resp);
	}
	

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		switch (path) {
		case "/youtube/video-search-user": {
			flag2 = 1;
			resp.sendRedirect("/Asm_Java_Youtube/youtube/report-manage");
			break;
		}
		case "/youtube/video-search-shared": {
			flag3 = 1;
			resp.sendRedirect("/Asm_Java_Youtube/youtube/report-manage");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}
	
	public List<ReportFavoriteUser> doPostSearchVideoByUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			String title = req.getParameter("title-choice-tab2");
			System.out.println(title);
			ReportFavoriteUserDAO daoRFU = new ReportFavoriteUserDAO();
			return daoRFU.findByTitle(title);
		
	}
	
	public List<ReportShared> doPostSearchVideoByShared(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
			String title = req.getParameter("title-choice-tab3");
			System.out.println(title);
			ReportSharedDAO daoRS = new ReportSharedDAO();
			return daoRS.findByTitle(title);
		
	}
}

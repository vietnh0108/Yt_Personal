package ControllerAdmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import DAO.VideoDAO;
import Entity.User;
import Entity.Video;

@WebServlet({"/youtube/video-manage", "/youtube/video-manage/edit/*", "/youtube/video-manage/create", "/youtube/video-manage/update", "/youtube/video-manage/delete"})
public class VideoManageServlet extends HttpServlet{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		VideoDAO dao = new VideoDAO();
//		List<Video> list = dao.findAll();
//		req.setAttribute("videos", list);
//		req.getRequestDispatcher("/views/layoutAdmin/video-manage.jsp").forward(req, resp);
//	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VideoDAO dao = new VideoDAO();
		List<Video> list = dao.findAll();
		req.setAttribute("videos", list);
		Video video = new Video();
		String uri = req.getRequestURI();
		if (uri.contains("edit")) {
			String id = uri.substring(uri.lastIndexOf("/") + 1);
			video = dao.findById(id);
		} else
			try {
				if (uri.contains("create")) {
					try {
						BeanUtils.populate(video, req.getParameterMap());
						dao.create(video);
						req.setAttribute("message", "Insert new video success!");
					} catch (Exception e) {
						// TODO: handle exception
						req.setAttribute("message", "Insert new video fail!");
					}
				} else if (uri.contains("delete")) {
					try {
						String id = req.getParameter("id");
						dao.remove(id);
						req.setAttribute("message", "Delete success!");
					} catch (Exception e) {
						// TODO: handle exception
						req.setAttribute("message", "Delete fail!");

					}
				} else if (uri.contains("update")) {
					try {
						BeanUtils.populate(video, req.getParameterMap());
						dao.update(video);
						req.setAttribute("message", "Update success!");

					} catch (Exception e) {
						// TODO: handle exception
						req.setAttribute("message", "Update fail!");

					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		req.setAttribute("video", video);
		req.getRequestDispatcher("/views/layoutAdmin/video-manage.jsp").forward(req, resp);
		
	}
}

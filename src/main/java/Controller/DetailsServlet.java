package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Constant.SessionAttr;
import DAO.FavoriteDAO;
import DAO.VideoDAO;
import Entity.Favorite;
import Entity.User;
import Entity.Video;
import Utils.JpaUtils;

/**
 * Servlet implementation class VideoServlet
 */
@WebServlet( urlPatterns= { "/youtube/detail-video" })
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Show detail video
		HttpSession session = req.getSession();
		String videoId = req.getParameter("vid");
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		VideoDAO dao = new VideoDAO();
		Video vd = dao.findById(videoId);
		req.setAttribute("video", vd);
		FavoriteDAO daoFA = new FavoriteDAO();
		Favorite fa = daoFA.checkVideoFavorite(user.getId(), videoId);
		req.setAttribute("favorite", fa);
		
		//show video ngẫu nhiên bên cạnh
		List<Video> list = dao.findAll();
		// xáo trộn mảng
        Collections.shuffle(list);

        // lấy ngẫu nhiên 8 phần tử trong mảng đã xáo trộn
        ArrayList<Video> sample = new ArrayList<>(list.subList(0, 8));
        req.setAttribute("list", sample);
		req.getRequestDispatcher("/views/layoutUser/detail-video.jsp").forward(req, resp);
	}

	EntityManager em = JpaUtils.getEntityManager();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("views/layoutUser/user.jsp").forward(req, resp);
	}

}

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
import DAO.FavoriteDAO;
import Entity.User;
import Entity.Video;
import Utils.JpaUtils;

@WebServlet("/youtube/favorite-video")
public class FavoriteVideoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		FavoriteDAO dao = new FavoriteDAO();
		List<Video> list = dao.findVideoFavoriteByUser(user.getId());
		req.setAttribute("videos", list);
		
		req.getRequestDispatcher("/views/layoutUser/user.jsp").forward(req, resp);
	}

	EntityManager em = JpaUtils.getEntityManager();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
	}

}

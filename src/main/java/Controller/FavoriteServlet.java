package Controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FavoriteDAO;
import Utils.JpaUtils;

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet(name = "FavoriteServlet", urlPatterns= { "/youtube/favorite" })
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = req.getParameter("userid");
		String videoid = req.getParameter("videoid");
		FavoriteDAO dao = new FavoriteDAO();
		if (dao.isLike(userid, videoid)) {
			dao.unLike(userid, videoid);
		} else {
			dao.saveLike(userid, videoid);
		}
//		req.getRequestDispatcher("/views/layoutUser/detail-video.jsp").forward(req, resp);
		resp.sendRedirect("/Asm_Java_Youtube/youtube/detail-video?vid=" + videoid);
	}

	EntityManager em = JpaUtils.getEntityManager();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.servlet;

import fpw.milestone.model.NewsFactory;
import fpw.milestone.model.CommentFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marty
 */
@WebServlet(name = "NewsDetail", urlPatterns = {"/notizia.html"})
public class NewsDetail extends PageServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// load general content
		super.processRequest(request, response);

		// GET nid parameter
		int nid = getIntParameter(request, "nid");

		HttpSession session = request.getSession();
		// if POST comment-submit (only after being logged in), insert comment
		if (request.getParameter("comment-submit")!=null
				&& request.getParameter("comment")!=null
				&& !request.getParameter("comment").isEmpty()
				&& session!=null
				&& session.getAttribute("loggedIn")!=null
				&& session.getAttribute("loggedIn").equals(true)) {
			int userId = (int)session.getAttribute("id");
			int commentId = CommentFactory.getInstance().insertCommentByNewsId(request.getParameter("comment"), nid, userId);
			request.setAttribute("updated", (commentId > 0));
		}
		// if POST comment-delete-submit (only after being logged in), delete comment
		else if (request.getParameter("comment-delete-submit")!=null
				&& request.getParameter("commentId")!=null
				&& session!=null
				&& session.getAttribute("loggedIn")!=null
				&& session.getAttribute("loggedIn").equals(true)) {
			int userId = (int)session.getAttribute("id");
			int commentId = CommentFactory.getInstance().deleteCommentByNewsId(request.getParameter("commentId"), nid, userId, getIntParameter(request, "commentId"));
			request.setAttribute("updated", (commentId > 0));
		}

		// request data
		request.setAttribute("item", NewsFactory.getInstance().getNewsById(nid));
		request.setAttribute("comments", CommentFactory.getInstance().getCommentsByNewsId(nid));
		// an empty list will be displayed if item is null
		request.getRequestDispatcher("/WEB-INF/jsp/notizia.jsp").forward(request, response);
	}

}

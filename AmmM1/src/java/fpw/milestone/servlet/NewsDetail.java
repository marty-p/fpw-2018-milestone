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
		request.setAttribute("item", NewsFactory.getInstance().getNewsById(nid));
		request.setAttribute("comments", CommentFactory.getInstance().getCommentsByNewsId(nid));
		// an empty list will be displayed if item is null
		request.getRequestDispatcher("/WEB-INF/jsp/notizia.jsp").forward(request, response);
	}

}

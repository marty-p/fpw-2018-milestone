/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.servlet;

import fpw.milestone.model.User;
import fpw.milestone.model.NewsFactory;
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
@WebServlet(name = "Articles", urlPatterns = {"/articoli.html"})
public class Articles extends PageServlet {

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

		// if not author, 403
		HttpSession session = request.getSession();
		if (session == null
				|| session.getAttribute("loggedIn") == null
				|| !session.getAttribute("loggedIn").equals(true)
				|| session.getAttribute("category") == null
				|| !((User.Category)session.getAttribute("category")).equals(User.Category.AUTHOR)) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Solo gli Autori possono accedere a questa pagina.");
			return;
		}

		// if GET/POST deleteme is specified, delete GET/POST id article
		if (request.getParameter("deleteme") != null) {
			int deleteId = getIntParameter(request, "id");
			NewsFactory.getInstance().deleteNewsById(deleteId, (Integer)session.getAttribute("id"));
		}

		request.setAttribute("articles",
			NewsFactory.getInstance().getNewsByAuthor((Integer)session.getAttribute("id"))
		);
		request.getRequestDispatcher("/WEB-INF/jsp/articoli.jsp").forward(request, response);
	}
}

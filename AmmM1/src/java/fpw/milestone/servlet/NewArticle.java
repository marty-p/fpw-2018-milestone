/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.servlet;

import fpw.milestone.model.NewsFactory;
import fpw.milestone.model.User;
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
@WebServlet(name = "NewArticle", urlPatterns = {"/scriviArticolo.html"})
public class NewArticle extends PageServlet {

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

		int userId = (int)session.getAttribute("id");
		// if POST data is sent
		if (request.getParameter("submit") != null) {
			// if GET edit is present, send update, otherwise insert with redirect
			if (request.getParameter("edit") != null) {
				int editId = getIntParameter(request, "edit");
				request.setAttribute("updated", NewsFactory.getInstance().updateNewsByRequest(request, editId, userId));
			} else {
				// it may require a redirect to ?edit=newid and use setAttribute item in milestone3
				// in case a new article has been inserted
				int editId = NewsFactory.getInstance().insertNewsByRequest(request, userId);
				response.sendRedirect("scriviArticolo.html?edit="+editId);
				return;
			}
		}

		// if GET edit is present, load pre-set information
		if (request.getParameter("edit") != null) {
			int editId = getIntParameter(request, "edit");
			request.setAttribute("item", NewsFactory.getInstance().getNewsById(editId));
		}

		request.getRequestDispatcher("/WEB-INF/jsp/scriviArticolo.jsp").forward(request, response);
	}

}

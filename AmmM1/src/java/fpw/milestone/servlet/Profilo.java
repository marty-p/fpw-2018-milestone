/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpw.milestone.model.UserFactory;

/**
 *
 * @author Marty
 */
@WebServlet(name = "Profilo", urlPatterns = {"/profilo.html"})
public class Profilo extends PageServlet {

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

		// if not logged in, 403
		HttpSession session = request.getSession();
		if (session == null
				|| session.getAttribute("loggedIn") == null
				|| !session.getAttribute("loggedIn").equals(true)
				|| session.getAttribute("id") == null) {
			response.sendError(response.SC_UNAUTHORIZED, "Solo chi si logga può accedere a questa pagina.");
			return;
		}

		// if POST data is sent
		if (request.getParameter("submit") != null) {
			request.setAttribute("updated", true);
			request.setAttribute("item", UserFactory.getInstance().getUserById((int)session.getAttribute("id")));
			request.getRequestDispatcher("/WEB-INF/jsp/profiloView.jsp").forward(request, response);
			return;
		}

		// if GET/POST deleteme is specified, delete current user and redirect
		if (request.getParameter("deleteme") != null) {
			if (UserFactory.getInstance().deleteUserById((int)session.getAttribute("id"))) {
				// force logout
				session.invalidate();
				// redirect to homepage
				response.sendRedirect("notizie.html");
				return;
			}
		}

		// if GET uid (user id) is specified, view user's id's profile
		if (request.getParameter("uid") != null) {
			int uid = getIntParameter(request, "uid");;
			request.setAttribute("item", UserFactory.getInstance().getUserById(uid));
			request.getRequestDispatcher("/WEB-INF/jsp/profiloView.jsp").forward(request, response);
			return;
		}

		// if nothing is done, show how to edit your profile
		request.setAttribute("item", UserFactory.getInstance().getUserById((int)session.getAttribute("id")));
		request.getRequestDispatcher("/WEB-INF/jsp/profiloEdit.jsp").forward(request, response);
	}

}

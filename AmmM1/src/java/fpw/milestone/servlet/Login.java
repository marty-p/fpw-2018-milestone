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
import fpw.milestone.model.User;

/**
 *
 * @author Marty
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"})
public class Login extends PageServlet {

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

		HttpSession session = request.getSession();
		// if parameter GET logout is set, destroy the session
		if (request.getParameter("logout") != null)
		{
			session.invalidate();
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}

		// Controlla se l'user stia effettuando un login
		if (request.getParameter("submit") != null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (username != null && password != null) {
				User u = UserFactory.getInstance().ProcessLogin(username, password);
				// Se l'user è stato trovato, assegna la session
				if (u != null) {
					session.setAttribute("loggedIn", true);
					session.setAttribute("id", u.getId());
					session.setAttribute("name", u.getName());
					session.setAttribute("surname", u.getSurname());
					session.setAttribute("category", u.getCategory());
				}
				// Altrimenti, mostra la pagina di login
				else {
					request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
					return;
				}
			}
		}

		// Nel caso l’utente non sia autenticato, deve mostrare il form di login e verificare username e password nel caso siano inviate tramite il form
		if (session.getAttribute("loggedIn") == null || !session.getAttribute("loggedIn").equals(true)) {
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}

		// Nel caso l’utente sia già stato autenticato (durante la gestione della richiesta corrente o ad una precedente)
		// deve riportare alla pagina con l’elenco delle notizie. Usate una redirect.
		response.sendRedirect("notizie.html");
	}

}

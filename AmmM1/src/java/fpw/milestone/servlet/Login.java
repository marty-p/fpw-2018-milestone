/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
public class Login extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();

		// Se è impostato il parametro GET logout, distrugge la sessione
		if (request.getParameter("logout") != null)
		{
			session.invalidate();
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}

		// Controlla se l'user stia effettuando un login
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

		// Nel caso l’utente non sia autenticato, deve mostrare il form di login e verificare username e password nel caso siano inviate tramite il form
		if (session.getAttribute("loggedIn") == null || !session.getAttribute("loggedIn").equals(true)) {
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}

		// Nel caso l’utente sia già stato autenticato (durante la gestione della richiesta corrente o ad una precedente)
		// deve riportare alla pagina con l’elenco delle notizie. Usate una redirect.
		response.sendRedirect("notizie.html");
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}

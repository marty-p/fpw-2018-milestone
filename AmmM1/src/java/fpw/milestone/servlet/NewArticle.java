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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marty
 */
@WebServlet(name = "NewArticle", urlPatterns = {"/scriviArticolo.html"})
public class NewArticle extends HttpServlet {

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
		// if not author, 403
		HttpSession session = request.getSession();
		if (session == null
				|| session.getAttribute("loggedIn") == null
				|| !session.getAttribute("loggedIn").equals(true)
				|| session.getAttribute("category") == null
				|| !((User.Category)session.getAttribute("category")).equals(User.Category.AUTHOR)) {
			response.sendError(response.SC_UNAUTHORIZED, "Solo gli Autori possono accedere a questa pagina.");
			return;
		}
		// if edit GET is present, load pre-set information
		if (request.getParameter("edit") != null) {
			int editId = 0;
			try {
				editId = Integer.parseInt(request.getParameter("edit"));
			} catch (NumberFormatException e) {
			} finally {
				request.setAttribute("item", NewsFactory.getInstance().getNewsById(editId));
			}
		}
		// if POST data is sent
		String title = request.getParameter("title");
		if (title != null) {
			request.setAttribute("updated", true);
			// it may require a redirect to ?edit=newid and use setAttribute item in milestone3
			// in case a new article has been inserted
		}
		request.getRequestDispatcher("/WEB-INF/jsp/scriviArticolo.jsp").forward(request, response);
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

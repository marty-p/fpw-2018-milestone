/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.servlet;

import fpw.milestone.model.News;
import fpw.milestone.model.User;
import fpw.milestone.model.UserFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marty
 */
@WebServlet(name = "Filter", urlPatterns = {"/filter.json"})
public class Filter extends PageServlet {

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
		response.setContentType("text/html;charset=UTF-8");
		String q = request.getParameter("q");
		if (q != null) {
			// if empty, show all
			if (q.isEmpty()) {
				request.setAttribute("categoryList", News.Category.getValues());
				request.setAttribute("authorList", UserFactory.getInstance().getUsersByCategory(User.Category.AUTHOR));
			}
			else {
				// todo
			}
			response.setContentType("application/json");
			response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			request.getRequestDispatcher("/WEB-INF/jsp/ajax/search.jsp").forward(request, response);
		}
	}

}

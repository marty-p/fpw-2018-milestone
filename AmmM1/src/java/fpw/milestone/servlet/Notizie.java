/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.milestone.servlet;

import fpw.milestone.model.NewsFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marty
 */
@WebServlet(name = "Notizie", urlPatterns = {"/notizie.html"})
public class Notizie extends PageServlet {

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

		// if cid (category id) is specified, process by category instead of all
		if (request.getParameter("cid") == null) {
			request.setAttribute("newsList", NewsFactory.getInstance().getNews());
		}
		else {
			int cid = 0;
			try {
				cid = Integer.parseInt(request.getParameter("cid"));
			} catch (NumberFormatException e) {
			} finally {
				request.setAttribute("newsList", NewsFactory.getInstance().getNewsByCategory(cid));
				request.setAttribute("categoryName", fpw.milestone.model.News.Category.fromInteger(cid).name());
			}
		}

		request.getRequestDispatcher("/WEB-INF/jsp/notizie.jsp").forward(request, response);
	}

}

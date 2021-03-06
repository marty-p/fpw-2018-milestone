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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Used as default general servlet for each web page
 * @author Marty
 */

public abstract class PageServlet extends HttpServlet {

	/**
	 *
	 * @param request
	 * @param param
	 * @return
	 */
	protected int getIntParameter(HttpServletRequest request, String param) {
		return getIntParameter(request, param, 0);
	}

	/**
	 *
	 * @param request
	 * @param paramName
	 * @param defaultValue
	 * @return
	 */
	protected int getIntParameter(HttpServletRequest request, String paramName, int defaultValue) {
		int retValue = defaultValue;
		try {
			retValue = Integer.parseInt(request.getParameter(paramName));
		} catch (NumberFormatException e) {
		}
		return retValue;
	}

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
		request.setAttribute("categoryList", News.Category.getValues());
		request.setAttribute("authorList", UserFactory.getInstance().getUsersByCategory(User.Category.AUTHOR));
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

package com.youcode.pharmajava.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youcode.pharmajava.dao.PharmaDAO;
import com.youcode.pharmajava.model.Pharma;



@WebServlet("/")
public class PharmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PharmaDAO medicDAO;
	
	public void init() {
		medicDAO = new PharmaDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertItem(request, response);
				break;
			case "/delete":
				deleteItem(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateItem(request, response);
				break;
			default:
				listItem(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listItem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Pharma> listItem = medicDAO.selectAllItem();
		request.setAttribute("listItem", listItem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("medicament-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("medicament-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Pharma existingItem = medicDAO.selectItem(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("medicament-form.jsp");
		request.setAttribute("item", existingItem);
		dispatcher.forward(request, response);

	}

	private void insertItem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String item = request.getParameter("item");
		String company = request.getParameter("company");
		String price = request.getParameter("price");
		Pharma newItem = new Pharma(item, company, price);
		medicDAO.insertItem(newItem);
		response.sendRedirect("list");
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String item = request.getParameter("item");
		String company = request.getParameter("company");
		String price = request.getParameter("price");

		Pharma book = new Pharma(id, item, company, price);
		medicDAO.updateItem(book);
		response.sendRedirect("list");
	}

	private void deleteItem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		medicDAO.deleteItem(id);
		response.sendRedirect("list");

	}

}

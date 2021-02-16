package com.youcode.Pharmacie.Controlleur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youcode.Pharmacie.dao.ArticlesDAOimp;
import com.youcode.Pharmacie.model.Article;


@WebServlet("/")
public class ArticlesServlet extends HttpServlet {
	private ArticlesDAOimp articlesDAOimp;
	private Article newArticle;

	public void init() {
		articlesDAOimp = new ArticlesDAOimp();
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
				save(request, response);
				break;
			case "/delete":
				delete(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				update(request, response);
				break;
			default:
				listArticle(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listArticle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Article> listArticle = articlesDAOimp.getAll();
		request.setAttribute("listArticle", listArticle);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}


	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Article existingUser = articlesDAOimp.getById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("item", existingUser);
		dispatcher.forward(request, response);

	}

	private void save(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String nom = request.getParameter("nom");
		String company = request.getParameter("company");
		int price =  Integer.parseInt(request.getParameter("price"));
		int qun = Integer.parseInt(request.getParameter("qun"));
		String description = request.getParameter("description");
		Article newArticle = new Article( nom, company, price,qun , description);
		articlesDAOimp.save(newArticle);
		response.sendRedirect("list");
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String company = request.getParameter("company");
		int price = Integer.parseInt(request.getParameter("price"));
		int qun = Integer.parseInt(request.getParameter("qun"));
		String description = request.getParameter("description");

		Article book = new Article(id, nom, company, price,qun,description);
		articlesDAOimp.update(book);
		response.sendRedirect("list");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		articlesDAOimp.delete(id);
		response.sendRedirect("list");

	}

}

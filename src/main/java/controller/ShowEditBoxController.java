package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.category;
import entity.product;

/**
 * Servlet implementation class ShowEditBoxController
 */
@WebServlet(name = "showEditBox", urlPatterns = { "/showEditBox" })
public class ShowEditBoxController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String pid = request.getParameter("pid");
				DAO dao = new DAO();
				product p = dao.getProductByPid(pid);
				List<category> listC = dao.getAllCategory();
				request.setAttribute("p", p);
				request.setAttribute("listC", listC);
				request.getRequestDispatcher("edit.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

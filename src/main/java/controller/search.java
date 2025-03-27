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
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txt = request.getParameter("txt");
		request.setCharacterEncoding("UTF-8");
		DAO dao = new DAO();
		List<product> list = dao.getProductBySearchTxt(txt);
		List<category> listC = dao.getAllCategory();
		request.setAttribute("listC", listC);
		request.setAttribute("listProduct", list);
		request.setAttribute("txtV", txt);
		request.getRequestDispatcher("/shop-grid.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}

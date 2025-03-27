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
 * Servlet implementation class HomeController
 */
@WebServlet("/index")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get data from dao
		DAO dao = new DAO();
		List<product> list = dao.getAllProduct();
		List<category> listC =dao.getAllCategory();
		List<product> listLast =dao.getLast();
		// set data den trang jsp
		request.setAttribute("listProduct", list);
		request.setAttribute("listC", listC);
		request.setAttribute("lastP", listLast);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	

}
}
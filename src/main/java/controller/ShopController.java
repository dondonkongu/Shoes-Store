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
 * Servlet implementation class ShopController
 */
@WebServlet("/shop-grid")
public class ShopController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		List<category> listC =dao.getAllCategory();
		String cateID = request.getParameter("cid");// 
		List<product> listP=dao.getProductByCid(cateID);
		List<product> listProduct= dao.getAllProduct();
		request.setAttribute("listC", listC);
		request.setAttribute("listProduct",listP);
		request.setAttribute("tag", cateID);
		request.getRequestDispatcher("shop-grid.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
public static void main(String[] args) {
	DAO dao = new DAO();
	List<product> listProduct= dao.getAllProduct();
	for(product o:listProduct) {
		System.out.println(o);
	}

}
}

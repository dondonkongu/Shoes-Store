package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.account;

/**
 * Servlet implementation class SignupController
 */
@WebServlet(name = "signup", urlPatterns = { "/signup" })
public class SignupController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		DAO dao = new DAO();
		account acc = dao.checkUserDuplicate(user); 
		if(acc!=null) {
			request.setAttribute("mess", "tên tài khoản đã tồn tại");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}else {
			if(!pass.equals(repass)) {
				request.setAttribute("mess", "mật khẩu không khớp");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}else {
				dao.sigup(user, pass);
				response.sendRedirect("login.jsp");
			}

		}
		
		
	}

}

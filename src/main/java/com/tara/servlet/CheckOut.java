package com.tara.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tara.dao.CartDao;


public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		//print.write("<h2>Hello from Checkout</h2>");
		
		CartDao cartdao = new CartDao();
		cartdao.checkOutAllCartItem();
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		if(dispatcher!=null) {
			dispatcher.forward(request, response);
		}
		
	}

}

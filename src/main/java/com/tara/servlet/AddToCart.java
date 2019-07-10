package com.tara.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tara.dao.CartDao;
import com.tara.model.ItemBean;

public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String itemName = request.getParameter("itemName");
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		int itemQuantity = 1;
		String itemImage = request.getParameter("itemImage");
		ItemBean item1 = new ItemBean();
		item1.setItemId(itemId);
		item1.setItemName(itemName);
		item1.setItemPrice(itemPrice);
		item1.setItemQuantity(itemQuantity);
		item1.setItemImage(itemImage);
		CartDao cartdao = new CartDao();
		cartdao.addItemtoCart(item1);
		
		List cartData = cartdao.getAllCartItem();
		request.setAttribute("cartData", cartData);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
		if(dispatcher!=null) {
			dispatcher.forward(request, response);
		}
		
		
//		print.write("<h1> Hello to "+itemPrice+"  From Request</h1>");
//		print.write("<h1> Hello to "+itemQuantity+"  From Request</h1>");
//		print.write("<h1> Hello to "+itemImage+"  From Request</h1>");
//		print.write("<h1> Hello to "+itemId+"  From Request</h1>");
//		print.write("<h1> Hello to "+itemName+"  From Request</h1>");
//
	}

}

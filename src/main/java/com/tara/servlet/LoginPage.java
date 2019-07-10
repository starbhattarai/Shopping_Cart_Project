package com.tara.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tara.dao.ItemDao;
import com.tara.dao.LoginDao;
import com.tara.model.UserBean;


public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				response.setContentType("text/html");
				//PrintWriter print = response.getWriter();
				HttpSession session = request.getSession();
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				
				LoginDao dao = new LoginDao();
				UserBean user1 = dao.getUser(userName);
			
				if(userName.equals(user1.getUserName()) && password.equals(user1.getPassword())) {
					
					session.setAttribute("userName",userName);
					session.setAttribute("password",password);
					
					ItemDao itemdao = new ItemDao();
					List itemData = itemdao.getAllItem();
					request.setAttribute("itemData", itemData);
					RequestDispatcher dispatcher = request.getRequestDispatcher("item.jsp");
					if(dispatcher!=null) {
						dispatcher.forward(request, response);
					}
					
				}else {
					
					String information = "Either Password or User Name is incorrect.<br>";
					request.setAttribute("information", information);
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}
				
	}

}

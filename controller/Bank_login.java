package com.bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.Bank_DAO;
import com.bank.dbconnection.DB_Connection;

@WebServlet("/Bank_login")
public class Bank_login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Bank_DAO fdc=null;
		String login=null;
		
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		
		try {
			fdc=new Bank_DAO(DB_Connection.getConnection());
			
			login=fdc.login_cust(username,pwd);
			HttpSession se=request.getSession();
			if(login!=null) {
				se.setAttribute("login", login);
				response.sendRedirect("depositeORCheckBalance.jsp");
			}
			else{
				System.out.println("EmailId And PassWord Is Incorrect...!!!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

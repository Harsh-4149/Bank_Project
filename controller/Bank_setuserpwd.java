package com.bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.bo.Bank_Encapsulation;
import com.bank.dao.Bank_DAO;
import com.bank.dbconnection.DB_Connection;


@WebServlet("/Bank_setuserpwd")
public class Bank_setuserpwd extends HttpServlet {
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Bank_Encapsulation fe=null;
		Bank_DAO fdc=null;
		boolean f=false;
		
		String n=request.getParameter("name");
		System.out.println(n);
		String c=request.getParameter("username");
		System.out.println(c);
		String b=request.getParameter("pwd");
		System.out.println(b);
		
		fe=new Bank_Encapsulation();
		fe.setName(n);
		fe.setUsername(c);
		fe.setPwd(b);
		
		
		try {
			fdc=new Bank_DAO(DB_Connection.getConnection());
			f=fdc.bank_setuserpassinsert(fe);
			if(f) {
				System.out.println("Data Inserted...!!!");
				response.sendRedirect("afterCustRegistration.jsp");
			}
			
		}
		catch(Exception se) {
			se.printStackTrace();
		}

	}

}

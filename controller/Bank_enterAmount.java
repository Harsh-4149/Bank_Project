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

@WebServlet("/Bank_enterAmount")
public class Bank_enterAmount extends HttpServlet {
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
		
		String fname=request.getParameter("fullname");
		float n=Float.parseFloat(request.getParameter("amount"));
		System.out.println(n);
		
		fe=new Bank_Encapsulation();
		fe.setFullname(fname);
		fe.setAmount(n);
		
		
		try {
			fdc=new Bank_DAO(DB_Connection.getConnection());
			f=fdc.bank_enteramount(fe);
			if(f) {
				System.out.println("Data Inserted...!!!");
				response.sendRedirect("sucessfullydeposite.jsp");
			}
			
		}
		catch(Exception se) {
			se.printStackTrace();
		}


	}

}

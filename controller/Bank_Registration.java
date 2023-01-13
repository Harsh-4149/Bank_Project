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

@WebServlet("/Bank_Registration")
public class Bank_Registration extends HttpServlet {
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		Bank_Encapsulation fe=null;
		Bank_DAO fdc=null;
		boolean f=false;
		
		String n=request.getParameter("customer_name");
		System.out.println(n);
		String c=request.getParameter("customer_address");
		System.out.println(c);
		String b=request.getParameter("adharcard_no");
		System.out.println(b);
		String g=request.getParameter("mobile_no");
		System.out.println(g);
		String em=request.getParameter("account_type");
		System.out.println(em);
		String p=request.getParameter("gender");
		System.out.println(p);
		
		fe=new Bank_Encapsulation();
		fe.setCustomer_name(n);
		fe.setCustomer_address(c);
		fe.setAdharcard_no(b);
		fe.setMobile_no(g);
		fe.setAccount_type(em);
		fe.setGender(p);
		
		
		try {
			fdc=new Bank_DAO(DB_Connection.getConnection());
			f=fdc.bank_custinsert(fe);
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

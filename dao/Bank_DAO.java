package com.bank.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.bo.Bank_Encapsulation;

public class Bank_DAO {
	public static Connection con;

	public Bank_DAO(Connection con) {
		this.con=con;
	}
	public boolean bank_custinsert(Bank_Encapsulation e) throws SQLException {
		// query
		final String INSERT_QUERY = "INSERT INTO CREATE_ACCOUNT(CUSTOMER_NAME,CUSTOMER_ADDRESS,ADHARCARD_NO,MOBILE_NO,ACCOUNT_TYPE,GENDER) VALUES(?,?,?,?,?,?)";
        
		PreparedStatement ps = null;
		boolean fdc = false;
         
		ps=con.prepareStatement(INSERT_QUERY);

		ps.setString(1, e.getCustomer_name());
		ps.setString(2, e.getCustomer_address());
		ps.setString(3, e.getAdharcard_no());
		ps.setString(4, e.getMobile_no());
		ps.setString(5, e.getAccount_type());
		ps.setString(6, e.getGender());

		int i = ps.executeUpdate();
		System.out.println(i);
		if (i == 1) {
			System.out.println("Registration Succesfully Completed...!!!");
			fdc = true;
		}
		return fdc;
	}// insert method

	
	public boolean bank_setuserpassinsert(Bank_Encapsulation e)throws SQLException {
		//query final String
		final String INSERT_QUERY="INSERT INTO LOGINDATA(NAME,USERNAME,PWD) VALUES(?,?,?)";

		PreparedStatement ps=null;
		boolean fdc=false;

		ps=con.prepareStatement(INSERT_QUERY);

		ps.setString(1, e.getName()); 
		ps.setString(2, e.getUsername());
		ps.setString(3, e.getPwd());
		

		int i=ps.executeUpdate(); 
		System.out.println(i); 
		if(i==1) {
			System.out.println("Set User Name and Password  Succesfully Completed...!!!");
			fdc=true; 
		}
		return fdc;
	}//insert method
      
	
	public boolean bank_enteramount(Bank_Encapsulation e)throws SQLException {
		//query final String
		final String INSERT_QUERY="INSERT INTO ENTER_AMOUNT(FULLNAME,AMOUNT) VALUES(?,?)";

		PreparedStatement ps=null;
		boolean fdc=false;

		ps=con.prepareStatement(INSERT_QUERY);
		
		ps.setString(1, e.getFullname());
		ps.setFloat(2, e.getAmount());

		int i=ps.executeUpdate(); 
		System.out.println(i); 
		if(i==1) {
			System.out.println("Enter Amount  Succesfully Completed...!!!");
			fdc=true; 
		}
		return fdc;
	}//insert method

	 
	public List<Bank_Encapsulation> showAllRecord() throws SQLException {
		// query
		final String SHOW_ALLRECORD = "SELECT * FROM CREATE_ACCOUNT";

		List<Bank_Encapsulation> l = new ArrayList<Bank_Encapsulation>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Bank_Encapsulation fe = null;

		ps = con.prepareStatement(SHOW_ALLRECORD);
		rs = ps.executeQuery();
		while (rs.next()) {
			fe = new Bank_Encapsulation();
			fe.setCustomer_name(rs.getString(1));
			fe.setCustomer_address(rs.getString(2));
			fe.setAdharcard_no(rs.getString(3));
			fe.setMobile_no(rs.getString(4));
			fe.setAccount_type(rs.getString(5));
			fe.setGender(rs.getString(6));
			fe.setAccount_no(rs.getInt(7));

			l.add(fe);
		}
		return l;
	}// showAllRecord method

	public List<Bank_Encapsulation> showAllRecordlogin() throws SQLException {
		// query
		final String SHOW_ALLRECORD = "SELECT * FROM LOGINDATA";

		List<Bank_Encapsulation> l = new ArrayList<Bank_Encapsulation>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Bank_Encapsulation fe = null;

		ps = con.prepareStatement(SHOW_ALLRECORD);
		rs = ps.executeQuery();
		while (rs.next()) {
			fe = new Bank_Encapsulation();
			fe.setName(rs.getString(1));
			fe.setUsername(rs.getString(2));
			fe.setPwd(rs.getString(3));
			
			l.add(fe);
		}
		return l;
	}// showAllRecordlogin method
     
	public List<Bank_Encapsulation> showAllRecordAmount() throws SQLException {
		// query
		final String SHOW_ALLRECORD = "SELECT * FROM ENTER_AMOUNT";

		List<Bank_Encapsulation> l = new ArrayList<Bank_Encapsulation>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Bank_Encapsulation fe = null;

		ps = con.prepareStatement(SHOW_ALLRECORD);
		rs = ps.executeQuery();
		while (rs.next()) {
			fe = new Bank_Encapsulation();
			fe.setFullname(rs.getString(1));
			fe.setAmount(rs.getFloat(2));
			
			l.add(fe);
		}
		return l;
	}// showAllRecordlogin method

	
	
	
//	public Bank_Encapsulation search(int i) throws SQLException {
//		// query
//		final String SEARCH = "SELECT * FROM CREATE_ACCOUNT WHERE ACCOUNT_NO=?";
//
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		Bank_Encapsulation fe = null;
//
//		ps = con.prepareStatement(SEARCH);
//		ps.setInt(1, i);
//		rs = ps.executeQuery();
//		while (rs.next()) {
//			fe = new Bank_Encapsulation();
//
//			fe.setCustomer_name(rs.getString(1));
//			fe.setCustomer_address(rs.getString(2));
//			fe.setAdharcard_no(rs.getString(3));
//			fe.setMobile_no(rs.getString(4));
//			fe.setAccount_type(rs.getString(5));
//			fe.setGender(rs.getString(6));
//			fe.setAccount_no(rs.getInt(7));
//
//		}
//		return fe;
//	}// search method

	
	  public Bank_Encapsulation idpasssearch(String i) throws SQLException{
		  //query
	  final String SEARCH="SELECT * FROM LOGINDATA WHERE USERNAME=?";
	  
	  PreparedStatement ps=null; 
	  ResultSet rs=null; 
	  Bank_Encapsulation fe=null;
	  
	  ps=con.prepareStatement(SEARCH);
	  ps.setString(1, i);
	  rs=ps.executeQuery();
	  while(rs.next()) {
		  fe=new Bank_Encapsulation();
	  
	  fe.setName(rs.getString(1)); fe.setUsername(rs.getString(2));
	  fe.setPwd(rs.getString(3)); 
	  
	  } return fe; 
	  
  }//search method
	 

	
	public String login_cust(String username, String pwd) throws SQLException {
		//query final String
		final String CHECH_VALIDATE="SELECT * FROM LOGINDATA WHERE USERNAME=? AND PWD=?";

		PreparedStatement ps=null; ResultSet rs=null; Bank_Encapsulation fen=null;
		String login=null;

		ps=con.prepareStatement(CHECH_VALIDATE);
		ps.setString(1, username);
		ps.setString(2,pwd);

		rs=ps.executeQuery();
		while(rs.next()) {
			fen=new Bank_Encapsulation();
		fen.setName(rs.getString(1));
		fen.setUsername(rs.getString(2));
		fen.setPwd(rs.getString(3)); 
		if(username.equals(fen.getUsername()) && (pwd.equals(fen.getPwd()))) {
			login=fen.getName(); 
			break;
			} 
		} return login;
	}//validate method
	 
}// class

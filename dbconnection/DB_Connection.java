package com.bank.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
	private static Connection con;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url= "jdbc:mysql://localhost:3306/bank_proj";
		String username= "root";
		String password= "";
		try {
			con=DriverManager.getConnection(url, username, password);
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		return con;
				
	}

}

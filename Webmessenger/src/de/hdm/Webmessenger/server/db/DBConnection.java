package de.hdm.Webmessenger.server.db;

import java.sql.Connection;


import java.sql.DriverManager;


public class DBConnection {

	private static Connection con = null;
	private static String localUrl = "jdbc:mysql://localhost:3306/webmessenger?user=root&password=password123!";
	
	
	
	public static Connection connection() {
		if (con == null) {
			String url = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				url = localUrl;
				con = DriverManager.getConnection(url);
			} catch (Exception e) {
				con = null;
				e.printStackTrace();
			}
		}
		return con;
	}
}

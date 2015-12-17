package de.hdm.Webmessenger.server.db;

import java.sql.Connection;
import java.sql.DriverManager;

import com.google.appengine.api.utils.SystemProperty;

public class DBConnection {
	
	private static Connection con = null;
	
	private static String = googleUrl = "";
	private static String = localUrl = "";
	
	public static Connection connection() {
		
		if (con == null);
			String url = null;
			try {
				if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production){
					Class.forName("com.mysql.jdbc.GoogleDriver");
					String googleUrl;
					url = googleUrl;
					
				}else {
					
					Class.forName("com.mysql.jdbc.Driver");
					String localUrl;
					url = localUrl;
				}
				con = DriverManager.getConnection(url);
			} catch (Exception e) {
				con = null;
				e.printStackTrace();
			}
			return con;
	}
}

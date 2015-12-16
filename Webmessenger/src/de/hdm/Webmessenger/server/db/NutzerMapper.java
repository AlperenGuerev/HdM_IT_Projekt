package de.hdm.Webmessenger.server.db;

import java.sql.*;

import de.hdm.Webmessenger.shared.bo.*;

public class NutzerMapper {

	
	private static NutzerMapper n = null;
	
	
	protected NutzerMapper() {};
	
	
	public static NutzerMapper nutzerMapper(){
		if (n == null) {
			n = new NutzerMapper();
		}
		return n;
	}
	
	public Nutzer insert(Nutzer a){
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT MAX(NutzerId) AS maxid "
          + "FROM nutzer");
			
			if(rs.next()){
				a.setId(rs.getInt("maxid")+1);
				
				stmt = con.createStatement();
				
				stmt.executeUpdate("INSERT INTO nutzer (NutzerId, Email, Vorname, Nachname, Passwort)" + 
				"VALUES (" + a.getId() + ",'" + a.getEmail() + "','" + a.getVorname() + "','" + a.getNachname() + "','" + a.getPassword() +"')");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
}

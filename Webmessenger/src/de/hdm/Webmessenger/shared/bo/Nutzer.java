package de.hdm.Webmessenger.shared.bo;

public class Nutzer extends BusinessObject {
	
	public static final long serialVersionUID = 1L;
	
	private String vorname = null;
	private String nachname = null;
	private String email = null;
	private String password = null;
	
	
	
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	


}

package de.hdm.Webmessenger.server;

import de.hdm.Webmessenger.shared.*;
import de.hdm.Webmessenger.shared.bo.Nutzer;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import de.hdm.Webmessenger.server.db.*;
import com.google.gwt.user.client.Window;

/**
 * Serverseitige Implementierung des Verwaltungsinterfaces.
 */
@SuppressWarnings("serial")
public class WebmessengerVerwaltungImpl extends RemoteServiceServlet implements
		WebmessengerVerwaltung {

	
private NutzerMapper nutzerMapper = null;
	
	
	public WebmessengerVerwaltungImpl() throws IllegalArgumentException{};
	
	
	public void init() throws IllegalArgumentException{
		this.nutzerMapper = NutzerMapper.nutzerMapper();
	}
	
	
	public Nutzer nutzerErstellen(String vorname, String nachname, String email, String password)
			throws IllegalArgumentException {
		
		Nutzer a = new Nutzer();
		a.setVorname(vorname);
		a.setNachname(nachname);
		a.setEmail(email);
		a.setPassword(password);
		a.setId(1);
		
		
		
		return this.nutzerMapper.insert(a);
		
		
		
	}
	
	}


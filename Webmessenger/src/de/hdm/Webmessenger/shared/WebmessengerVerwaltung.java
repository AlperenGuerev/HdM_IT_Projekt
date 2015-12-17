package de.hdm.Webmessenger.shared;

import de.hdm.Webmessenger.shared.bo.*;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath ("WebmessengerVerwaltung")
public interface WebmessengerVerwaltung extends RemoteService {
	
	
	public void init() throws IllegalArgumentException;
	
	
	public Nutzer nutzerErstellen(String vorname, String nachname, String email, String password)
	throws IllegalArgumentException;
		
	}

package de.hdm.Webmessenger.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;


import de.hdm.Webmessenger.shared.bo.Nutzer;


public interface WebmessengerVerwaltungAsync {
	
	public void init(AsyncCallback<Void> callback) throws IllegalArgumentException;

	void nutzerErstellen(String vorname, String nachname, String email,
			String password, AsyncCallback<Nutzer> callback);
	
}

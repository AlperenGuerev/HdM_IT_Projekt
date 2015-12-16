package de.hdm.Webmessenger.client;

import java.util.logging.Logger;
import de.hdm.Webmessenger.shared.*;
import com.google.gwt.core.client.*;

public class ClientsideSetting extends CommonSettings {

	private static WebmessengerVerwaltungAsync webmessengerVerwaltung = null;
	
	private static final String LOGGER_NAME = "Webmessenger Web Client";
	
	private static final Logger log = Logger.getLogger(LOGGER_NAME);
	
	
	public static Logger getLogger() {
		return log;
	}
	
	
	
	public static WebmessengerVerwaltungAsync getWebmessengerVerwaltung() {
		if (webmessengerVerwaltung == null) {
			webmessengerVerwaltung = (WebmessengerVerwaltungAsync) GWT.create(WebmessengerVerwaltung.class);
			
		}
		return webmessengerVerwaltung;
	}
	
	
}

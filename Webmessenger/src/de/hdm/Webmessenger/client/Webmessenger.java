package de.hdm.Webmessenger.client;

import de.hdm.Webmessenger.shared.*;
import de.hdm.Webmessenger.shared.bo.*;

import com.google.gwt.core.client.*;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * Hauptklasse implementiert EntryPoint Interface.
 */
public class Webmessenger implements EntryPoint {
	
	
	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label("Bitte loggen Sie sich mit ihrem Google Account ein.");
	private Anchor signInLink = new Anchor("Einloggen");
	private Anchor signOutLink = new Anchor ("Ausloggen");
	
	/**
	 * Einstiegspunkt beim Start des Webmessengers.
	 */
	
	public void onModuleLoad() {
		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
			public void onFailure(Throwable error) {
			}
			
			public void onSuccess(LoginInfo result) {
				loginInfo = result;
				if(loginInfo.isLoggedIn()) {
					loadWebmessenger();
				} else{
					loadLogin();
				}
			}
		});
		
		
		
	}
	
	private void loadLogin() {
		signInLink.setHref(loginInfo.getLoginUrl());
		loginPanel.add(loginLabel);
		loginPanel.add(signInLink);
		RootPanel.get().add(loginPanel);
	}
		
	
	/*
	 * Bei erfolgreichem Login wird die Applikation geladen.
	 */
	
	
	public void loadWebmessenger() {
		
		/*
		 * Instanziierung des Webmessenger-Services. Geschieht über die Methode .getWebmessengerVerwaltung().
		 */
		 final WebmessengerVerwaltungAsync webmessengerAsync = ClientsideSetting.getWebmessengerVerwaltung(); 
		 
		 /*
		  * Texteingabefelder für Registrierungsdaten.
		  */
		 final TextBox vorname = new TextBox();
		 final TextBox nachname = new TextBox();
		 final TextBox email = new TextBox();
		 final PasswordTextBox password = new PasswordTextBox();
		 
		 final Button sendButton = new Button ("Senden"); 
		 
		 signOutLink.setHref(loginInfo.getLogoutUrl());

		 VerticalPanel panel = new VerticalPanel();
		 panel.add(vorname);
		 panel.add(nachname);
		 panel.add(email);
		 panel.add(password);
		 panel.add(sendButton);
		 panel.add(signOutLink);
		 RootPanel.get().add(panel);	
		 
		 /*
		  *  In die Textbox Strings einfügen, so dass Endnutzer weiss
		  *  welche Daten in welches Textfeld gehören. Zusätzlich Clickhandler hinzufügen um 
		  *  vordefinierten Text zu löschen.
		  */
		 vorname.setText("Vorname");
		 vorname.addClickHandler(new ClickHandler() {
			 public void onClick(ClickEvent event) {
				 vorname.setText("");
			 }
		 });
		 
		 nachname.setText("Nachname");
		 nachname.addClickHandler(new ClickHandler() {
			 public void onClick(ClickEvent event) {
				 vorname.setText("");
			 }
		 });
		 
		 email.setText("Email");
		 email.addClickHandler(new ClickHandler() {
			 public void onClick(ClickEvent event) {
				 email.setText("");
			 }
		 });
		 
		 
		 password.setText("Passwort");
		 password.addClickHandler(new ClickHandler() {
			 public void onClick(ClickEvent event) {
				 password.setText("");
			 }
		 });
		 
		 
		 /*
		  * Callback Objekt instanziieren.
		  */
		 
		 final AsyncCallback<Nutzer> callback = new AsyncCallback<Nutzer>() {
			 public void onSuccess(Nutzer result){
				 Window.alert("Registrierung erfolgreich!");
			 };
			 public void onFailure(Throwable caught){
				 caught.printStackTrace();
				 Window.alert("Registrierung nicht erfolgreich :(");
			 };
		 };
			 
		 
		 /*
		  * Durch das Drücken des Senden-Buttons wird das entsprechende Query
		  * zur Erstellung eines neuen Nutzers an die Datenbank gesendet und ausgeführt.
		  * Es wird ein neues Nutzerobjekt zurückgesendet.
		  */
		 
		 sendButton.addClickHandler(new ClickHandler(){
			 public void onClick(ClickEvent event) {
				 
				 try {
				 
				 
				 webmessengerAsync.nutzerErstellen(vorname.getText(), nachname.getText() , email.getText(), password.getText(), callback);
				 
				 } catch (Exception e) {
					 Window.alert("Fehlgeschlagen");
				 }
				 
			 }
			 
		 });
		 
		 
		 
		
		
		 
		 
		 
		
	}
}

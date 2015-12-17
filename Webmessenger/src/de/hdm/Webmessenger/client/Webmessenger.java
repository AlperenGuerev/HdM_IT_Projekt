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
				} else {
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

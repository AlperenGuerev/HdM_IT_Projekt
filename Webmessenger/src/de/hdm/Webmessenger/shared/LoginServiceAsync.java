package de.hdm.Webmessenger.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;
import de.hdm.Webmessenger.shared.bo.LoginInfo;

public interface LoginServiceAsync {
	
	public void login(String RequestUri, AsyncCallback<LoginInfo> callback);
	
}

package de.hdm.Webmessenger.shared;

import de.hdm.Webmessenger.shared.bo.*;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath ("login")
public interface LoginService extends RemoteService {
	
	public LoginInfo login(String requestUri);

}

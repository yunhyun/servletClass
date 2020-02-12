package controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator {
	PasswordAuthentication passAuth;
	
	public GoogleAuthentication() {
		passAuth = 
			new PasswordAuthentication("cyh0107","gbgqpxkkgzscqmzk");
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return passAuth;
	}
}

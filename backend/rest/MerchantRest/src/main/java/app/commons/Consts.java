package app.commons;

import java.net.URL;

public final class Consts {
	 

	public static final String MERCHANT_PASSWORD = "password";
	public static final URL ERROR_URL;
	public static final URL ACQUIRER_URL;
	
	static {
        URL errorURL;
        try {
            errorURL = new URL("http://nekiURL.com");
        } catch (java.net.MalformedURLException e) {
            errorURL = null;
        }
        ERROR_URL = errorURL;
    }
	
	
	static {
        URL acquirerURL;
        try {
        	acquirerURL = new URL("http://localhost:8080/fake");
        } catch (java.net.MalformedURLException e) {
        	acquirerURL = null;
        }
        ACQUIRER_URL = acquirerURL;
    }
	private Consts(){
		    //this prevents even the native class from 
		    //calling this ctor as well :
		    throw new AssertionError();
		  }
}

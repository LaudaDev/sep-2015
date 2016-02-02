package app.commons;

import java.net.URL;

public class UrlRegister {

	public static final URL ERROR_URL;
	public static final URL SUCCESS_URL;
	public static final URL FAILED_URL;
	public static final URL ACQUIRER_URL;

	static {
        URL errorURL;
        try {
            errorURL = new URL("https://errorURL.com");
        } catch (java.net.MalformedURLException e) {
            errorURL = null;
        }
        ERROR_URL = errorURL;
    }
	
	
	static {
        URL acquirerURL;
        try {
        	acquirerURL = new URL("https://localhost:8082/api/payment/paying");
        } catch (java.net.MalformedURLException e) {
        	acquirerURL = null;
        }
        ACQUIRER_URL = acquirerURL;
    }

	static {
        URL successURL;
        try {
        	successURL = new URL("https://localhost:8082/api/payment/success");
        } catch (java.net.MalformedURLException e) {
        	successURL = null;
        }
        SUCCESS_URL = successURL;
    }
	
	static {
        URL failedURL;
        try {
        	failedURL = new URL("https://localhost:8082/api/payment/failed");
        } catch (java.net.MalformedURLException e) {
        	failedURL = null;
        }
        FAILED_URL = failedURL;
    }
	
	
	private UrlRegister(){
		    //this prevents even the native class from 
		    //calling this ctor as well :
		    throw new AssertionError();
		  }
}

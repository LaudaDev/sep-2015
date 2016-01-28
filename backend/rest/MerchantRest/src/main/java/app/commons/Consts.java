package app.commons;

import java.net.URL;

public final class Consts {
	 

	public static final String MERCHANT_PASSWORD = "merchantPassword";
	public static final String MERCHANT_ID = "merchantId";
	public static final URL ERROR_URL;
	public static final URL SUCCESS_URL;
	public static final URL FAILED_URL;
	public static final URL ACQUIRER_URL;
	public static final int JMBG_OK = 0;
	public static final int JMBG_INVALID = 1;
	public static final int JMBG_WARNING = 2;
	
	public static final String SUCCESS_MESSAGE = "You have successfully purchased the insurance ."+
												" Thank you for your trust.";
	public static final String CARD_PROBLEM_MESSAGE = "There appears to be a problem with the card you are trying to use."+
												"Please check the data and try again ";
	
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
        	acquirerURL = new URL("http://localhost:8082/api/payment/paying");
        } catch (java.net.MalformedURLException e) {
        	acquirerURL = null;
        }
        ACQUIRER_URL = acquirerURL;
    }

	static {
        URL successURL;
        try {
        	successURL = new URL("http://localhost:8082/api/payment/success");
        } catch (java.net.MalformedURLException e) {
        	successURL = null;
        }
        SUCCESS_URL = successURL;
    }
	
	static {
        URL failedURL;
        try {
        	failedURL = new URL("http://localhost:8082/api/payment/failed");
        } catch (java.net.MalformedURLException e) {
        	failedURL = null;
        }
        FAILED_URL = failedURL;
    }
	
	
	private Consts(){
		    //this prevents even the native class from 
		    //calling this ctor as well :
		    throw new AssertionError();
		  }
}

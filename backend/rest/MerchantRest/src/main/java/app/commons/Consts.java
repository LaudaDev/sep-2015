package app.commons;

public final class Consts {
	 

	public static final String MERCHANT_PASSWORD = "merchantPassword";
	public static final String MERCHANT_ID = "merchantId";
	public static final int JMBG_OK = 0;
	public static final int JMBG_INVALID = 1;
	public static final int JMBG_WARNING = 2;
	public static final int ALT_PACKAGE_INDEX = 4;
		
	
	
	private Consts(){
		    //this prevents even the native class from 
		    //calling this ctor as well :
		    throw new AssertionError();
		  }
}

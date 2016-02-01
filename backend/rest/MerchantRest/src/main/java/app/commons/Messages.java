package app.commons;

public final class Messages {

	public static final String SUCCESS_MESSAGE;
	public static final String CARD_PROBLEM_MESSAGE;
	public static final String SERVER_PROBLEM_MESSAGE;

	static {
		SUCCESS_MESSAGE = "You have successfully purchased the insurance ." + " Thank you for your trust.";
	};

	static {
		CARD_PROBLEM_MESSAGE = "There appears to be a problem with the card you are trying to use."
				+ "Please check the data and try again ";
	};
	
	static {
		SERVER_PROBLEM_MESSAGE = "Sorry, there's a problem with the server."+
	"Please try again in a few minutes.";
	};

	private Messages() {
		// this prevents even the native class from
		// calling this ctor as well :
		throw new AssertionError();
	}
}

package app.commons;

public final class CustomIdGenerator {

	private static int transactionId = 1;
	
	
	public static int getTransactionId()
	{
		return transactionId++;
	}
}

package app.commons;

public final class RandomGenerator {

	private static int transactionId = 0;
	
	
	public static int getTransactionId()
	{
		return transactionId++;
	}
}

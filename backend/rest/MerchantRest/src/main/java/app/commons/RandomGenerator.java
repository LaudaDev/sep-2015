package app.commons;

public final class RandomGenerator {

	private static int transactionId = 1;
	
	
	public static int getTransactionId()
	{
		return transactionId++;
	}
}

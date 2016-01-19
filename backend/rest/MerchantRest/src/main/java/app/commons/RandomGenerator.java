package app.commons;

public final class RandomGenerator {

	private static int merchantIdCounter =0;
	private static int transactionId = 0;
	
	public static int generateMerchantId()
	{
		return merchantIdCounter++;
	}
	
	public static int getTransactionId()
	{
		return transactionId++;
	}
}

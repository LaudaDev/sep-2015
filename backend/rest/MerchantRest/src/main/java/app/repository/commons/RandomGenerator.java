package app.repository.commons;

public class RandomGenerator {

	private static int merchantIdCounter =0;
	
	public int generateMerchantId()
	{
		return merchantIdCounter++;
	}
}

package app.commons;

public enum TransactionStatusCodes {
	
	SUCCESS("00"), SERVER_ERROR("05");
	
	private String value;

	private TransactionStatusCodes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}

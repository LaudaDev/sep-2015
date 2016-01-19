package app.transferData;

import java.util.Date;

public class TransactionResults {

	private boolean success;
	private int merchantOrderId;
	private int acquirerOrderId;
	private int paymentId;
	private Date acquirerTimestamp;
	
	
	
	public TransactionResults() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionResults(boolean result, int merchantOrderId, int acquirerOrderId, int paymentId,
			Date acquirerTimestamp) {
		super();
		this.success = result;
		this.merchantOrderId = merchantOrderId;
		this.acquirerOrderId = acquirerOrderId;
		this.paymentId = paymentId;
		this.acquirerTimestamp = acquirerTimestamp;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean result) {
		this.success = result;
	}
	public int getMerchantOrderId() {
		return merchantOrderId;
	}
	public void setMerchantOrderId(int merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}
	public int getAcquirerOrderId() {
		return acquirerOrderId;
	}
	public void setAcquirerOrderId(int acquirerOrderId) {
		this.acquirerOrderId = acquirerOrderId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public Date getAcquirerTimestamp() {
		return acquirerTimestamp;
	}
	public void setAcquirerTimestamp(Date acquirerTimestamp) {
		this.acquirerTimestamp = acquirerTimestamp;
	}
	
	
	
}

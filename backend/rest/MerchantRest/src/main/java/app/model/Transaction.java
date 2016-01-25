package app.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

public class Transaction {

	@Id
	private String id;
	private int merchantOrderId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date merchantTimestamp;
	private String insuranceId;
	private int paymentID;
	private int acquirerOrderId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date acquirerTimestamp;
	private boolean isCardAuthenticated;
	private boolean isCardAuthorized;
	private boolean isTransactionSucceded;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(String id, int merchantOrderId, Date merchantTimestamp, String insuranceId, int paymentID,
			int acquirerOrderId, Date acquirerTimestamp, boolean isCardAuthenticated, boolean isCardAuthorized,
			boolean isTransactionSucceded) {
		super();
		this.id = id;
		this.merchantOrderId = merchantOrderId;
		this.merchantTimestamp = merchantTimestamp;
		this.insuranceId = insuranceId;
		this.paymentID = paymentID;
		this.acquirerOrderId = acquirerOrderId;
		this.acquirerTimestamp = acquirerTimestamp;
		this.isCardAuthenticated = isCardAuthenticated;
		this.isCardAuthorized = isCardAuthorized;
		this.isTransactionSucceded = isTransactionSucceded;
	}

	public int getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(int merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public String getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public int getAcquirerOrderId() {
		return acquirerOrderId;
	}

	public void setAcquirerOrderId(int acquirerOrderId) {
		this.acquirerOrderId = acquirerOrderId;
	}

	public Date getAcquirerTimestamp() {
		return acquirerTimestamp;
	}

	public void setAcquirerTimestamp(Date acquirerTimestamp) {
		this.acquirerTimestamp = acquirerTimestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isCardAuthenticated() {
		return isCardAuthenticated;
	}

	public void setCardAuthenticated(boolean isCardAuthenticated) {
		this.isCardAuthenticated = isCardAuthenticated;
	}

	public boolean isCardAuthorized() {
		return isCardAuthorized;
	}

	public void setCardAuthorized(boolean isCardAuthorized) {
		this.isCardAuthorized = isCardAuthorized;
	}

	public boolean isTransactionSucceded() {
		return isTransactionSucceded;
	}

	public void setTransactionSucceded(boolean isTransactionSucceded) {
		this.isTransactionSucceded = isTransactionSucceded;
	}

	public Date getMerchantTimestamp() {
		return merchantTimestamp;
	}

	public void setMerchantTimestamp(Date merchantTimestamp) {
		this.merchantTimestamp = merchantTimestamp;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", merchantOrderId=" + merchantOrderId + ", merchantTimestamp="
				+ merchantTimestamp + ", insuranceId=" + insuranceId + ", paymentID=" + paymentID + ", acquirerOrderId="
				+ acquirerOrderId + ", acquirerTimestamp=" + acquirerTimestamp + ", isCardAuthenticated="
				+ isCardAuthenticated + ", isCardAuthorized=" + isCardAuthorized + ", isTransactionSucceded="
				+ isTransactionSucceded + "]";
	}

}

package app.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import app.commons.TransactionStatus;

public class Transaction {
	
	@Id
	private String id;
	private int merchantOrderId;
	private String insuranceId;
	private int paymentID;
	private int acquirerOrderId;
	private Date acquirerTimestamp;
	private TransactionStatus transactionResult;
	

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int merchantOrderId, String insuranceId, int paymentID, int acquirerOrderId,
			Date acquirerTimestamp, TransactionStatus transactionResult) {
		super();
		this.merchantOrderId = merchantOrderId;
		this.insuranceId = insuranceId;
		this.paymentID = paymentID;
		this.acquirerOrderId = acquirerOrderId;
		this.acquirerTimestamp = acquirerTimestamp;
		this.transactionResult = transactionResult;
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
	public TransactionStatus isTransactionResult() {
		return transactionResult;
	}
	public void setTransactionResult(TransactionStatus transactionResult) {
		this.transactionResult = transactionResult;
	}
	
	
	
}

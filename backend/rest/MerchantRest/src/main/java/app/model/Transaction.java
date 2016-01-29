package app.model;

import org.springframework.data.annotation.Id;

import app.model.transferData.AcquirerInfo;
import app.model.transferData.MerchantInfo;
import app.model.transferData.TransactionStatus;

public class Transaction {

	@Id
	private String id;
	private String insuranceId;
	private int paymentID;
	private MerchantInfo merchantInfo;
	private AcquirerInfo acquirerInfo;
	private TransactionStatus transactionStatus;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(String id, String insuranceId, int paymentID, MerchantInfo merchantInfo,
			AcquirerInfo acquirerInfo, TransactionStatus transactionStatus) {
		super();
		this.id = id;
		this.insuranceId = insuranceId;
		this.paymentID = paymentID;
		this.merchantInfo = merchantInfo;
		this.acquirerInfo = acquirerInfo;
		this.transactionStatus = transactionStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public MerchantInfo getMerchantInfo() {
		return merchantInfo;
	}

	public void setMerchantInfo(MerchantInfo merchantInfo) {
		this.merchantInfo = merchantInfo;
	}

	public AcquirerInfo getAcquirerInfo() {
		return acquirerInfo;
	}

	public void setAcquirerInfo(AcquirerInfo acquirerInfo) {
		this.acquirerInfo = acquirerInfo;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", insuranceId=" + insuranceId + ", paymentID=" + paymentID + ", merchantInfo="
				+ merchantInfo + ", acquirerInfo=" + acquirerInfo + ", transactionStatus=" + transactionStatus + "]";
	}

	

}

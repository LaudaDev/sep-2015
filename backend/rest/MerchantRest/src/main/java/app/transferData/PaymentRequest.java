package app.transferData;

import java.net.URL;
import java.util.Date;

public class PaymentRequest {

	private String merchantId;
	private String merchatPassword;
	private double amount;
	private int merchantOrderId;
	private Date merchantTimestamp;
	private URL errorUrl;
	public String getMerchantId() {
		return merchantId;
	}
	
	
	public PaymentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PaymentRequest(String merchantId, String merchatPassword, double amount, int merchantOrderId,
			Date merchantTimestamp, URL errorUrl) {
		super();
		this.merchantId = merchantId;
		this.merchatPassword = merchatPassword;
		this.amount = amount;
		this.merchantOrderId = merchantOrderId;
		this.merchantTimestamp = merchantTimestamp;
		this.errorUrl = errorUrl;
	}


	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchatPassword() {
		return merchatPassword;
	}
	public void setMerchatPassword(String merchatPassword) {
		this.merchatPassword = merchatPassword;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getMerchantOrderId() {
		return merchantOrderId;
	}
	public void setMerchantOrderId(int merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}
	public Date getMerchantTimestamp() {
		return merchantTimestamp;
	}
	public void setMerchantTimestamp(Date merchantTimestamp) {
		this.merchantTimestamp = merchantTimestamp;
	}
	public URL getErrorUrl() {
		return errorUrl;
	}
	public void setErrorUrl(URL errorUrl) {
		this.errorUrl = errorUrl;
	}
	@Override
	public String toString() {
		return "PaymentRequest [merchantId=" + merchantId + ", merchatPassword=" + merchatPassword + ", amount="
				+ amount + ", merchantOrderId=" + merchantOrderId + ", merchantTimestamp=" + merchantTimestamp
				+ ", errorUrl=" + errorUrl + "]";
	}
	
	
	
}

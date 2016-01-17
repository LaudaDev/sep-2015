package app.transferData;

import java.net.URL;

public class PaymentResponse {

	private URL paymentURL;
	private int paymentID;
	public PaymentResponse(URL paymentURL, int paymentID) {
		super();
		this.paymentURL = paymentURL;
		this.paymentID = paymentID;
	}
	public PaymentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public URL getPaymentURL() {
		return paymentURL;
	}
	public void setPaymentURL(URL paymentURL) {
		this.paymentURL = paymentURL;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	
	
}

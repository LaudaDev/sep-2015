package app.model.transferData;

import java.net.URL;

import javax.validation.constraints.NotNull;

public class PaymentInstructionsAcquirerResponse {

	@NotNull(message = "error.paymentURL.notnull")
	private URL paymentURL;

	@NotNull(message = "error.paymentURL.notnull")
	private int paymentID;

	public PaymentInstructionsAcquirerResponse(URL paymentURL, int paymentID) {
		super();
		this.paymentURL = paymentURL;
		this.paymentID = paymentID;
	}

	public PaymentInstructionsAcquirerResponse() {
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

	@Override
	public String toString() {
		return "PaymentInstructionsAcquirerResponse [paymentURL=" + paymentURL + ", paymentID=" + paymentID + "]";
	}

	
}

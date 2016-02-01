package app.model.transferData;

import java.net.URL;

import javax.validation.constraints.NotNull;

public class PaymentInstructionsAcquirerResponse {

	@NotNull(message = "error.paymentURL.notnull")
	private URL paymentURL;

	@NotNull(message = "error.paymentURL.notnull")
	private Integer paymentID;

	public PaymentInstructionsAcquirerResponse(URL paymentURL, Integer paymentID) {
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

	public Integer getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(Integer paymentID) {
		this.paymentID = paymentID;
	}

	@Override
	public String toString() {
		return "PaymentInstructionsAcquirerResponse [paymentURL=" + paymentURL + ", paymentID=" + paymentID + "]";
	}

	
}

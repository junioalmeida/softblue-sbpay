package almeida.ferreira.junio.sbpay.core;

public class PaymentResponse {
	
	private StatusPayment status;
	private String error;
	
	public PaymentResponse(String error) {
		this.error = error;
	}
	
	public PaymentResponse(StatusPayment status) {
		this.status = status;
	}
	
	public StatusPayment getStatus() {
		return status;
	}
	
	public String getError() {
		return error;
	}
}

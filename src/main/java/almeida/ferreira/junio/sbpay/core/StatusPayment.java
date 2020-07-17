package almeida.ferreira.junio.sbpay.core;

public enum StatusPayment {
	AUTHORIZED("Autorizado"),
	NOT_AUTHORIZED("N�o autorizado pela institui��o financeira"),
	INVALID_CARD("Cart�o inv�lido ou bloqueado");
	
	private String description;

	private StatusPayment(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}

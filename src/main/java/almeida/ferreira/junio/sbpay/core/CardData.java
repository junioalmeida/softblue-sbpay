package almeida.ferreira.junio.sbpay.core;

import javax.validation.constraints.Pattern;

public class CardData {

	@Pattern(regexp = "\\d{16}", message = "O cart�o informado n�o � v�lido.")
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}

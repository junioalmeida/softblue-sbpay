package almeida.ferreira.junio.sbpay.infrastructure;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import almeida.ferreira.junio.sbpay.core.CardData;
import almeida.ferreira.junio.sbpay.core.PaymentResponse;
import almeida.ferreira.junio.sbpay.core.StatusPayment;

@RestController
public class SBPayService {
	
	private static final String AUTH_TOKEN = "r2d2";
	
	@PostMapping(path = "/pay", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentResponse> pay(
			@RequestHeader String token,
			@RequestBody @Valid CardData cardData,
			Errors errors){
		
		if(!AUTH_TOKEN.equals(token)) {
			return ResponseEntity.badRequest().body(new PaymentResponse("Token inválido"));
		}
		
		if(errors.hasErrors()) {
			return ResponseEntity.ok(new PaymentResponse(StatusPayment.INVALID_CARD));
		}
		
		if(!cardData.getNumber().startsWith("1111")) {
			return ResponseEntity.ok(new PaymentResponse(StatusPayment.NOT_AUTHORIZED));
		}
		
		return ResponseEntity.ok(new PaymentResponse(StatusPayment.AUTHORIZED));
		
	}
}

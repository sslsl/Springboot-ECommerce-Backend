package com.masai.models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCard {
	
	@Pattern(regexp = "[0-9]{16,18}", message = "Invalid card number")
	@NotNull
	private String cardNumber;
	
	@Pattern(regexp = "[0-9]{2}/[0-9]{2,4}", message = "Invalid validity. Enter in MM/YY or MM/YYYY format")
	private String cardValidity;
	
	@Pattern(regexp = "[0-9]{3}", message = "Invalid CVV. Must be numeric 3 digits length.")
	private String cardCVV;

	// Getters and Setters

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardValidity() {
		return cardValidity;
	}

	public void setCardValidity(String cardValidity) {
		this.cardValidity = cardValidity;
	}

	public String getCardCVV() {
		return cardCVV;
	}

	public void setCardCVV(String cardCVV) {
		this.cardCVV = cardCVV;
	}
}

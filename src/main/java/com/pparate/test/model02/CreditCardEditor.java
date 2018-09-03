package com.pparate.test.model02;

import java.beans.PropertyEditorSupport;

public class CreditCardEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String cardNumber) throws IllegalArgumentException {

		System.out.println("in CreditCardEditor.setAsText()");
		String trimmedCardNumber = cardNumber.replaceAll("-", "");
		CreditCard card = new CreditCard();
		card.setCardNumber(trimmedCardNumber);
		setValue(card);
	}

	// @Override
	// public String getAsText() {
	//
	// return ((Integer)((CreditCard)getValue()).getCardNumber()).toString();
	// }

}

package com.hafizrsoftdev.classes;

import java.text.NumberFormat;

public class CurrencyConverter {

	public static String convertToCurrency(double amount) {
		String result = NumberFormat.getCurrencyInstance().format(amount);
		return result;
	}

}

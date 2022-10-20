package com.hafizrsoftdev.classes;

public class NumberGenerator {

	public static byte generateByte_0_To_99() {
		byte randomByte = (byte)(Math.random()*100);
		return randomByte;
	}
	public static double generateDouble_0_To_99000(){
		double randomDouble = (double)NumberGenerator.generateByte_0_To_99()*1000;
		return randomDouble;
	}
}

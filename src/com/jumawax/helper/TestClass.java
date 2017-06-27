package com.jumawax.helper;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String lat = "-6,43241";
		lat = lat.replace(",", ".");
		double latd = Double.parseDouble(lat);
		System.out.println("parse: "+latd);
	}

}

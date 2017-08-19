package com.jumawax.helper;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String lat = "-6,43241";
		lat = lat.replace(",", ".");
		double latd = Double.parseDouble(lat);
		System.out.println("parse: "+latd);
		
		try {
			URL url = new URL("ftp://jumawax:jkluio789@localhost/Priangga/Jumawax/sample.txt");
			URLConnection uCon = url.openConnection();
			InputStream is = uCon.getInputStream();
			String str = IOUtils.toString(is);
			System.out.println(str);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}

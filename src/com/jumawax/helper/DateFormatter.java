package com.jumawax.helper;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;


public class DateFormatter {
	
	static Logger log = Logger.getLogger(DateFormatter.class);
	
	private static final String JUMAWAX_DATE = "yyyy-mm-dd HH:mm:ss";
	private static SimpleDateFormat sdf = new SimpleDateFormat(JUMAWAX_DATE);
	
	public static final java.sql.Timestamp date(String date) throws ParseException {
		Date sdate = sdf.parse(date);
		java.sql.Timestamp timest = new Timestamp(sdate.getTime());
		log.debug("date : "+timest);
		return timest;
	}
}

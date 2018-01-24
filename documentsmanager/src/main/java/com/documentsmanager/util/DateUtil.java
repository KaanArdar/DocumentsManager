package com.documentsmanager.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String timeFormater(Date date) {
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = dateFormatGmt.format(date);
		return dateString;
	}
	
	
}

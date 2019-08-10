package com.learn.bms.ms.learnbmsms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static Date convertStringToDate(String dateInString, String dateFormate) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
		return sdf.parse(dateInString);
	}
	
	public static String convertMilisToString(long dateInMilis, String dateFormate) {
		
		return convertDateToString(new Date(dateInMilis), dateFormate);
	}
	
	public static String convertDateToString(Date d, String dateFormate) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
		return sdf.format(d);
	}
}

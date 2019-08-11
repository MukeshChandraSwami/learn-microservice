package com.learn.ums.ms.learnumsms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	
	public static Date addInDate(Date d, int what, int howMuch) {
		
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		cal.add(what, howMuch);
		return cal.getTime();
	}
}

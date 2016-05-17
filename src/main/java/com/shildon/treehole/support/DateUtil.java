package com.shildon.treehole.support;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date May 8, 2016
 */
public class DateUtil {
	
	private static DateFormat getDateFormat(String pattern) {
		if (null == pattern || "".equals(pattern)) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat;
	}
	
	public static Date String2Date(String dateString, String pattern) throws ParseException {
		if (null == dateString || "".equals(dateString)) {
			return null;
		} else {
			DateFormat dateFormat = getDateFormat(pattern);
			Date date = dateFormat.parse(dateString);
			return date;
		}
	}
	
	public static Date String2Date(String dateString) throws ParseException {
		return String2Date(dateString, null);
	}
	
	public static String date2String(Date date, String pattern) {
		if (null == date) {
			return null;
		} else {
			DateFormat dateFormat = getDateFormat(pattern);
			String dateString = dateFormat.format(date);
			return dateString;
		}
	}
	
	public static String date2String(Date date) {
		return date2String(date, null);
	}

}

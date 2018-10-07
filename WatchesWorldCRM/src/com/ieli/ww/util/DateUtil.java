package com.ieli.ww.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	public static String getMySQLDate() {

		SimpleDateFormat dateFormat = new SimpleDateFormat(StaticData.MYSQL_DATE_FORMAT);
		return dateFormat.format(Calendar.getInstance().getTime());
	}
}

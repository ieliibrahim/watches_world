package com.ieli.ww.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StaticData {

	public static final String SERVER_API_PATH = "https://localhost/";

	public static String FULL_MONTH_NAME = new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime());

	public static final NumberFormat USD_NUM_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

	public static final NumberFormat EURO_NUM_FORMAT = NumberFormat.getCurrencyInstance(new Locale("pt", "PT"));

	public static final NumberFormat POUND_NUM_FORMAT = NumberFormat.getCurrencyInstance(Locale.UK);

	public static final String MYSQL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
}

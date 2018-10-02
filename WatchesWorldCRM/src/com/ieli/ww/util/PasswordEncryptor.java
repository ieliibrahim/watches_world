package com.ieli.ww.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptor {

	public static String encryptPassword(String password) {

		BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
		return enc.encode(password);

	}

	public static boolean checkPassword(String userInput, String dbPass) {

		BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
		if (enc.matches(userInput, dbPass)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(encryptPassword("rudy@watchesworld"));
		Calendar cal = Calendar.getInstance();
		System.out.println(new SimpleDateFormat("MMMM").format(cal.getTime()));
	}

}

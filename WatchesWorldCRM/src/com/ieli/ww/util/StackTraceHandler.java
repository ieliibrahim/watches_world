package com.ieli.ww.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class StackTraceHandler {

	public static String getErrString(Exception e) {

		String errMsg = "";

		for (StackTraceElement el : e.getStackTrace()) {
			errMsg += el.toString() + "\n";
		}

		return errMsg;
	}

	public static void createEncryptedPass(String pass) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode(pass));
	}
	
	public static void main(String[] args) {
		createEncryptedPass("noroles");
	}
}

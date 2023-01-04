package com.ezen.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SHA256 {
	private static final String SALT = "dlwpszjavbxj!@34"; 

	public static String encode(String source) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA256");
			md.update((SALT + source).getBytes());
			byte[] bytes = md.digest();
			StringBuffer sb = new StringBuffer();
			for(byte b : bytes) {
				sb.append(String.format("%02X", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) {
		log.info("length=>{}", encode("test"));
	}
}

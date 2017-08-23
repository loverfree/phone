package com.newer.phone.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class PwdEncrypt {
	
	// 将密码进行 md5 处理
	public String md5Pwd(String input) {
		String sha1 = null;
		try {
			MessageDigest msdDigest = MessageDigest.getInstance("MD5");
			msdDigest.update(input.getBytes("UTF-8"),0,input.length());
			sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sha1;
	}
	
	public static void main(String[] args) {
		PwdEncrypt pe = new PwdEncrypt();
		String pwd = "sslx";
		String result = pe.md5Pwd(pwd);
		System.out.println(result);
		System.out.println(result.length());
	}
	
}

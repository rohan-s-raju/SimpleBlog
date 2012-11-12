package com.rohan.blog.framework.encryptor;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class Encryptor {

	public static void main(String args[]) {
		String encryptedPassword = encrypt("user");
		System.out.println("The encrypted password for user is - "
				+ encryptedPassword);
	}

	/**
	 * Encrypts the given plaintext password. The encrypted form is a message
	 * digest generated with the SHA-1 algorithm, and rendered in String format
	 * using Base-64 encoding.
	 * 
	 * @param pPassword password to encrypt
	 * @return encrypted password
	 * @throws NullPointerException if either password is null
	 */

	public static String encrypt(final String pPassword) {
		String encryptedPassword = null;
		if (pPassword == null) {
			throw new NullPointerException();
		}
		try {

			final MessageDigest md = MessageDigest.getInstance("SHA");
			md.update((pPassword).getBytes("UTF-8"));
			encryptedPassword = new BASE64Encoder().encode(md.digest());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptedPassword;
	}
}

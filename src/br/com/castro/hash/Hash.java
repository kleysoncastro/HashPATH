package br.com.castro.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	
	public static byte[] generateHash(String data, String algoritmo) {
		  try {
		    MessageDigest md = MessageDigest.getInstance(algoritmo);
		    md.update(data.getBytes());
		    return md.digest();
		  } catch (NoSuchAlgorithmException e) {
		    return null;
		  }
		}
	
	public static String hashToHex(byte[] hashByte) {
		
		StringBuilder hexString = new StringBuilder();
		for (byte b : hashByte) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		
		return hexString.toString();
	}

}

package br.com.castro.hash;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
	
	public static byte[] generateHash(File file, String algoritmo) throws IOException {
		int read = 0;
		InputStream is = new FileInputStream(file);
		byte[] buffer = new byte[8192];
		  try {
		    MessageDigest md = MessageDigest.getInstance(algoritmo);
		    
		    
		    while( (read = is.read(buffer)) > 0) {
		    	md.update(buffer, 0, read);
			}	
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

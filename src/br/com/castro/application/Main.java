package br.com.castro.application;

import br.com.castro.hash.Hash;

public class Main {

	public static void main(String[] args) {

		Hash hash = new Hash();
		
	byte[] hashByte =	hash.generateHash("password", "SHA-256");
	
	System.out.println(hash.hashToHex(hashByte));
	//hash.hashToHex(hashByte);
	

	}

}

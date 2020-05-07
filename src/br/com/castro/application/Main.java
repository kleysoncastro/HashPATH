package br.com.castro.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import br.com.castro.hash.Hash;

public class Main {

	public static void main(String[] args) throws IOException {

		Hash hash = new Hash();
		
		File f = new File("/home/castro/Downloads/jdk-11.0.7_linux-x64_bin.tar.gz");
		
	byte[] hashByte =	hash.generateHash(f, "SHA-256");
	byte[] hashByte2 =	hash.generateHash("password", "SHA-256");
	
	System.out.println(hash.hashToHex(hashByte));
	System.out.println(hash.hashToHex(hashByte2));
	
	
	

	}

}

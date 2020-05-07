package br.com.castro.application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import br.com.castro.hash.Hash;

public class Main {

	static String path;
	static String fileName;

	public static void main(String[] args) throws IOException {

		Hash hash = new Hash();
		Scanner s = new Scanner(System.in);
		System.out.println("HashPath file or string");
		path = s.next();
		try {

			File f = new File(path);
			fileName = f.getName();

			byte[] hashByte = hash.generateHash(f, "SHA-256");

			System.out.printf("%s \t %s", hash.hashToHex(hashByte), fileName);

		} catch (IOException e) {
			System.out.printf("Error, check the path: %s\n", path);
		}

	}

}

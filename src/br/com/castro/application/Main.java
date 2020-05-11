package br.com.castro.application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import br.com.castro.files.ManipulationFile;
import br.com.castro.hash.Hash;

public class Main {

	static String path;
	static String fileName;

	public static void main(String[] args) throws IOException {

		System.out.println("HashPath file or string");

		Scanner s = new Scanner(System.in);
		path = s.next();
		if (!(new File(path).exists())) {
			System.err.println("Error, Check the path");
			return;
		} else {
			hashFilesInPath(path);
		}
		s.close();

	}

	public static void hashFile(String path) {
		Hash hash = new Hash();
		try {
			
			File f = new File(path);
			fileName = f.getName();

			byte[] hashByte = hash.generateHash(f, "SHA-256");

			System.out.printf("%s \t %s\n", hash.hashToHex(hashByte), fileName);

		} catch (IOException e) {
			System.err.printf("Error, check the path or permission: %s\n", path);
		}
	}

	public static void hashFilesInPath(String path) {

		ManipulationFile list = new ManipulationFile();

		String[] lists = ManipulationFile.listFilesInPath(path);

		for (String string : lists) {
			//System.out.println(path + "/" + string);
			hashFile(path + "/" + string);
		}
	}

}

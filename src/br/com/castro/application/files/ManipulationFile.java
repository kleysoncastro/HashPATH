package br.com.castro.application.files;

import java.io.File;

public class ManipulationFile {
	
	public static String[] listFilesInPath(String path) {
		
		if(!(new File(path).exists()) ) {
			
			return null;
		}
		
		return new File(path).list();
	}

}

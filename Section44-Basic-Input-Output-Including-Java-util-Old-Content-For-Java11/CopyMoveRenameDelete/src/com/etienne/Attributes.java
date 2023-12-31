package com.etienne;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Attributes {

	public static void main(String[] args) {

		try {
			// Path fileToCreate = FileSystems.getDefault().getPath("filesoldjava11", "Examples", "file2.txt");
			// Files.createFile(fileToCreate);

			//Path dirToCreate = FileSystems.getDefault().getPath("filesoldjava11", "Examples", "Dir4");
			//Files.createDirectory(dirToCreate);

			// Path dirToCreate = FileSystems.getDefault().getPath("filesoldjava11", "Examples", "Dir2/Dir3/Dir4/Dir5/Dir6");
			// Path dirToCreate = FileSystems.getDefault().getPath("filesoldjava11", "Examples", "Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
			// Path dirToCreate = FileSystems.getDefault().getPath("filesoldjava11", "Examples/Dir2/Dir3/Dir4/Dir5/Dir6/Dir7");
			// Path dirToCreate = FileSystems.getDefault().getPath("filesoldjava11", "Examples\\Dir2\\Dir3\\Dir4\\Dir5\\Dir6\\Dir7");
			// Files.createDirectories(dirToCreate);

			Path filePath = FileSystems.getDefault().getPath("filesoldjava11", "Examples", "file1.txt");
			long size = Files.size(filePath);
			System.out.println("Size = " + size);
			System.out.println("Last modified = " + Files.getLastModifiedTime(filePath));

			BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
			System.out.println("Size = " + attrs.size());
			System.out.println("Last modified = " + attrs.lastModifiedTime());
			System.out.println("Created = " + attrs.creationTime());
			System.out.println("Is directory = " + attrs.isDirectory());
			System.out.println("Is regular file = " + attrs.isRegularFile());


		}  catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

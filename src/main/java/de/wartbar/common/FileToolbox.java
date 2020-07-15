package de.wartbar.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileToolbox extends WartbarBase {

	public static void createFile(String fileName, String content) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(content);
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readFile(Path path) {
		String result = "";
		try {
			List<String> list = Files.readAllLines(path);
			for (String line : list) {
				result += line + nl;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}

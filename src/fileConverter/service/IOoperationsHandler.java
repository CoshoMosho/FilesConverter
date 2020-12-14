package fileConverter.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class IOoperationsHandler {

	public static Properties getPropertiesFromPath(String path) {
		Properties properties = new Properties();
		try {
			BufferedInputStream stream = new BufferedInputStream(new FileInputStream(path));
			properties.load(stream);
			stream.close();
		} catch (FileNotFoundException e) {
			System.err.println("file not found");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.err.println("could not access the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO exceptions during file reading");
			e.printStackTrace();
		}
		return properties;
	}

	public static Reader getReader(String path) {
		File file = new File(path);
		try {
			return new FileReader(file);
		} catch (FileNotFoundException e) {
			System.err.println("file not found");
			e.printStackTrace();
		}
		return null;
	}

	public static FileOutputStream getOutputStream(String path) {
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(path);
			return outputStream;
		} catch (FileNotFoundException e) {
			System.err.println("file not found");
			e.printStackTrace();
		}
		return null;
	}
}

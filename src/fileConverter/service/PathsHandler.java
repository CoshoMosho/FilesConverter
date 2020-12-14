package fileConverter.service;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import fileConverter.models.InputVariables;

public class PathsHandler {

	private String cleanPath;

	public PathsHandler(String path, PathValidation pathValidation) {
		if (pathValidation == null || path == null) {
			return;
		}
		switch (pathValidation) {
		case READINGFROMFILE:
			if (isValidFilePath(path)) {
				cleanPath = path;
			}
			break;
		case WRITINGTOFILE:
			if (isValidDirectory(path)) {
				cleanPath = path;
			} else {
				cleanPath = InputVariables.getDefaultoutpufilename();
			}
			break;
		default:
			break;
		}
	}

	public static boolean isValidFilePath(String inputPath) {
		// to be further implemented
		if (inputPath == null) {
			return false;
		}
		try {
			Path path = Paths.get(inputPath);
			return Files.exists(path);
		} catch (InvalidPathException e) {
			System.err.println("could not find the file at specified path");
			e.printStackTrace();
			return false;
		} catch (SecurityException e) {
			System.err.println("could not access the file");
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isValidDirectory(String inputPath) {
		// to be further implemented
		if (inputPath == null) {
			return false;
		}
		if (inputPath.lastIndexOf("\\") > -1) {
			try {
				Path path = Paths.get(inputPath.substring(0, inputPath.lastIndexOf("\\")));
				return Files.isDirectory(path);
			} catch (InvalidPathException e) {
				System.err.println("could not find the file at specified path");
				e.printStackTrace();
				return false;
			} catch (SecurityException e) {
				System.err.println("could not access the file");
				e.printStackTrace();
				return false;
			}
		}
		return false;

	}

	public static String cleanPropertyFilePath(String inputPath) {
		// to be further implemented
		if (inputPath == null) {
			return null;
		}
		if (inputPath.indexOf('"') < 0) {
			return inputPath;
		}
		if (inputPath.indexOf('"') != inputPath.lastIndexOf('"')) {
			return inputPath.substring(inputPath.indexOf('"') + 1, inputPath.lastIndexOf('"'));
		}
		return null;
	}

	public String getCleanPath() {
		return cleanPath;
	}

	enum PathValidation {
		READINGFROMFILE, WRITINGTOFILE
	}
}

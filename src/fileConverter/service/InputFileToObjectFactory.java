package fileConverter.service;

import fileConverter.service.inputFileClasses.ParsingFromJson;

public class InputFileToObjectFactory extends AbstractFactory {

	private String path;

	public enum FileInputType {
		JSON
	}

	public <T> T getObjectFromFactory(PathsHandler path, Class<T> classOfT, FileInputType fileType) {
		if (path == null || classOfT == null || fileType == null) {
			return null;
		}
		this.path = path.getCleanPath();
		switch (fileType) {
		case JSON:
			ParsingFromJson jsonFIle = new ParsingFromJson();
			return jsonFIle.retrieveDataFromFile(classOfT, this.path);
		default:
			break;
		}
		return null;
	}

}

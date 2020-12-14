package fileConverter.service;

import fileConverter.service.outputFileClasses.CreateExcel;

public class OutputFileToObjectFactory extends AbstractFactory {

	private String path;

	public enum FileOutputType {
		EXCEL
	}

	public <T> void createFileFromObject(PathsHandler path, T objectT, FileOutputType fileType) {
		if (path == null || objectT == null || fileType == null) {
			return;
		}
		this.path = path.getCleanPath();
		switch (fileType) {
		case EXCEL:
			CreateExcel excel = new CreateExcel();
			excel.createFileByType(objectT, this.path);
		default:
			break;
		}
	}

}

package fileConverter.service.outputFileClasses;

public interface GenerateFileByType {

	<T> void createFileByType(T ObjectT, String path);
}

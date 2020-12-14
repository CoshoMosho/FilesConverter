package fileConverter.service.inputFileClasses;

public interface Parser {

	<T> T retrieveDataFromFile(Class<T> classOfT, String path);
}

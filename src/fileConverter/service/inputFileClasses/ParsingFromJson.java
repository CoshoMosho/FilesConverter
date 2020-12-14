package fileConverter.service.inputFileClasses;

import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import fileConverter.service.IOoperationsHandler;

public class ParsingFromJson implements Parser {

	@Override
	public <T> T retrieveDataFromFile(Class<T> classOfT, String path) {
		Reader reader = IOoperationsHandler.getReader(path);
		Gson gson = new Gson();
		T t = null;
		try {
			t = gson.fromJson(JsonParser.parseReader(reader), classOfT);
			// check this part
			reader.close();
		} catch (JsonSyntaxException | JsonIOException e) {
			System.err.println("error while parsing json file");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO error");
			e.printStackTrace();
		}
		return t;
	}
}

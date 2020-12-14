package fileConverter.service;

import java.util.Properties;

import fileConverter.models.InputVariables;
import fileConverter.models.MenuContent;
import fileConverter.service.PathsHandler.PathValidation;
import fileConverter.service.InputFileToObjectFactory.FileInputType;
import fileConverter.service.OutputFileToObjectFactory.FileOutputType;

public class JsonToExcelExample {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		PathsHandler propertiesPath = new PathsHandler(InputVariables.getPropertiespath(), PathValidation.READINGFROMFILE);
		
		Properties props = IOoperationsHandler.getPropertiesFromPath(propertiesPath.getCleanPath());
		props.setProperty(InputVariables.Econst.INPUTFILENAME.getValue(), PathsHandler.cleanPropertyFilePath(props.getProperty(InputVariables.Econst.INPUTFILENAME.getValue())));
		props.setProperty(InputVariables.Econst.OUTPUTFILENAME.getValue(), PathsHandler.cleanPropertyFilePath(props.getProperty(InputVariables.Econst.OUTPUTFILENAME.getValue())));

		PathsHandler inputFilePath = new PathsHandler(props.getProperty(InputVariables.Econst.INPUTFILENAME.getValue()), PathValidation.READINGFROMFILE);
		
		InputFileToObjectFactory inputFactory = new InputFileToObjectFactory();
		MenuContent menuContent = inputFactory.getObjectFromFactory(inputFilePath,MenuContent.class, FileInputType.JSON);
		
		PathsHandler outputPath = new PathsHandler(props.getProperty(InputVariables.Econst.OUTPUTFILENAME.getValue()), PathValidation.WRITINGTOFILE);
		
		OutputFileToObjectFactory outputFactory = new OutputFileToObjectFactory();
		outputFactory.createFileFromObject(outputPath, menuContent, FileOutputType.EXCEL);
		long endTime = System.currentTimeMillis();
		System.out.println("time elapsed (seconds):"+(endTime-startTime)/1000);
	}

}

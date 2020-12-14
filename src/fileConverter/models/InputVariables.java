package fileConverter.models;

public class InputVariables {

	private static final String PROPERTIESPATH = ".\\fileConverter.properties";
	private static final String DEFAULTOUTPUFILENAME = ".\\output\\newFile";

	public static String getPropertiespath() {
		return PROPERTIESPATH;
	}

	public static String getDefaultoutpufilename() {
		return DEFAULTOUTPUFILENAME;
	}

	public enum Econst {
		INPUTFILENAME("inputFilePath"), OUTPUTFILENAME("outputFilePath");

		private String value;

		public String getValue() {
			return value;
		}

		private Econst(final String string) {
			this.value = string;
		}
	}

}

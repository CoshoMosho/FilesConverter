package fileConverter.service.outputFileClasses;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import fileConverter.models.MenuContent;
import fileConverter.models.MenuNode;
import fileConverter.service.IOoperationsHandler;

public class CreateExcel implements GenerateFileByType {

	private static int nodesTotalDepth;
	private static int rowCounter = 1;
	private static Workbook workbook = new XSSFWorkbook();
	private static Sheet sheet;

	@Override
	public <T> void createFileByType(T ObjectT, String path) {

		MenuContent menuContent = (MenuContent) ObjectT;
		nodesTotalDepth = calculateNodesDepth(menuContent);

		sheet = workbook.createSheet("Menu " + menuContent.getVersion());
		sheet.setColumnWidth(0, 6000);
		sheet.setColumnWidth(1, 4000);

		serviceBusinessLogic(menuContent);

		FileOutputStream outputStream = IOoperationsHandler.getOutputStream(path);
		try {
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			System.err.println("IO error while creating the file");
			e.printStackTrace();
		}
	}

	public static CellStyle setCellStyle() {
		CellStyle headerStyle = workbook.createCellStyle();
		//headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		//headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerStyle.setFont(setFont());
		return headerStyle;
	}

	public static XSSFFont setFont() {
		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 12);
		font.setBold(true);
		return font;
	}

	private static void setHeaderValues(Row header) {

		// Field[] fields = MenuNode.class.getDeclaredFields();
		// for (Field field : fields) {
		// }
		ArrayList<String> headerValues = new ArrayList<String>();
		headerValues.add("ServiceId");
		headerValues.add("NodeName");
		headerValues.add("NodeType");
		headerValues.add("GroupType");
		headerValues.add("FlowType");
		headerValues.add("ResoureId");
		int cellN;
		for (cellN = 0; cellN < nodesTotalDepth; cellN++) {
			Cell cell = header.createCell(cellN);
			cell.setCellValue(cellN);
			cell.setCellStyle(setCellStyle());
		}
		for (@SuppressWarnings("unused")
		String string : headerValues) {
			Cell cell = header.createCell(cellN);
			cell.setCellValue(headerValues.get((cellN++) - nodesTotalDepth));
			cell.setCellStyle(setCellStyle());
		}
	}

	public static void serviceBusinessLogic(MenuContent menuContent) {
		Row header = sheet.createRow(0);
		setHeaderValues(header);
		if (menuContent.getNodes() == null) {
			return;
		}
		recursiveCellCreation(menuContent.getNodes(), -1);
	}

	private static void recursiveCellCreation(List<MenuNode> menuNodes, int nodeDepth) {
		if (menuNodes == null) {
			return;
		}
		nodeDepth++;
		for (MenuNode menuNode : menuNodes) {

			int celln = 0;
			Row row = sheet.createRow(rowCounter++);
			Cell cellNodeCounter = row.createCell(nodeDepth);
			cellNodeCounter.setCellValue("X");
			Cell cell = row.createCell(nodesTotalDepth + celln++);
			if (menuNode.getNodeId() != 0) {
				cell.setCellValue(menuNode.getNodeId());
			}
			Cell cell2 = row.createCell(nodesTotalDepth + celln++);
			cell2.setCellValue(menuNode.getNodeName());
			Cell cell3 = row.createCell(nodesTotalDepth + celln++);
			cell3.setCellValue(menuNode.getNodeType());
			Cell cell4 = row.createCell(nodesTotalDepth + celln++);
			cell4.setCellValue(menuNode.getGroupType());
			Cell cell5 = row.createCell(nodesTotalDepth + celln++);
			cell5.setCellValue(menuNode.getFlowType());
			Cell cell6 = row.createCell(nodesTotalDepth + celln++);
			if (menuNode.getResource() != null) {
				cell6.setCellValue(menuNode.getResource().getId());
			}
			recursiveCellCreation(menuNode.getNodes(), nodeDepth);
		}
	}

	public static int calculateNodesDepth(MenuContent menuContent) {
		return calculateNodesDepthRecursive(menuContent.getNodes());
	}

	public static int calculateNodesDepthRecursive(List<MenuNode> menuNodes) {
		int partialDepth = 0;
		if (menuNodes == null) {
			return 0;
		}
		for (MenuNode menuNode : menuNodes) {
			int res = calculateNodesDepthRecursive(menuNode.getNodes());
			if (res > partialDepth) {
				partialDepth = res;
			}
		}
		return partialDepth + 1;
	}

}

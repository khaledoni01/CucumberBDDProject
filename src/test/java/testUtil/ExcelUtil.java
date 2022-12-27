package testUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static String readExcel(String scenName, String wbPath, String sheetName) throws InvalidFormatException, IOException {

		XSSFRow excelRow;
		XSSFCell excelCell;
		XSSFCell excelCell1;
		XSSFWorkbook wbook;
		XSSFSheet sheet;
		int cellNum;
		String inputCellVal;
		String scenCellVal;
		String line = "";
		
		FileInputStream file = new FileInputStream(wbPath);
		wbook = new XSSFWorkbook(file);
		sheet = wbook.getSheet(sheetName);
		int rowNum = sheet.getPhysicalNumberOfRows();
		
		boolean breakScen = false;
		outerloop:
		for (int i = 1; i < rowNum; i++) {
			boolean needPipe = true;
			excelRow = sheet.getRow(i);
			cellNum = excelRow.getLastCellNum();
			
			innerloop:
			for (int j = 1; j < cellNum; j++) {
				excelCell = excelRow.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				inputCellVal = getCellData((XSSFCell) excelCell);
				excelCell1 = excelRow.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				scenCellVal = getCellData((XSSFCell) excelCell1);
				//Controlling excel reading
				if(scenCellVal.contains(scenName)) {
					breakScen = true;
					if(needPipe == true) {
						line += "|";
						needPipe = false;
					}
					line += inputCellVal + "|";
					continue innerloop;
				}
				else if(scenCellVal.isEmpty()) {
					if(breakScen == true) {
						if(needPipe == true) {
							line += "|";
							needPipe = false;
						}
						line += inputCellVal + "|";						
					}
				}
				else if(!scenCellVal.contains(scenName)) {
					if(breakScen == true) {
						break outerloop;
					}
					continue outerloop;
				}
			}
			if(breakScen == true) {
				line += "\n";
			}
		}
		wbook.close();
		file.close();
		return line;
	}

	public static String getCellData(XSSFCell cell) {
		String cellData = null;
		
		try {			
			switch (cell.getCellTypeEnum()) {
			case NUMERIC:
				cellData = String.valueOf(cell.getNumericCellValue()).trim();
				break;
			case STRING:
				cellData = cell.getStringCellValue().trim();
				break;
			case BLANK:
				cellData = "";
			case BOOLEAN:
				cellData = String.valueOf(cell.getBooleanCellValue()).trim();
			default:
				cellData = cell.getStringCellValue().trim();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellData;
	}

}

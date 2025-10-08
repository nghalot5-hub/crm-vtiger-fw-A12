package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	// Prevent instantiation
	private FileUtility() {
		throw new UnsupportedOperationException("Cannot instantiate utility class");
	}

	// get data from properties file
	public String getDataFromPropertiesFile(String key) {
		String propertiesFilePath = "./src/test/resources/testScriptData.xlsx";
		try (FileInputStream fis = new FileInputStream(propertiesFilePath)) {
			Properties pObj = new Properties();
			pObj.load(fis);
			return pObj.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		return null;

	}

	// get data from excel file
	public String getStringDataFromExcelFile(String sheetName, int rowNum, int cellNum) {
		String excelFilePath = "./src/test/resources/testScriptData.xlsx";
		try (FileInputStream fis = new FileInputStream(excelFilePath)) {
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			String value = cell.getStringCellValue();
			return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
		}
		return null;
	}

}

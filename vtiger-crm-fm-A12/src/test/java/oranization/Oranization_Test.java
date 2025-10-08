package oranization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Oranization_Test {

	public static void main(String[] args) throws IOException {
		// fetching data from properties file
		String propertyPath = "./src/test/resources/CommonData.properties";
		Properties pObj = new Properties();
		FileInputStream fis = new FileInputStream(propertyPath);
		pObj.load(fis);
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");

		System.out.println("URL:" + URL);
		System.out.println("Username: " + USERNAME);
		System.out.println("Password: " + PASSWORD);

		// fetching data from excel file
		String excelPath = "./src/test/resources/testScriptData.xlsx";

		FileInputStream excelFis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(excelFis);

		Sheet sheet = wb.getSheet("organization");
		if (sheet == null) {
			sheet = wb.createSheet("organization");
		}

		Row row = sheet.createRow(1);
		if (row == null) {
			row = sheet.createRow(1);
		}

		Cell cell = row.createCell(0);
		if (cell == null) {
			cell = row.createCell(0);
		}
		cell.setCellValue("EY__");

		// save the changes
		FileOutputStream excelfos = new FileOutputStream(excelPath);
		wb.write(excelfos);

		// close methods
		wb.close();

		// open browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// open website
		driver.get(URL);

		// enter user name
		WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.name("user_name")));
		username.sendKeys(USERNAME);

		// enter password opportunities name
		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.name("user_password")));
		password.sendKeys(PASSWORD);

		// click on submit button
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitButton")));
		submit.click();

		// click on organization
		WebElement org = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Organizations")));
		Actions act = new Actions(driver);
		act.moveToElement(org).click().build().perform();

		// click on create organization button
		WebElement createOrg = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[title='Create Organization...']")));
		createOrg.click();
		
		

	}

}

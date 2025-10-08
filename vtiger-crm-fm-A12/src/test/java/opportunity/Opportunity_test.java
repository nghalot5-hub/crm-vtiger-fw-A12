package opportunity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
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
import org.openqa.selenium.support.ui.Select;

public class Opportunity_test {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

		// get details from excel file
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("opportunities");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(0);
		String oppNameValue = cell.getStringCellValue();
		wb.close();
		
		// save the changes
		//FileOutputStream fos = new FileOutputStream("./src/test/resources/testScriptData.xlsx");
		//wb.write(fos);
		
		// open chrome
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// open website
		driver.get("http://localhost:8888/");

		// enter user name
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");

		// enter password opportunities name
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("manager");

		// click on submit button
		driver.findElement(By.id("submitButton")).click();

		// click on Opportunities
		WebElement opportunities = driver.findElement(By.linkText("Opportunities"));

		Actions act = new Actions(driver);
		act.moveToElement(opportunities).click().build().perform();

		// click on create opportunities button
		driver.findElement(By.cssSelector("img[title='Create Opportunity...']")).click();

		// Fill the for: enter opportunities name:
		WebElement oppName = driver.findElement(By.name("potentialname"));
		// String oppNameValue = "Testing";
		oppName.sendKeys(oppNameValue + (int) (Math.random() * 10000));

		// select value from drop down
		WebElement relatedTo = driver.findElement(By.name("related_to_type"));
		Select sel = new Select(relatedTo);
		sel.selectByContainsVisibleText("Contacts");

		String pId = driver.getWindowHandle();

		// click on select button available next to text field of Related To
		WebElement selectBtn = driver.findElement(By.cssSelector("img[title='Select']"));
		selectBtn.click();
		Thread.sleep(5000);

		Set<String> cId = driver.getWindowHandles();
		for (String i : cId) {
			driver.switchTo().window(i);
			System.out.println(driver.getCurrentUrl());

			if (driver.getCurrentUrl().contains("Contacts")) {
				Thread.sleep(5000);
				// perform task on switched window
				WebElement Contact = driver.findElement(By.linkText("Mary Smith"));
				Actions acts = new Actions(driver);
				acts.moveToElement(Contact).click().build().perform();
				// driver.close();
			}
		}
		driver.switchTo().window(pId);
		// click on save button
		driver.findElement(By.name("button")).click();

		// verify opportunities name
		String oppNameVerify = driver.findElement(By.id("dtlview_Opportunity Name")).getText();
		System.out.println(oppNameValue);
		if (oppNameVerify.equalsIgnoreCase(oppNameValue)) {
			System.out.println(oppNameVerify + ": Test case pass");
		} else {
			System.out.println(oppNameVerify + ": Test case fail");
		}

		// verify related to
		String relatedToVerify = driver.findElement(By.linkText("Mary Smith")).getText();
		if (relatedToVerify.equalsIgnoreCase("Mary Smith")) {
			System.out.println(relatedToVerify + ": Test case pass");
		} else {
			System.out.println(relatedToVerify + ": Test case fail");
		}

		// Sign-out
		WebElement signOut = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Thread.sleep(3000);
		Actions acts = new Actions(driver);
		acts.moveToElement(signOut).click().build().perform();
		driver.findElement(By.linkText("Sign Out")).click();

		Thread.sleep(5000);
		driver.quit();
	}

}

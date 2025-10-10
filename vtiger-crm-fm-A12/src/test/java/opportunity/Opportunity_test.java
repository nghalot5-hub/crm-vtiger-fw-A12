package opportunity;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtility.FileUtility;
import object_Repository.CreateOpportunities;
import object_Repository.HomePage;
import object_Repository.LoginPage;

public class Opportunity_test {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		FileUtility fu=new FileUtility();
		
		//get data from properties file
		String URL =fu.getDataFromPropertiesFile("url");
		String USERNAME=fu.getDataFromPropertiesFile("username");
		String PASSWORD=fu.getDataFromPropertiesFile("password");
	
		// get details from excel file
		String oppNameValue =fu.getStringDataFromExcelFile("opportunities",1, 0);

		// open Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// open web-site
		driver.get(URL);

		// logingetClickCreateOpportunitiesBtn
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login();;

		// click on Opportunities
		HomePage homePage=new HomePage(driver);
		WebElement opportunities=homePage.getOpportunities();
		opportunities.click();
		
		Actions act = new Actions(driver);
		act.moveToElement(opportunities).click().build().perform();

		// click on create opportunities button
		CreateOpportunities createOpportunities=new CreateOpportunities(driver);
		createOpportunities.getClickCreateOpportunitiesBtn().click();
		
		//pending create pom to be continued
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

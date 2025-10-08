package calender;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar_test_1 {

	public static void main(String[] args) throws InterruptedException {
		// open chrome
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		// open web-site
		driver.get("http://localhost:8888/");

		// Enter user name
		WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.name("user_name")));
		username.sendKeys("admin");

		// enter password
		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.name("user_password")));
		password.sendKeys("manager");

		// click on submit button
		driver.findElement(By.id("submitButton")).click();

		// click on calendar
		WebElement calendar = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Calendar")));
		Actions act = new Actions(driver);
		act.moveToElement(calendar).click().build().perform();

		// click on Add-->call button
		WebElement addBtn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[style='cursor:pointer;height:30px']")));
		addBtn.click();
		driver.findElement(By.id("addcall")).click();

		// Enter event type:
		WebElement eventName= wait.until(ExpectedConditions.elementToBeClickable(By.name("description")));
		eventName.sendKeys("Anual Party");
		
		// Enter event description:
		WebElement eventDesc = wait.until(ExpectedConditions.elementToBeClickable(By.name("subject")));
		eventDesc.sendKeys("Let's Party");
			
		// Enter Event starts at :
		WebElement calendar1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("jscal_trigger_date_start")));
		calendar1.click();
		WebElement eventStartsAt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='day' and text()='30']")));
		eventStartsAt.click();
		System.out.println(eventStartsAt.getText());
		
		//Enter save button
		WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Save [Alt+S]']")));
		saveBtn.click();
		
		//Sign-out
		WebElement signOut = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Thread.sleep(3000);
		Actions acts = new Actions(driver);
		acts.moveToElement(signOut).click().build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
				
		Thread.sleep(3000);
		driver.quit();
	}

}

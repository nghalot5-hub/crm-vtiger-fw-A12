package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SauceDemo {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");

		LoginPage lp = new LoginPage(driver);

		// declaration & initialization
		WebElement username = lp.getUsername();
		WebElement password = lp.getPassword();
		WebElement login = lp.getLogin();

		// utilization
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		login.click();

		driver.navigate().refresh();

		// Home Page
		HomePage hp = new HomePage(driver);

		WebElement logo = hp.getLogo();

		// verification
		if (logo.isDisplayed())
			System.out.println("Pass");
		else
			System.out.println("Fail");
	}

}

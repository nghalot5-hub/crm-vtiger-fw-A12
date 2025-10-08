package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// initialize
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// declaration
	@FindBy(id = "user-name")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login-button")
	private WebElement login;

	// getters
	public WebElement getUsername() {
		return username;

	}

	public WebElement getPassword() {
		return password;

	}

	public WebElement getLogin() {
		return login;

	}

}

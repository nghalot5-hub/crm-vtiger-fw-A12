package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.FileUtility;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	WebElement userName;

	/**
	 * @return the username
	 */
	public WebElement getUserName() {
		return userName;
	}

	@FindBy(name = "user_password")
	WebElement userPassword;

	/**
	 * @return the Password
	 */
	public WebElement getUserPassword() {
		return userPassword;
	}

	@FindBy(id = "submitButton")
	WebElement submitBtn;

	/**
	 * @return the submitBtn
	 */
	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void login() {
		FileUtility fu = new FileUtility();
	//	String URL = fu.getDataFromPropertiesFile("url");
		String USERNAME = fu.getDataFromPropertiesFile("username");
		String PASSWORD = fu.getDataFromPropertiesFile("password");

		userName.sendKeys(USERNAME);
		userPassword.sendKeys(PASSWORD);
		submitBtn.click();
	}

}

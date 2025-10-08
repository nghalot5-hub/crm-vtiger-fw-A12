package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage_1 {

	public CheckoutPage_1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "first-name")
	private WebElement firstName;
	
	@FindBy(id= "last-name")
	private WebElement lastName;

	@FindBy(id= "postal-code")
	private WebElement postalCode;
	
	@FindBy(css="input[type='submit']")
	private WebElement continueBtn;


	// getters
	public WebElement getFirstName() {
		return firstName;
	}
	
	public WebElement getLastName() {
		return lastName;
	}
	
	public WebElement getPostalCode() {
		return postalCode;
	}
	
	public WebElement getContinueBtn() {
		return continueBtn;
	}
	
	public void setValues() {
		getFirstName().sendKeys("Nidhi");
		getLastName().sendKeys("Mohan");
		getPostalCode().sendKeys("201204");
		getContinueBtn().click();
	}
}
		
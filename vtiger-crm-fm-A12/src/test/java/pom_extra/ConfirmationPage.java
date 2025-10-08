package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	public ConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className ="complete-header")
	private WebElement confirmation;

	// getters
	public WebElement getConfirmation() {
		return confirmation;
	}
	
	
}
		
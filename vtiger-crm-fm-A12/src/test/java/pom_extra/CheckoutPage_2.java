package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage_2 {

	public CheckoutPage_2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "FINISH")
	private WebElement finishBtn;

	// getters
	public WebElement geFinishBtn() {
		return finishBtn;
	}
}

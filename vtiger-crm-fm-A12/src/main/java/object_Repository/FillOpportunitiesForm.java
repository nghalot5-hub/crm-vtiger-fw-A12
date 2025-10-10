package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillOpportunitiesForm {

	public FillOpportunitiesForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img[title='Create Opportunity...']")
	WebElement ClickCreateOpportunitiesBtn;
	
	/**
	 * @return the opportunities
	 */
	public WebElement getClickCreateOpportunitiesBtn() {
		return ClickCreateOpportunitiesBtn;
	}
}

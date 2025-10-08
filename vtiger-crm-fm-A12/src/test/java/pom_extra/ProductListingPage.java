package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {

	public ProductListingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id="item_4_title_link")
	private WebElement selectProduct;
	
	//getters
	public WebElement getSelectProduct() {
		return selectProduct;
	}


}

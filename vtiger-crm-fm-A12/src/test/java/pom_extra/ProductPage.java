package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= "button[class='btn_primary btn_inventory']")
	private WebElement addToCart;
	
	@FindBy(css="path[fill='currentColor']")
	private WebElement cart;

	// getters
	public WebElement getAddToCart() {
		return addToCart;
	}
	public WebElement getCart() {
		return cart;
	}
}
		
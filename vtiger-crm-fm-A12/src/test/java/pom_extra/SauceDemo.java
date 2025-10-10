package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SauceDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "./resources/msedgedriver.exe");
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
		// driver.switchTo().alert().accept();

		// Home Page
		HomePage hp = new HomePage(driver);
		WebElement logo = hp.getLogo();
		System.out.println(logo.getText());

		// product listing page
		ProductListingPage plp = new ProductListingPage(driver);
		WebElement selectProduct = plp.getSelectProduct();
		System.out.println("product selected");
		selectProduct.click();

		// product page
		ProductPage pp = new ProductPage(driver);
		WebElement addToCart = pp.getAddToCart();
		addToCart.click();
		System.out.println("Product added to cart");
		// System.out.println("Product added to cart");
		WebElement cart = pp.getCart();
		cart.click();

		// Cart Page
		CartPage cp = new CartPage(driver);
		cp.getCheckout().click();
		System.out.println("Clicked on checkout");

		// Checkout page 1
		CheckoutPage_1 cop = new CheckoutPage_1(driver);
		cop.setValues();
		System.out.println("Clicked on checkout button");

		// Checkout page 2
		CheckoutPage_2 cop2 = new CheckoutPage_2(driver);
		cop2.geFinishBtn().click();
		System.out.println("Clicked on finish button");

		// confirmation page and verification
		ConfirmationPage confirm = new ConfirmationPage(driver);
		WebElement confirmPage = confirm.getConfirmation();
		if (confirmPage.getText().equals("THANK YOU FOR YOUR ORDER"))
			System.out.println("Pass");
		else
			System.out.println("Fail");

		Thread.sleep(5000);
		driver.quit();

	}

}

package genericUtility;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains reusable WebDriver utility methods such as window
 * management, waits, dropdown selections, mouse and keyboard interactions. It
 * also includes additional utilities such as alerts, scrolling, screenshot, JS
 * execution, drag-drop, sliders, and more.
 * 
 * @version 0.0.1
 * @author Nidhi Ghalot
 */
public class WebDriverUtility {
	WebDriver driver;
	WebDriverWait wait;
	

	public WebDriverUtility(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	/**
	 * Maximizes the browser window.
	 */
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * Minimizes the browser window.
	 */
	public void minimizeWindow() {
		driver.manage().window().minimize();
	}

	/**
	 * Makes the browser fullscreen.
	 */
	public void fullscreenWindow() {
		driver.manage().window().fullscreen();
	}

	// ----- Wait / Synchronization methods -----
	
	/**
	 * Applies implicit wait for the page to load.
	 */
	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	/**
	 * Waits explicitly until the element is clickable.
	 * 
	 * @param element        WebElement to wait for
	 */
	public void waitUntilClickable(WebElement element) {
			 wait.until(ExpectedConditions.elementToBeClickable((element)));
	}

	/**
	 * Waits explicitly until the element is visible.
	 * 
	 * @param element        WebElement to wait for
	 */
	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Waits explicitly until an element is invisible.
	 * 
	 * @param element        WebElement to wait for invisibility
	 *
	 */
	public void waitForElementInvisibility(WebElement element, int timeOutSeconds) {
		new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds)).until(ExpectedConditions.invisibilityOf(element));
	}
	
	/**
	 * Fluent wait example: Waits for an element to be present, polling every 1000ms etc.
	 * 
	 * @param locator        By locator of the element
	 * @param timeoutSeconds Max wait time in seconds
	 * @return WebElement once present
	 */
	public WebElement fluentWaitForElement(final By locator, int timeoutSeconds) {
		Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutSeconds))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class);

		return fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
	}
	
	/**
	 * Waits for the page title to contain given text.
	 * 
	 * @param titlePart      Partial or full title text
	 * 
	 */
	public void waitForTitleContains(String titlePart, int timeOutSeconds) {
		new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds))
				.until(ExpectedConditions.titleContains(titlePart));
	}

	


}

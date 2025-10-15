package types_Of_Executions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Demo3 {
	@Parameters("bro")
	@Test
	public void case3(String Browser) throws InterruptedException {
		WebDriver driver=null;
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		System.out.println(3);
		Thread.sleep(2000);
		driver.quit();
	}
}

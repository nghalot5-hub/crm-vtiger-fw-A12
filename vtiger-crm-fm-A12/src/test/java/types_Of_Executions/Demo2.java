package types_Of_Executions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo2 {
	@Test
	public void case1() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		System.out.println(2);
		Thread.sleep(2000);
		driver.quit();
	}
}

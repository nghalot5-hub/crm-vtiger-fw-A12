package types_Of_Executions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo1 {
	@Test
	public void case1() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		System.out.println(1);
		Thread.sleep(2000);
		driver.quit();
	}
	public void case11() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		System.out.println(1);
		Thread.sleep(2000);
		driver.quit();
	}
	

}

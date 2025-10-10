package testNG_extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTest {

	@Test(priority = -1)
	public void Case1() {
		System.out.println("Write in console ");
	}

	@Test()
	public void Case2() {
		Reporter.log("Write in Report");
	}

	@Test(priority = 1)
	public void Case3() {
		Reporter.log("Write in Report and console", true);
	}

}

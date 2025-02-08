package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import testBase.BaseClass;

public class HighLightElement extends BaseClass {

	@Test(groups = { "special" })
	public void highLightElement() {
		Homepage hm = new Homepage(driver);
		WebElement E = hm.element();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow')", E);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

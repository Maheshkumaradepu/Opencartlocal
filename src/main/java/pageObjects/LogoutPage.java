package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends Basepage {
	public WebDriver driver;

	public LogoutPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div[@id=\"content\"]/h1")
	WebElement logoutScreenHeader;

	@FindBy(xpath = "//a[contains(text(),\"Continue\")]")
	WebElement continuebtn;

	public String get_logoutheader() {
		return logoutScreenHeader.getText();
	}

	public void Click_continue() {
		continuebtn.click();
	}

}

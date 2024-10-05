package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Basepage {
	public WebDriver driver;

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id=\"content\"]/h2[1]")
	WebElement AccHeader;
	@FindBy(xpath = "//div/a[contains(text(),'Logout')]")
	WebElement Logoutbtn;

	public String verify_AccountpageAfterlogin() {
		return AccHeader.getText();
	}

	public void logout() {
		Logoutbtn.click();
	}

}

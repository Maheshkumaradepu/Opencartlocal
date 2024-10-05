package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {
	public WebDriver driver;

	public Homepage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAccount;

	@FindBy(linkText = "Register")
	WebElement registerBtn;

	@FindBy(linkText = "Login")
	WebElement loginBtn;

	// Clicks on 'My Account' to open the dropdown
	public void clickMyAccount() {
		myAccount.click();
	}

	// Clicks on 'Register' link inside 'My Account' dropdown
	public void register() {
		registerBtn.click();
	}

//Clicks on 'Login' inside My Account dropdown
	public void login() {
		loginBtn.click();
	}
}

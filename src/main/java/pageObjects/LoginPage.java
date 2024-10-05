package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement emailtxt;
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement pswdtxt;
	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement loginsubmitbtn;
	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]/i")
	WebElement errormsg;

	public void email_entry(String email) {
		emailtxt.sendKeys(email);
	}

	public void pswd_entry(String pswd) {
		pswdtxt.sendKeys(pswd);
	}

	public void login_submit() {
		loginsubmitbtn.click();
	}

	public String geterrormsg() {
		return	errormsg.getText();

	}
}

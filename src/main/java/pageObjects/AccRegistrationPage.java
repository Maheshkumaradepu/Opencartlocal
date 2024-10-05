package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccRegistrationPage extends Basepage {

	public AccRegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstNametxt;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastNametxt;

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailtxt;

	@FindBy(xpath = "//input[@name='telephone']")
	WebElement telephonetxt;

	@FindBy(xpath = "//input[@name='password']")
	WebElement psswdtxt;

	@FindBy(xpath = "//input[@name='confirm']")
	WebElement cnfpsswdtxt;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkbox;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement continuebtn;
	@FindBy(xpath = "//div[@id=\"content\"]/h1")
	WebElement succesmsg;

	public void setFirstName(String fName) {
		firstNametxt.sendKeys(fName);
	}

	public void setLastName(String lName) {
		lastNametxt.sendKeys(lName);
	}

	public void setEmail(String Email) {
		emailtxt.sendKeys(Email);
	}

	public void settelephone(String tlphn) {
		telephonetxt.sendKeys(tlphn);
	}

	public void setPwd(String pwd) {
		psswdtxt.sendKeys(pwd);
	}

	public void setcnfPwd(String cnfpwd) {
		cnfpsswdtxt.sendKeys(cnfpwd);
	}

	public void clickchkbx() {
		chkbox.click();
	}

	public void ctnu() {
		continuebtn.click();
	
	}

	public String getconfMsg() {
		try {
			return (succesmsg.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}
}

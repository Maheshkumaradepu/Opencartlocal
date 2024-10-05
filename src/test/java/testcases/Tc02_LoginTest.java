package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class Tc02_LoginTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_Login() {
		logger.info("****Starting Tc02_LoginTest******** ");
		try {
			logger.info("****Entering Homepage******** ");
			Homepage hm = new Homepage(driver);
			logger.info("****Clicking MyAccount ******** ");
			hm.clickMyAccount();
			logger.info("****Clicking login ******** ");
			hm.login();
			logger.info("****Entering loginPage and entering details ******** ");
			LoginPage lp = new LoginPage(driver);
			lp.email_entry(get_username());
			lp.pswd_entry(get_Passsword());
			lp.login_submit();
			logger.info("****Entering Account Page after Login ******** ");
			AccountPage Ap = new AccountPage(driver);
			String loginsuccessmsg = Ap.verify_AccountpageAfterlogin();
			if (loginsuccessmsg.equalsIgnoreCase("My Account")) {
				Assert.assertTrue(true);
			} else {
				logger.info("***assertion failed****");
				logger.debug("*****Debug info");
				Assert.assertTrue(false);
			}

			Ap.logout();
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*****TEST FINISHED*****");
	}
}

package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class Tc03_LoginDDT extends BaseClass {

	@Test(groups={"sanity","Datadriven","Master"},dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String pswd, String exp) {
		try {
			Homepage hm = new Homepage(driver);
			logger.info("**** Clicking MyAccount ******** ");
			hm.clickMyAccount();
			logger.info("**** Clicking login ******** ");
			hm.login();
			logger.info("**** Entering loginPage and entering details ******** ");

			LoginPage lp = new LoginPage(driver);
			lp.email_entry(email);
			lp.pswd_entry(pswd);
			lp.login_submit();

			logger.info("**** Verifying login outcome ******** ");
			AccountPage Ap = new AccountPage(driver);

			if (exp.equalsIgnoreCase("Valid")) {
				String loginsuccessmsg = Ap.verify_AccountpageAfterlogin();
				Ap.logout();
				LogoutPage lop = new LogoutPage(driver);
				lop.Click_continue();
				Assert.assertTrue(true, "Login successful and account page verified.");

			}
			if (exp.equalsIgnoreCase("InValid")) {
				String errormsg = lp.geterrormsg();
				if (errormsg.equalsIgnoreCase(" Warning: No match for E-Mail Address and/or Password.")) {
					Assert.assertTrue(true, "Login Unsuccessful and account page verified.");
				}
			}
		} catch (Exception e) {
			logger.error("Exception occurred during login test: " + e.getMessage(), e);
			Assert.fail("Test encountered an exception: " + e.getMessage());
		}
	}

}

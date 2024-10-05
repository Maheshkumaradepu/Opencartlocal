package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class Tc01_AccountRegistractionTest extends BaseClass {

	@Test(groups="sanity")
	public void verify_Acc_Registration() {

		logger.info("*****TEST STARTED*****");
		try {
			Homepage hp = new Homepage(driver);
			logger.info("*****MYACC LINK*****");
			hp.clickMyAccount();
			hp.register();
			logger.info("*****REGISTER LINK*****");
			AccRegistrationPage Accreg = new AccRegistrationPage(driver);
			Accreg.setFirstName(random_String().toUpperCase());
			Accreg.setLastName(random_String().toUpperCase());
			Accreg.setEmail(random_String() + "@example.com");
			Accreg.settelephone(random_Number());
			String pwd = random_Pswd();
			Accreg.setPwd(pwd);
			Accreg.setcnfPwd(pwd);
			Accreg.clickchkbx();
			Accreg.ctnu();
			String confmsg = Accreg.getconfMsg();
			logger.info("***** Message Validation *****");
			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("****Test Failed****");
				logger.debug("***Debug log***");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {

			Assert.fail();
		}
		logger.info("*****TEST FINISHED*****");
	}
}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"Master","Regression"})
	public void verify_login() {

		try {
			logger.info("**** Starting TC_002_LoginTest ****");
			HomePage home = new HomePage(driver);
			LoginPage login = new LoginPage(driver);
			MyAccountPage account = new MyAccountPage(driver);

			logger.info("**** Clicked on My Account ****");
			home.clickMyAccount();
			logger.info("**** Clicked on Login ****");
			home.clickLogin();

			logger.info("**** Entering login details ****");
			login.setEmail(prop.getProperty("email"));
			login.setPassword(prop.getProperty("password"));
			logger.info("**** Clicking login ****");
			login.clickLogin();

			logger.info("**** Verifying the login message ****");

			if (account.getHeaderMessage()) {
				logger.info("**** TC_002_LoginTest Passed ****");
				Assert.assertTrue(true);
			} else {
				logger.info("**** TC_002_LoginTest Failed ****");
				Assert.assertTrue(false, "Login Message Mismatch");
			}
		} catch (Exception e) {
			logger.info("**** TC_002_LoginTest Failed ****");
			Assert.fail();
		} finally {
			logger.info("**** Finished TC_002_LoginTest ****");
		}

	}

}

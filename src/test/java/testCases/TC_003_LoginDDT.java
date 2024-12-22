package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String password, String status, String result) throws InterruptedException {
		logger.info("**** Starting TC_003_LoginDDT  ****");
		try {
			
			HomePage home = new HomePage(driver);
			logger.info("**** Clicking My Account  ****");
			home.clickMyAccount();
			logger.info("**** Clicking Login  ****");
			home.clickLogin();

			logger.info("**** Entering login details ****");
			LoginPage login = new LoginPage(driver);
			login.setEmail(email);
			login.setPassword(password);
			login.clickLogin();

			logger.info("**** verifying login message ****");
			MyAccountPage macc = new MyAccountPage(driver);
			boolean isPassed = macc.getHeaderMessage();

			if (status.equalsIgnoreCase("valid")) {
				if (isPassed) {
					logger.info("****  TC_003_LoginDDT Passed ****");
					macc.clickLogout();
					Assert.assertTrue(true);		
				} else {
					logger.info("****  TC_003_LoginDDT Failed ****");
					Assert.assertTrue(false);
				}
			} else if (status.equalsIgnoreCase("invalid")) {
				if (isPassed) {
					logger.info("****  TC_003_LoginDDT Failed ****");
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					logger.info("****  TC_003_LoginDDT Passed ****");
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			logger.error("**** TC_003_LoginDDT  Failed ****");
			Assert.fail();
		} finally {
			logger.info("**** Finished TC_003_LoginDDT  ****");
		}
		Thread.sleep(1000);

	}

}

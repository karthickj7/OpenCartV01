package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "master" })
	public void verify_user_registartion() {

		logger.info("**** Starting TC_001_AccountRegistrationTest ****");
		try {
			/* All Object Creation */
			HomePage home = new HomePage(driver);
			RegisterPage register = new RegisterPage(driver);

			home.clickMyAccount();
			logger.info("**** Clicked on MyAccount ****");
			home.clickRegister();
			logger.info("**** Clicked on Register ****");

			logger.info("**** Entering Details ****");

			register.setFirstName(this.randomString());
			register.setLastName(this.randomString());
			register.setEmail(this.randomString() + "@gmail.com");
			register.setTelephone(this.randomNumber());
			String password = this.randomString();
			register.setPassWord(password);
			register.setConfirmPassWord(password);
			register.optNewsLetter(false);
			register.agreePrivacyPolicy();
			logger.info("**** Clicking Continue****");
			register.clickContinue();

			logger.info("**** Validating Error Message****");
			String message = register.getConfirmationMsg();
			if (message.equals("Your Account Has Been Created")) {
				logger.info("---- TC_001_AccountRegistrationTest Passesd ----");
				Assert.assertTrue(true);
			} else {
				logger.error("---- TC_001_AccountRegistrationTest Failed ----");
				Assert.fail();
			}
			
		} catch (Exception e) {
			logger.error("---- TC_001_AccountRegistrationTest Failed ----");
			Assert.fail();
		} finally {
			logger.info("**** Finished TC_001_AccountRegistrationTest ****");
		}
	}

}

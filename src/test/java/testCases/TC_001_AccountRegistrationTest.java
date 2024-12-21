package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test
	public void verify_user_registartion() {

		HomePage home = new HomePage(driver);
		// Opens Registration Page
		home.clickMyAccount();
		home.clickRegister();

		RegisterPage register = new RegisterPage(driver);
		/*
		 * Enters Users details
		 */
		register.setFirstName(this.randomString());
		register.setLastName(this.randomString());
		register.setEmail(this.randomString() + "@gmail.com");
		register.setTelephone(this.randomNumber());
		String password = this.randomString();
		register.setPassWord(password);
		register.setConfirmPassWord(password);
		register.optNewsLetter(false);
		register.agreePrivacyPolicy();
		register.clickContinue();

		Assert.assertEquals(register.getConfirmationMsg(), "Your Account Has Been Created!",
				"Confirmation message mismatch");
	}

}

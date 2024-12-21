package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement txt_firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement txt_lastName;

	@FindBy(xpath = "//input[@name='email']")
	WebElement txt_email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txt_telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_confirmPassword;

	@FindBy(xpath = "//input[@name='newsletter' and @value='1']")
	WebElement chkd_newsletter_yes;

	@FindBy(xpath = "//input[@name='newsletter' and @value='0']")
	WebElement chkd_newsletter_no;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkd_privacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_continue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String fName) {
		txt_firstName.sendKeys(fName);
	}

	public void setLastName(String lName) {
		txt_lastName.sendKeys(lName);
	}

	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}

	public void setTelephone(String phone) {
		txt_telephone.sendKeys(phone);
	}
	public void setPassWord(String password) {
		txt_password.sendKeys(password);
	}

	public void setConfirmPassWord(String password) {
		txt_confirmPassword.sendKeys(password);
	}

	public void optNewsLetter(boolean bool) {
		if (bool == true)
			chkd_newsletter_yes.click();
		else if (bool == false)
			chkd_newsletter_no.click();
	}

	public void agreePrivacyPolicy() {
		chkd_privacyPolicy.click();
	}

	public void clickContinue() {
		btn_continue.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}

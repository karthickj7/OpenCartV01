package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement btn_myAccount;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement btn_register;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement btn_login;

	public void clickMyAccount() {
		btn_myAccount.click();
	}

	public void clickLogin() {
		btn_login.click();
	}

	public void clickRegister() {
		btn_register.click();
	}

}

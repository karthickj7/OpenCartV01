package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {

	public loginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="input-email")
	WebElement txt_email;
	
	@FindBy(id="input-password")
	WebElement txt_password;
	
	@FindBy(xpath="//button[text()=\"Login\"]")
	WebElement btn_login;
	
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void setPassword(String pass) {
		txt_password.sendKeys(pass);
	}
	
	public void clickLogin() {
		btn_login.click();
	}

}

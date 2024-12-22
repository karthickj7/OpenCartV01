package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div/h2[text()=\"My Account\"]")
	WebElement msgHeading;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement btn_logout;
	
	public String getHeaderMessage() {
		return msgHeading.getText();
	}
	
	public void clickLogin() {
		btn_logout.click();
	}

}

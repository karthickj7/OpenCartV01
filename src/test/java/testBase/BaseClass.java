package testBase;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	public Logger logger;

	@BeforeClass
	public void setup() throws Exception {
		
		logger = LogManager.getLogger(BaseClass.class);
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		driver = new ChromeDriver();
		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}

	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphanumeric(6);
		return generatedString;
	}
}

package testBase;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	public Logger logger;

	@BeforeClass(groups= {"Master","Sanity","DataDriven"})
	@Parameters({ "os", "browser" })
	public void setup(String os, String browserName) throws Exception {

		logger = LogManager.getLogger(BaseClass.class);

		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);

		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invaild browser name");
			break;
		}

		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass(groups= {"Master","Sanity","DataDriven"})
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
	}

	public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
	}

	public String randomAlphaNumeric() {
        return RandomStringUtils.randomAlphanumeric(6);
	}
}

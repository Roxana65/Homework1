package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

public static WebDriver driver;
public BasePage page;
	
	@BeforeClass
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    driver.get("https://keybooks.ro/");
	    page= new BasePage();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
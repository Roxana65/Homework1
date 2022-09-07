package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AwardPage {

	WebDriver driver;

	public AwardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='award winners']")
	public WebElement awardSection;
	@FindBy(xpath = "(//a[@href='the-long-road-to-the-deep-silence'])[3]")
	public WebElement carte;

	public void navigateTo(WebElement element) throws InterruptedException {
		element.click();
		Thread.sleep(3000);
	}
}

package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookPage {

	public WebDriver driver;

	public BookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='q_inc']")
	public WebElement cantitate;
	@FindBy(xpath = "//button[@name='add-to-cart']")
	public WebElement addToCart;
	@FindBy(xpath = "//span[@class='contact_icon icon-cart']")
	public WebElement iconCart;

	public void cantitateC(WebElement element) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
		Thread.sleep(3000);
	}

	public void clickOnElem(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}

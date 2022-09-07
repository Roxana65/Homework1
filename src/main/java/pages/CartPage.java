package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://keybooks.ro/cart/'])[1]")
	public WebElement viewCartButton;
	@FindBy(xpath = "(//*[contains(text(),'The long road to the deep Silence')])[1]")
	public WebElement bookCart;
	@FindBy(xpath = "//input[@value='3']")
	public WebElement numberOfBooks;
	@FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
	public WebElement checkOutButton;
	@FindBy(xpath = "//a[@class='showlogin']")
	public WebElement loginButton;
	@FindBy(xpath = "(//input[@class='input-text'])[1]")
	public WebElement userField;
	@FindBy(xpath = "(//input[@id='password'])[3]")
	public WebElement passwordField;
	@FindBy(xpath = "//button[@name='login']")
	public WebElement submitButton;
	@FindBy(xpath = "//button[@name='woocommerce_checkout_place_order']")
	public WebElement placeOrderButton;
	@FindBy(xpath = "//*[contains(text(),'Thank you for your order, please click the button below to pay.')]")
	public WebElement message;
	@FindBy(xpath = "//li[@class='order']")
	public WebElement orderNumber;
	@FindBy(xpath = "//span[@class='user_name']")
	public WebElement userNameButton;
	@FindBy(xpath = "//a[@class='icon icon-cog']")
	public WebElement settings;
	@FindBy(xpath = "(//*[contains(text(),'Orders')])[1]")
	public WebElement orders;
	@FindBy(xpath = "(//td[@data-title='Order'])[1]")
	public WebElement lastOrderNumber;

	public void clickM(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void login(String username, String password) throws InterruptedException {
		userField.sendKeys(username);
		passwordField.sendKeys(password);
		Thread.sleep(3000);
		submitButton.click();
		Thread.sleep(2000);
	}

	public void hoverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
}

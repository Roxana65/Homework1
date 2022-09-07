package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.BaseTest;

public class AddToCartTest extends BaseTest {

	@Test(priority = 0)
	public void addToC() throws InterruptedException {
		page.award.navigateTo(page.award.awardSection);
		page.award.navigateTo(page.award.carte);
		page.book.cantitateC(page.book.addToCart);
		page.book.clickOnElem(page.book.addToCart);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(page.book.addToCart));

		page.book.clickOnElem(page.book.addToCart);
		page.book.clickOnElem(page.book.iconCart);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(page.book.iconCart));

		assertTrue(page.book.iconCart.isDisplayed());
	}

	@Test(priority = 1)
	public void addToCartResult() throws InterruptedException {
		page.cart.clickM(page.cart.viewCartButton);
		Thread.sleep(3000);
		assertTrue(page.cart.bookCart.isDisplayed());
		Thread.sleep(3000);
		assertTrue(page.cart.numberOfBooks.isDisplayed());
		page.cart.clickM(page.cart.checkOutButton);
		page.cart.clickM(page.cart.loginButton);
		page.cart.login("TestUser", "12345@67890");
		Thread.sleep(3000);
		page.cart.clickM(page.cart.placeOrderButton);
		Thread.sleep(3000);
		assertEquals(page.cart.message.getText(), "Thank you for your order, please click the button below to pay.");
		assertTrue(page.cart.orderNumber.isDisplayed());
		Thread.sleep(2000);
		page.cart.hoverAction(page.cart.userNameButton);
		page.cart.clickM(page.cart.settings);
		page.cart.clickM(page.cart.orders);
		Thread.sleep(2000);

	}
}

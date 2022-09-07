package utils;

import pages.AwardPage;
import pages.BookPage;
import pages.CartPage;

public class BasePage extends BaseTest {

	public AwardPage award = new AwardPage(driver);
	public BookPage book = new BookPage(driver);
	public CartPage cart = new CartPage(driver);
}

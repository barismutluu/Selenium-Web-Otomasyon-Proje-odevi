package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By searchInputLocator = By.xpath("//input[@id='search-input']");
    By acceptCookiesButton = By.id("cookiescript_accept");

    public HomePage(WebDriver driver) {
        super(driver);
        acceptCookies(acceptCookiesButton); // 🍪 cookie popup geçilir
    }

    /** Arama kutusuna verilen kelimeyi yazar ve ENTER basar */
    public void searchRoman(String text) {
        type(searchInputLocator, text);
        driver.findElement(searchInputLocator).sendKeys(Keys.ENTER);
    }
}

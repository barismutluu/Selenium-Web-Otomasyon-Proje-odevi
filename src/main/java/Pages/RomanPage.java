package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RomanPage extends BasePage {

    By productRomanLocator = By.xpath("//div[@class='cover']");
    By addCartLocator = By.xpath("//a[@id='button-cart']");
    By cartCountLocator = By.xpath("//span[text()='1']");
    By cartLocator = By.xpath("//span[@id='cart-items']");
    By goToCartLocator = By.xpath("//a[@id='js-cart']");

    public RomanPage(WebDriver driver) {
        super(driver);

    }

    /** Listeden verilen index’teki romanı seçip sepete ekler */
    public void chooseRoman(int index) {
        getAllRomans().get(index).click();
        click(addCartLocator);
    }

    /** Sepet sayacı 1 oldu mu */
    public boolean isProductAddedToCart() {
        return find(cartCountLocator).isDisplayed();
    }

    /** Sepet sayfasına gider */
    public void goToCart() {
        click(cartLocator);
        click(goToCartLocator);
    }

    private List<WebElement> getAllRomans() {
        return findAll(productRomanLocator);
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    By quantityInputLocator = By.xpath("//input[@name='quantity']");
    By upgradeButtonLocator = By.xpath("//i[@title='Güncelle']");
    By removeProductButtonLocator = By.xpath("//i[@title='Kaldır']");
    By updateMessageLocator = By.xpath("//h2[text()='Sepetiniz güncelleniyor!']");
    By removeMessageLocator = By.xpath("//h2[text()='Sepetinizden çıkarılıyor!']");
    public CartPage(WebDriver driver) {
        super(driver);

    }

    /** Ürün miktarını artırır */
    public void increaseProductQuantity() {
        WebElement quantityInput = driver.findElement(quantityInputLocator);
        quantityInput.sendKeys(Keys.BACK_SPACE, "2");
        click(upgradeButtonLocator);
    }

    /** Sepet güncelleme mesajı görünüyor mu */
    public boolean isCartUpdated() {
        return driver.findElement(updateMessageLocator).isDisplayed();
    }

    /** Ürünü sepetten siler */
    public void removeProductFromCart() {
        click(removeProductButtonLocator);
    }

    /** Sepetten silme mesajı görünüyor mu */
    public boolean isProductRemoved() {
        return driver.findElement(removeMessageLocator).isDisplayed();
    }
}

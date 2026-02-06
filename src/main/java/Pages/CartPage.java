package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {

    // Locators
    private final By increaseQuantityButton = By.id("plus-button-687154");
    private final By removeProductButton = By.cssSelector(".js-remove-button");
    private final By confirmRemoveButton = By.xpath("//button[normalize-space()='Sil']");
    private final By cartRow = By.cssSelector(".cart-item");
    private final By cartUpdatedMessage = By.xpath("//*[contains(text(),'Sepetiniz')]");

    private final WebDriverWait wait;

    public CartPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /** Ürün miktarını artırır */
    public void increaseProductQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(increaseQuantityButton))
                .click();
    }

    /** Sepet güncellendi mi */
    public boolean isCartUpdated() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartUpdatedMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** Ürünü sepetten siler (STALE + AJAX SAFE) */
    public void removeProductFromCart() {
        try {
            // Sil ikonuna tıkla (JS click → DOM refresh safe)
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    wait.until(ExpectedConditions.presenceOfElementLocated(removeProductButton))
            );

            // Modal'daki Sil butonu
            wait.until(ExpectedConditions.elementToBeClickable(confirmRemoveButton))
                    .click();

            // Ürün satırı DOM'dan kalkana kadar bekle
            wait.until(driver ->
                    driver.findElements(cartRow).size() == 0
            );

        } catch (StaleElementReferenceException e) {
            throw new RuntimeException("Ürün silinirken DOM yenilendi (stale)", e);
        }
    }

    /** Ürün sepetten silindi mi */
    public boolean isProductRemoved() {
        return wait.until(driver ->
                driver.findElements(cartRow).isEmpty()
        );
    }
}

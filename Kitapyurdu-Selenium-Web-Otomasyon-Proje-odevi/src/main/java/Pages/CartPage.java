package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{
    By upgradebuttonLocator=By.xpath("//i[@title='Güncelle']");
    By removeproductbuttonLocator=By.xpath("//i[@title='Kaldır']");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void productincrease() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(Keys.BACK_SPACE,"2");
        click(upgradebuttonLocator);
        Thread.sleep(1000);
        WebElement GuncellemeKontrol=driver.findElement(By.xpath("//h2[text()='Sepetiniz güncelleniyor!']"));
        Assertions.assertTrue(GuncellemeKontrol.isDisplayed(),"Ürün Miktar Artışı olmadı");
        Thread.sleep(1000);
        click(removeproductbuttonLocator);
        Thread.sleep(1000);
        WebElement SilinenSepetKontrol=driver.findElement(By.xpath("//h2[text()='Sepetinizden çıkarılıyor!']"));
        Assertions.assertTrue(SilinenSepetKontrol.isDisplayed(),"Sepetten Ürün Silinmedi!");
    }
}

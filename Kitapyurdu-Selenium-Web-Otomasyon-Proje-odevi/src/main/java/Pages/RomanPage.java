package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class RomanPage extends BasePage{
   By productRomanLocator=By.xpath("//div[@class='cover']");
   By addcartLocator=By.xpath("//a[@id='button-cart']");
   By cartLocator=By.xpath("//span[@id='cart-items']");
   By gotocart=By.xpath("//a[@id='js-cart']");
    public RomanPage(WebDriver driver) {
        super(driver);
    }

    public void choseroman(int i) throws InterruptedException {
        Thread.sleep(1000);
        getAllRoman().get(i).click();
        click(addcartLocator);
        WebElement SepetKontrol=driver.findElement(By.xpath("//span[text()='1']"));
        Assertions.assertTrue(SepetKontrol.isDisplayed(),"Sepet Değeri Artışı Olmadı.");
        click(cartLocator);
        click(gotocart);
    }

    private List<WebElement> getAllRoman(){
        return findAll(productRomanLocator);
    }
}


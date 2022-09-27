import Pages.CartPage;
import Pages.HomePage;
import Pages.RomanPage;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class KitapyurduTest extends BaseTest{
    HomePage homePage;
    RomanPage romanPage;
    CartPage cartPage;
    @Test
    @Order(1)
    public void Search() throws CsvValidationException, IOException {
        homePage=new HomePage(driver);
        homePage.searchroman();
    }
    @Test
    @Order(2)
    public void ChoseRoman() throws InterruptedException {
        romanPage=new RomanPage(driver);
        romanPage.choseroman(4);
    }
    @Test
    @Order(3)
    public void Cart() throws InterruptedException {
        cartPage=new CartPage(driver);
        cartPage.productincrease();
    }

}

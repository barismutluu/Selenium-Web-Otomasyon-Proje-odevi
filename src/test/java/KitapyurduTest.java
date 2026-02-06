import Pages.CartPage;
import Pages.HomePage;
import Pages.RomanPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KitapyurduTest extends BaseTest {

    HomePage homePage;
    RomanPage romanPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void searchRomanTest() {
        homePage = new HomePage(driver);
        homePage.searchRoman("roman");
    }

    @Test
    @Order(2)
    public void chooseRomanTest() {
        romanPage = new RomanPage(driver);
        romanPage.chooseRoman(0);

        Assertions.assertTrue(
                romanPage.isProductAddedToCart(),
                "Sepete ürün eklenmedi"
        );

        romanPage.goToCart();
    }

    @Test
    @Order(3)
    public void cartOperationsTest() {
        cartPage = new CartPage(driver);

        cartPage.increaseProductQuantity();
        Assertions.assertTrue(
                cartPage.isCartUpdated(),
                "Ürün miktarı güncellenmedi"
        );

        cartPage.removeProductFromCart();
        Assertions.assertTrue(
                cartPage.isProductRemoved(),
                "Ürün sepetten silinmedi"
        );
    }
}
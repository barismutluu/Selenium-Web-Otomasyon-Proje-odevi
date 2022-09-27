package Pages;

import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage extends BasePage{
    By search=By.xpath("//input[@id='search-input']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchroman() throws CsvValidationException, IOException {
        read(search);

    }
}

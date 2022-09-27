package Pages;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BasePage {  WebDriver driver ;

    public BasePage(WebDriver driver){
        this.driver = driver ;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void type(By locator , String text){
        find(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public void read(By locator) throws CsvValidationException, IOException {
        String CSV_file="CSV_Dosyasi/roman.csv";
        String[] cell;
        CSVReader reader=new CSVReader(new FileReader(CSV_file));
        cell=reader.readNext();
        String AranacakKelime=cell[0];
        WebElement Search = driver.findElement(locator);
        Search.sendKeys(AranacakKelime, Keys.ENTER);
    }

}


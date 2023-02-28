package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BagsPage {
    public WebDriver driver;

    public BagsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement showcart;

    @FindBy(xpath = "//strong[@class='subtitle empty']")
    WebElement emptycart;

   /* @FindBy(xpath = "//img[@alt='Impulse Duffle']/ancestor::a/following-sibling::div/strong/a")
    WebElement highestPriceName;*/

    public void cart() {

        showcart.click();
    }
   /* public void emptyCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(emptycart).perform();
        Assert.assertTrue(emptycart.isDisplayed());
        System.out.println(emptycart.getText());
    }*/

   public Double highestPriceName() {
       List<WebElement> listPrices = driver.findElements(By.xpath("//span[@data-price-type='finalPrice']/span"));
       List<Double> allPrices = new ArrayList<>();
       for (WebElement prices : listPrices) {
           allPrices.add(Double.parseDouble(prices.getText().replace("$", "")));
       }
       Double highestprice = Collections.max(allPrices);
       System.out.println("Highest price : " + highestprice);
       WebElement highestPriceBag = driver.findElement(By.xpath("//span[@data-price-type='finalPrice']/span[contains(.,'"+highestprice+"')]/parent::span/parent::span/parent::div/preceding-sibling::strong/a"));
       System.out.println(highestPriceBag.getText());
       highestPriceBag.click();
       return highestprice;
   }

}

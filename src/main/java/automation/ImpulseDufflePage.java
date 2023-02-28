package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ImpulseDufflePage {
    public WebDriver driver;

    public ImpulseDufflePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Add to Wish List']")
    WebElement addToWishList;

   /* @FindBy(xpath = "//div[@class='product-item-info']/strong/a")
    WebElement wishListItem;

    @FindBy(xpath = "//button[@class='action tocart']")
    WebElement addToCart;*/

    public void wishListAdd() {
        addToWishList.click();
        /*Actions actions = new Actions(driver);
        actions.moveToElement(wishListItem).perform();
        Assert.assertTrue(wishListItem.isDisplayed());
        System.out.println(wishListItem.getText());
        addToCart.click();*/
    }
}

package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class WishListPage {
    public WebDriver driver;

    public WishListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='product-item-info']/strong/a")
    WebElement wishListItem;

    @FindBy(xpath = "//button[@class='action tocart']")
    WebElement addToCart;

    @FindBy(xpath = "//div[@class='message info empty']")
    WebElement emptyWishList;

    @FindBy(xpath = "//div[@data-block='minicart']/a[@class='action showcart']")
    WebElement clickCart;

    @FindBy(xpath = "//button[@title='Proceed to Checkout']")
    WebElement checkout;


    public void wishlistItem() {
        Actions actions = new Actions(driver);
        actions.moveToElement(wishListItem).perform();
        Assert.assertTrue(wishListItem.isDisplayed());
        System.out.println(wishListItem.getText());
        addToCart.click();
    }

    public void emptyWishlist() throws InterruptedException {
        String emptywishlist = "You have no items in your wish list.";
        String wishlistempty = emptyWishList.getText();
        System.out.println(wishlistempty);
        Assert.assertTrue(emptywishlist.contains(wishlistempty));
        Thread.sleep(2000);
    }

    public void clickOnCart() throws InterruptedException {
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        clickCart.click();
    }

    public void checkOut() throws InterruptedException {
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        checkout.click();


    }
}

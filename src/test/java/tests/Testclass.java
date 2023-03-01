package tests;

import automation.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

public class Testclass extends BaseClass {

    public LaunchPage launchPage;
    public WelcomePage welcomePage;
    public BagsPage bagsPage;
   public ImpulseDufflePage impulseDufflePage;
   public WishListPage wishListPage;
   public ShippingAddressPage shippingAddressPage;
   public ReviewAndPaymentsPage reviewAndPaymentsPage;
   public OrderNumberPage orderNumberPage;


    @BeforeTest
    public void initializingPages() {
        System.out.println("Pages initialized");
        launchPage = new LaunchPage(driver);
        welcomePage = new WelcomePage(driver);
        bagsPage = new BagsPage(driver);
        impulseDufflePage = new ImpulseDufflePage(driver);
        wishListPage = new WishListPage(driver);
        shippingAddressPage = new ShippingAddressPage(driver);
        reviewAndPaymentsPage = new ReviewAndPaymentsPage(driver);
        orderNumberPage = new OrderNumberPage(driver);

    }

    @Test
    public void signIn() throws Exception, IOException, ParseException {
        launchPage.signin("sowmya.budumuru@gmail.com", "Abcd@1234");
        welcomePage.gear();
        bagsPage.cart();
        bagsPage.highestPriceName();
        impulseDufflePage.wishListAdd();
        wishListPage.wishlistItem();
        wishListPage.emptyWishlist();
        wishListPage.clickOnCart();
        wishListPage.checkOut();
        shippingAddressPage.fillShippingAddress();
        shippingAddressPage.nextelement();
        reviewAndPaymentsPage.placingOrder();
        orderNumberPage.orderNumber();

    }

   /* @Test
    public void verfication() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String emptycart = "You have no items in your shopping cart.";
        String emptyCart =  driver.findElement(By.xpath("//strong[@class='subtitle empty']")).getText();
        System.out.println(emptyCart);
        Assert.assertTrue(emptycart.contains(emptyCart));
    }*/

}

package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewAndPaymentsPage {
    public WebDriver driver;

    public ReviewAndPaymentsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='actions-toolbar']/div/button[@class='action primary checkout']")
    WebElement placeorder;

    public void placingOrder() throws InterruptedException {
        Thread.sleep(8000);
        placeorder.click();
    }
}

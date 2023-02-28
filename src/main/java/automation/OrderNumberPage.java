package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderNumberPage {
    public WebDriver driver;

    public OrderNumberPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='order-number']")
    WebElement ordernumber;

    @FindBy(xpath = "//span[@class='base']")
    WebElement order;

    public void orderNumber() throws InterruptedException {
        Thread.sleep(3000);
        ordernumber.click();
        order.isDisplayed();
        System.out.println(order.getText());
    }
}

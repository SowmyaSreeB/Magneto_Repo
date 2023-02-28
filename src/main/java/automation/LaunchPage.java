package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage {
    public WebDriver driver;

    public LaunchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        System.out.println("Driver assigning");
    }

    @FindBy(name = "login[username]")
    WebElement loginUsernameBox;

    @FindBy(name = "login[password]")
    WebElement loginPasswordBox;

    @FindBy(name = "send")
    WebElement signinButton;

   /**//* @FindBy(name = "captcha[user_login]")
    WebElement CaptchaBox;*/

    public void signin(String emailid, String password) {
        loginUsernameBox.sendKeys(emailid);
        System.out.println("Successfully entered username");
        loginPasswordBox.sendKeys(password);
        System.out.println("Successfully entered password");
        signinButton.click();
        System.out.println("successfully logged in");

    }

}

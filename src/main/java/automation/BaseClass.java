package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
    public WebDriver driver;

   @BeforeSuite
    public void initializeWebDriver() {
        System.out.println("Initilizing Webdriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Parameters({"serverlink"})
  @BeforeSuite
  public void lamdatest(String serverlink) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        ChromeOptions chromeOptions=new ChromeOptions();
        desiredCapabilities.setCapability("browser", "chrome");
        desiredCapabilities.merge(chromeOptions);
        driver=new RemoteWebDriver(new URL(serverlink),chromeOptions);
       // driver.get("https://magento.softwaretestingboard.com/customer/account/");
    }

 @BeforeTest
    public void launchApplication() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
    }

    @AfterSuite
    public void quitSession() {
        driver.quit();
    }
}

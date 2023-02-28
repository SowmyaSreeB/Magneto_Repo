package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

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
  @BeforeClass
  public void lamdatest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        ChromeOptions chromeOptions=new ChromeOptions();
        desiredCapabilities.setCapability("browser", "chrome");
        desiredCapabilities.merge(chromeOptions);
        driver=new RemoteWebDriver(new URL("https://sowmyasri.budumuru:fhux4Re4Ue5jcc4OCWCAYPibunZhacFkW9yWQMwToWRyunF8t2@hub.lambdatest.com/wd/hub"),chromeOptions);
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
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

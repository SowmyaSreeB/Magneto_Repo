package automation;

import commonMethod.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readDataFromFile.ReadData;

import java.io.IOException;
import java.text.ParseException;

public class ShippingAddressPage {
    public WebDriver driver;
    SeleniumActions seleniumActions;
    ReadData readData;

    public ShippingAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
       readData = new ReadData();
    }
    @FindBy(xpath ="//input[@name='street[0]']")
    WebElement addressline1;

    @FindBy(xpath = "//input[@name='city']")
    WebElement citytextfield;

    @FindBy (xpath = "//select[@name='country_id']")
    WebElement countrydropdown;

    @FindBy(xpath = "//select[@ name='region_id']")
    WebElement statedropdown;

    @FindBy(xpath = "//input[@ name='postcode']")
    WebElement postcodetextfield;

    @FindBy(xpath = "//input[@name='telephone']")
    WebElement phonenumbertextfield;

    @FindBy(xpath = "//input[@value='tablerate_bestway']")
    WebElement shippingMethod;
@FindBy(xpath = "//span[text()='Next']")
WebElement next;
    public void fillShippingAddress() throws IOException, ParseException, Exception {
Thread.sleep(5000);
        //seleniumActions.EnterValueOnTextfield(companytextfield,readData.readFile("company") );
        seleniumActions.EnterValueOnTextfield(addressline1, readData.readFile("address1"));
//        seleniumActions.EnterValueOnTextfield(addressline2, readData.readFile("address2"));
//        seleniumActions.EnterValueOnTextfield(addressline3,readData.readFile("address3"));
        seleniumActions.EnterValueOnTextfield(citytextfield,readData.readFile("city"));
        seleniumActions.selectValueFromDropDown(countrydropdown,readData.readFile("countryvalue"),"value");
        seleniumActions.selectValueFromDropDown(statedropdown,readData.readFile("statevalue"), "value");
        seleniumActions.EnterValueOnTextfield(postcodetextfield,readData.readFile("postcode"));

        seleniumActions.EnterValueOnTextfield(phonenumbertextfield,readData.readFile("phone"));
    }
    public void nextelement() throws InterruptedException {
        Thread.sleep(5000);
        next.click();
    }
    }

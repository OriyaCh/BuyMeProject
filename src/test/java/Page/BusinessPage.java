package Page;

import Page.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BusinessPage extends BasePage {
    private WebDriver driver;
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("Business Page", "Business Selection Page");

    public BusinessPage (){this.driver = DriverSingelton.getDriverInstance() ; }

    public void business(){
        assertURL();
        pickBusiness();
        choosePrice();
        pressEnter();
    }

    public void pickBusiness (){
        clickElement(By.xpath("//*[@id=\"ember2777\"]/div[4]"));
        test.log(Status.INFO, "pick business");
    }
    public void assertURL(){
        String expect  ="https://buyme.co.il/supplier/2711?budget=3&category=204&query=&region=13";
        String real = String.valueOf(driver.findElement(By.xpath("//*[@id=\"ember2777\"]/div[4]")));
        Assert.assertEquals(expect,real);
        test.log(Status.INFO, "equal url true of business ");
    }
    public void choosePrice (){
        sendKeysToElement(By.id("ember2657"),"200");
        test.log(Status.INFO, "pick price ");
    }
   public void pressEnter(){
        clickElement(By.id("ember2870"));
       test.log(Status.INFO, "business page test ended ");
   }
}

package Page;

import Page.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
    private WebDriver driver;
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("Home Page", "BuyMe Home Page");

    public HomePage ()
    {this.driver = DriverSingelton.getDriverInstance() ;
    }


    public void pickGift(){
        pickSum();
        pickRegion();
        pickCategory();
        pressFindGift();
    }
    public void pickSum(){
        Select mySelection = new Select(driver.findElement(getElement((By.xpath("//*[@id=\"ember1042\"]/div/div[1]/span")))));
        mySelection.selectByValue("3");
        test.log(Status.INFO, "pick price");
    }
    public void pickRegion(){
        Select mySelection = new Select(driver.findElement(getElement(By.xpath("//*[@id=\"ember1077\"]/div/div[1]/span"))));
        mySelection.selectByValue("14");
        test.log(Status.INFO, "pick region");

    }
    public void pickCategory(){
        Select mySelection = new Select(driver.findElement(getElement(By.xpath("//*[@id=\"ember1109\"]/div/div[1]/span"))));
        mySelection.selectByValue("204");
        test.log(Status.INFO, "pick Category");
    }
    public void pressFindGift(){
        clickElement(getElement(By.id("ember1188")));
        test.log(Status.INFO, "find gift test ended");
    }

    }


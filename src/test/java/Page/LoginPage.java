package Page;

import Page.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

    private WebDriver driver;

    public LoginPage () {this.driver = DriverSingelton.getDriverInstance() ; }
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("Login Page", "Login BuyMe Website");


    public void login(){
        enterCredentials();
        pressLogin();
        enrollment();
        pressEntrance();
    }
    private void pressEntrance(){
        clickElement(getElement((By.xpath("\n" +
                "    //*[@id=\"ember993\"]/div/ul[1]/li[3]/a/span"))));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test.log(Status.INFO, "press entrance / enrollment button");

    }

    private void enrollment(){
        clickElement(getElement((By.className("text-link theme"))));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test.log(Status.INFO, "press enrollment button");


    }

    private void enterCredentials(){
        sendKeysToElement(By.id("ember1795"),"Oriya");
        sendKeysToElement(By.id("ember1802"), "aabbcc@gmail.com");
        sendKeysToElement(By.id("valPass"), "Aa@123456");
        sendKeysToElement(By.id("ember1816"), "Aa@123456");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test.log(Status.INFO, "login details");


    }
    private void pressLogin() {
        clickElement(By.className("label"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test.log(Status.INFO, "test login ended");

    }


}




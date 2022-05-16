import Page.*;
import Tools.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Main extends BasePage {

    private static WebDriver driver;
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

    @BeforeClass
    public static void beforeClass() throws Exception {
        String type = getdata("browserType");
        if (type.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
            driver = Tools.DriverSingelton.getDriverInstance();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (type.equals("FF")) {
            System.setProperty("webdriver.firefox.driver", "C:\\geckodriver\\geckodriver.exe");
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//extent.html");
            extent.attachReporter(htmlReporter);
            test = extent.createTest("BuyMe Report", "The BuyMe project report");
            test.log(Status.INFO, "before test method");
            // screenshot
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, "picName")).build());
        }
        System.setProperty("webdriver.chrome.whitelistedIps", "");

    }

    @Test
    public void test01_openURL() throws Exception {
            driver.get(getdata("URL"));
            }

         @Test
    public void test02_login () throws Exception {
             try {
                 LoginPage loginPage = new LoginPage();
                 loginPage.login();
                 test.log(Status.INFO, "test login pass successfully");
             }
             catch (Exception e){
                 e.printStackTrace();
                 test.log(Status.INFO, "test login fail");
             }
         }
         @Test
    public void test03_homePageSearch () throws  Exception {
             try {
                 HomePage homePage = new HomePage();
                 homePage .pickGift();
                 test.log(Status.INFO, "test homePage pass successfully");
             }
             catch (Exception e){
                 e.printStackTrace();
                 test.log(Status.INFO, "test homePage fail"+e.getMessage());
             }
         }

         @Test
    public void test04_business () throws  Exception{
             try {
                 BusinessPage businessPage = new BusinessPage();
                 businessPage  .business();
                 test.log(Status.INFO, "test businessPage pass successfully");
             }
             catch (Exception e){
                 e.printStackTrace();
                 test.log(Status.INFO, "test businessPage fail" +e.getMessage());
             }
         }

         @Test
    public void test05_information () throws  Exception {
             try {
                 InformationPage informationPage= new InformationPage();
                 informationPage .detailsInformation();
                 test.log(Status.INFO, "test informationPage pass successfully");
             }
             catch (Exception e){
                 e.printStackTrace();
                 test.log(Status.INFO, "test informationPage fail" +e.getMessage());
             }
         }
    @AfterClass

    public static void afterClass() {
        extent.flush();
        driver.quit();
    }




}
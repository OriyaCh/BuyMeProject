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

public class Main extends BasePage {

    private static WebDriver driver;
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

    @BeforeClass
    public static void beforeClass() throws Exception {
        String type = getdata("browserType");
        if(type.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
            driver = Tools.DriverSingelton.getDriverInstance();
        }else if(type.equals("FF")){
            System.setProperty("webdriver.firefox.driver", "C:\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//extent.html");
            extent.attachReporter(htmlReporter);
            test = extent.createTest("BuyMe Report", "The BuyMe project report");
            test.log(Status.INFO, "before test method");
            // screenshot
           test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, "picName")).build());
        }

    }


         @Test
    public void test01_openURL() throws Exception {
            driver.get(getdata("URL"));
            }

         @Test
    public void test02_login () {
         LoginPage loginPage = new LoginPage();
         loginPage .login();
         }
         @Test
    public void test03_homePageSearch (){
         HomePage homePage = new HomePage();
         homePage .pickGift();
         }
         @Test
    public void test04_business (){
         BusinessPage businessPage = new BusinessPage();
         businessPage  .business();
         }
         @Test
    public void test05_information () {
         InformationPage informationPage= new InformationPage();
         informationPage .detailsInformation();
         }

    @AfterClass

    public static void afterClass() {
        extent.flush();
        driver.quit();
    }


}
import org.openqa.selenium.By;
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

    @BeforeClass
    public static void beforeClass() throws Exception {
        String type = getData("browserType");
        if(type.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
        }else if(type.equals("FF")){
            System.setProperty("webdriver.firefox.driver", "C:\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

         @Test
    public void test01_openURL() throws Exception {
            driver.get(getData("URL"));
            }

         @Test
    public void test02_login (){
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

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }
}
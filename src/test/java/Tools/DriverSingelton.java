package Tools;

import Tools.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingelton {

     static ChromeDriver driver = null;

    public static WebDriver getDriverInstance(){

        if(driver == null){
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
        }

        return driver;
    }
}

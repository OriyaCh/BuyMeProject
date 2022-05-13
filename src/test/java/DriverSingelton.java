import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingelton {

    public static WebDriver getDriverInstance(){
        ChromeDriver driver = new ChromeDriver();
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
        }

        return driver;
    }
}

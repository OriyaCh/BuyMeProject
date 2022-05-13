import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
    private WebDriver driver;

    public HomePage (){this.driver =DriverSingelton.getDriverInstance() ; }


    public void pickGift(){
        pickSum();
        pickRegion();
        pickCategory();
        pressFindGift();
    }
    public void pickSum(){
        Select mySelection = new Select(driver.findElement(By.xpath("//*[@id=\"ember1042\"]/div/div[1]/span")));
        mySelection.selectByValue("3");
    }
    public void pickRegion(){
        Select mySelection = new Select(driver.findElement(By.xpath("//*[@id=\"ember1077\"]/div/div[1]/span")));
        mySelection.selectByValue("14");
    }
    public void pickCategory(){
        Select mySelection = new Select(driver.findElement(By.xpath("//*[@id=\"ember1109\"]/div/div[1]/span")));
        mySelection.selectByValue("204");
    }
    public void pressFindGift(){
        clickElement(By.id("ember1188"));
    }

    }


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BusinessPage extends BasePage{
    private WebDriver driver;

    public BusinessPage (){this.driver =DriverSingelton.getDriverInstance() ; }

    public void business(){
        assertURL();
        pickBusiness();
        choosePrice();
        pressEnter();
    }

    public void pickBusiness (){
        clickElement(By.xpath("//*[@id=\"ember2777\"]/div[4]"));
    }
    public void assertURL(){
        String expect  ="https://buyme.co.il/supplier/2711?budget=3&category=204&query=&region=13";
        String real = String.valueOf(driver.findElement(By.xpath("//*[@id=\"ember2777\"]/div[4]")));
        Assert.assertEquals(expect,real);
    }
    public void choosePrice (){
        sendKeysToElement(By.id("ember2657"),"200");
    }
   public void pressEnter(){
        clickElement(By.id("ember2870"));

   }
}

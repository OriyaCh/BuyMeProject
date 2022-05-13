import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private WebDriver driver;

    public LoginPage (){this.driver =DriverSingelton.getDriverInstance() ; }


    public void login(){
        enterCredentials();
        pressLogin();
        enrollment();
        pressEntrance();
    }
    private void pressEntrance(){
        clickElement(By.xpath("\n" +
                "    //*[@id=\"ember993\"]/div/ul[1]/li[3]/a/span"));
    }

    private void enrollment(){
        clickElement(By.className("text-link theme"));
    }

    private void enterCredentials(){
        sendKeysToElement(By.id("ember1795"), "Oriya");
        sendKeysToElement(By.id("ember1802"), "aabbcc@gmail.com");
        sendKeysToElement(By.id("valPass"), "Aa@123456");
        sendKeysToElement(By.id("ember1816"), "Aa@123456");
    }
    private void pressLogin(){
        clickElement(By.className("label"));
    }

}




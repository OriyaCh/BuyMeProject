package Page;

import Tools.DriverSingelton;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InformationPage extends BasePage {

    private WebDriver driver;
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("Information Page", "Order Details");

    public InformationPage  ()
    {this.driver = DriverSingelton.getDriverInstance() ;
    }

    public void detailsInformation(){
        pressAnother();
        receiverName();
        pickEvent();
        enterBlessing();
        uploadPicture();
        pressContinue();
        pressNow();
        pickEmailSMS();
        enterSenderName();
        enterSenderPhone();
        pressPay();
//        assertSenderAndReciverName();
    }
    public void pressAnother(){
        clickElement(getElement(By.xpath("//*[@id=\"ember2983\"]/span")));
        test.log(Status.INFO, "Choose someone else");
    }
    private void receiverName(){
        sendKeysToElement(By.id("ember2987"), "David");
        test.log(Status.INFO, "Receiver name");
    }
    public void pickEvent(){
        Select mySelection = new Select(driver.findElement(By.xpath("//*[@id=\"ember3048\"]/div/div[1]/span")));
        mySelection.selectByValue("11");
        test.log(Status.INFO, "Choose event");
    }
    private void enterBlessing(){
        sendKeysToElement(By.className("ember-view bm-field bm-textarea blur filled"), "TankYou");
        test.log(Status.INFO, "Type blessing");
    }
    private void uploadPicture(){
        driver.findElement(By.className("media-circle-btn ember-view bm-media-upload"))
                .sendKeys("flowers.jpg");
        test.log(Status.INFO, "Upload picture");
    }
    private void pressContinue(){
        clickElement(By.className("ember-view bm-btn no-reverse main xl stretch"));
        test.log(Status.INFO, "Press continue");
    }
    private void pressNow (){
        clickElement(By.className("ember-view button button-now selected"));
        test.log(Status.INFO, "Choose when to send the gift");
    }
    private void pickEmailSMS(){
        clickElement(By.xpath("//*[@id=\"ember3128\"]/div[1]/div[1]/svg/path[1]"));
        sendKeysToElement(By.id("sms"),"0584753040");
        test.log(Status.INFO, "Choose sms");
    }
    private void enterSenderName(){
        sendKeysToElement(By.id("ember3148"),"Oriya");
        test.log(Status.INFO, "Sender name");
    }

    private void enterSenderPhone(){
        sendKeysToElement(By.className("ember-view ember-text-field parsley-error"),"0551234567");
        test.log(Status.INFO, "Sender phone");
    }
    private void pressPay(){
        clickElement(By.className("ember-view bm-btn no-reverse main xl stretch"));
        test.log(Status.INFO, "press pay");
    }
//    private void assertSenderAndReciverName()
//        {
//            String senderName  = receiverName () ;
//            String reciverName = enterSenderName();
//            Assert.assertEquals(senderName,reciverName);
//    test.log(Status.INFO, "equal name");
//        }


}

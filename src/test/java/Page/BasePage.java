package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class BasePage {
    private static ChromeDriver driver;

    Tools.DriverSingelton DriverSingelton;


    public void clickElement(By locator) {
            getWebElement(locator).click();
        }
        public void sendKeysToElement(By locator, String text) {
            getWebElement(locator).sendKeys(text);
        }
        public By getElement (By locator) {
            return (By) getWebElement(locator);
        }

        protected static String takeScreenShot(WebDriver driver, String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }

        private WebElement getWebElement(By locator) {
            return
            DriverSingelton.getDriverInstance().findElement(locator);
        }

    public static String getdata (String keyName) throws Exception{
        ClassLoader classLoader = BasePage.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    }

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class BasePage {

        public void clickElement(By locator) {
            getWebElement(locator).click();
        }
        public void sendKeysToElement(By locator, String text) {
            getWebElement(locator).sendKeys(text);
        }
        public WebElement getElemet (By locator) {
            return (WebElement) getWebElement(locator);
        }
        private WebElement getWebElement(By locator) {
            return
            DriverSingelton.getDriverInstance().findElement(locator);
        }

    static String getData(String keyName) throws Exception{
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

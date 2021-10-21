package controller;

import elementDefiniton.WebElementDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BrowserPerference;
import util.PropertiesUtil;

import java.util.concurrent.TimeUnit;

public class WebController {
    public static WebDriver driver;
    static {
        System.setProperty("webdriver.chrome.driver", PropertiesUtil.getKey("driverPath"));
        driver = new ChromeDriver(BrowserPerference.options);
    }
    public static WebDriverWait wait = new WebDriverWait(driver,PropertiesUtil.getLongKey("waitSeconds"));
    public static WebElement e ;
    public static JavascriptExecutor executor = (JavascriptExecutor) driver;


    public void waitUntilElementAbleToPerformAction(String xpath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        try {
            wait.wait(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementAbleToPerformAction(By by){
        waitUntilElementPresentToPerformAction(by);
        waitUntilElementVisibletToPerformAction(by);
//        waitUntilElementClickableToPerformAction(by);
    }


    public void waitUntilElementPresentToPerformAction(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilElementVisibletToPerformAction(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementInvisibletToPerformAction(By by){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitUntilElementClickableToPerformAction(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public void switchToIframe(String iframeId){
        driver.switchTo().frame(driver.findElement(WebElementDefinition.getIframe(iframeId)));
    }

    public void switchToIframe(Integer iframeIndex){
        driver.switchTo().frame(iframeIndex);
    }

    public void switchToDefaultContent( ){
        driver.switchTo().defaultContent();
    }

    public void clickByJS(By by){
        executor.executeScript("arguments[0].click()",
                driver.findElement(by));
    }

}

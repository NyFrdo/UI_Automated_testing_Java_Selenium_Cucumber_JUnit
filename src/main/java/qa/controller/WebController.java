package qa.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BrowserPerference;
import util.PropertiesUtil;

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

    public void waitUntilElementAbleToPerformAction(WebElement e){
        waitUntilElementVisibletToPerformAction(e);
        waitUntilElementClickableToPerformAction(e);
    }


    public void waitUntilElementPresentToPerformAction(WebElement e){
//        wait.until(ExpectedConditions.pres(e));
        wait.until(ExpectedConditions.visibilityOf(e));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public void waitUntilElementVisibletToPerformAction(WebElement e){
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitUntilElementInvisibletToPerformAction(WebElement e){
        wait.until(ExpectedConditions.invisibilityOf(e));
    }

    public void waitUntilElementClickableToPerformAction(WebElement e){
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }


    public void switchToIframe(String iframeId){
        driver.switchTo().frame(iframeId);
    }

    public void switchToIframe(Integer iframeIndex){
        driver.switchTo().frame(iframeIndex);
    }

    public void switchToDefaultContent( ){
        driver.switchTo().defaultContent();
    }

    public void clickByJS(WebElement e){
        executor.executeScript("arguments[0].click()",e);
    }

}

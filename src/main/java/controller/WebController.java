package controller;

import org.openqa.selenium.By;
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



    public static void waitUntilElementAbleToPerformAction(String xpath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        try {
            wait.wait(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitUntilElementAbleToPerformAction(By by){
//        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        try {
            wait.wait(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void wait(int i){
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

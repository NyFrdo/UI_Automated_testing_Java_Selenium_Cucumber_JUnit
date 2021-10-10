package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import util.BrowserPerference;
import util.PropertiesUtil;

import java.util.concurrent.TimeUnit;


public class WebOperation extends  WebController{
    public static Actions action = new Actions(driver);
    public static BrowserPerference pref = new BrowserPerference();

    public void login(String site){
        driver.manage().window().maximize();
        driver.get(PropertiesUtil.getKey(site));
        System.out.println();
    }

    public void clickElement(By by){
//        waitUntilElementAbleToPerformAction(by);
        e = driver.findElement(by);
        e.click();
    }

    public void clickElementByAction(By by){
//        waitUntilElementPresentToPerformAction(by);
        e = driver.findElement(by);
//        action.moveToElement(e).click().perform();
        action.click(e).perform();
    }

    public void input(By by,String value){
        clearData(by);
        e.sendKeys(value);
//        e.sendKeys(Keys.TAB);
    }

    public void clearData(By by){
        waitUntilElementAbleToPerformAction(by);
        e = driver.findElement(by);
        e.click();
        e.sendKeys(Keys.CONTROL,"A");
        e.sendKeys(Keys.BACK_SPACE);
    }

    public void closeAlert(){
        driver.switchTo().alert().accept();
    }

    public static void wait(int i){
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

}

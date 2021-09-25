package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import util.BrowserPerference;
import util.PropertiesUtil;


public class WebOperation extends  WebController{
    public static Actions action = new Actions(driver);
    public static BrowserPerference pref = new BrowserPerference();

    public void login(){
        driver.manage().window().maximize();
        driver.get(PropertiesUtil.getKey("testSite"));
        System.out.println();
    }

    public void clickElement(By by){
        waitUntilElementAbleToPerformAction(by);
        e = driver.findElement(by);
        e.click();
    }

    public void input(By by,String value){
        clearData(by);
        e.sendKeys(value);
//        e.sendKeys(Keys.TAB);
    }

    public void clearData(By by){
        e = driver.findElement(by);
        e.click();
        e.sendKeys(Keys.CONTROL,"A");
        e.sendKeys(Keys.BACK_SPACE);
    }

    public void closeAlert(){
        driver.switchTo().alert().accept();
    }

}

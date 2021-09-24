package controller;

import org.openqa.selenium.By;
import util.PropertiesUtil;


public class WebOperation extends  WebController{

    public void login(){
        driver.get(PropertiesUtil.getKey("testSite"));
    }

    public void clickElement(By by){
        waitUntilElementAbleToPerformAction(by);
        e = driver.findElement(by);
        e.click();
    }

}

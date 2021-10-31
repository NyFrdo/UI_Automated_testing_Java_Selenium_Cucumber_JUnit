package qa.controller;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BrowserPerference;
import util.PropertiesUtil;

import java.util.ArrayList;
import java.util.List;

public class WebController {
    public static WebDriver driver;
    static {
        System.setProperty("webdriver.chrome.driver", PropertiesUtil.getKey("driverPath"));
        driver = new ChromeDriver(BrowserPerference.options);
    }
    public static WebDriverWait wait = new WebDriverWait(driver,PropertiesUtil.getLongKey("waitSeconds"),PropertiesUtil.getLongKey("freqSeconds"));
    public static WebElement e ;
    public static JavascriptExecutor executor = (JavascriptExecutor) driver;


    public WebElement getElement(String element,String... replacedString){
        return waitUntilElementAbleToPerformAction(getDynamicElementXpath(element, replacedString));
    }

    public String getDynamicElementXpath(String element,String... replacedString){
        String[] elementInfoArray = element.split("\\.");
        try{
            int count = 0;
            int fromIndex = 0;
            List<Integer> indexList = new ArrayList<>();
            Class<?> pageClass = Class.forName(PropertiesUtil.getKey("elementPackagePath")+"."+elementInfoArray[0]);
            Object object = pageClass.getConstructors()[0].newInstance();
            element = pageClass.getField(elementInfoArray[1]).get(object).toString();
            while(element.indexOf('?',fromIndex) != -1){
                count++;
                indexList.add(element.indexOf('?',fromIndex));
                fromIndex = element.indexOf('?',fromIndex)+1;
            }
            if(replacedString.length != indexList.size()){
                throw new Exception(PropertiesUtil.getKey("mappingMessage"));
            }
            for (String string : replacedString) {
                element = element.replaceFirst("\\?",string);
            }
//        }catch (/*IllegalAccessException | InstantiationException |*/ ClassNotFoundException | NoSuchFieldException  e){
        }catch (Exception e){
            if (e.getMessage().contains(PropertiesUtil.getKey("mappingMessage"))){
                Assert.fail(PropertiesUtil.getKey("mappingMessage"));
            }
            e.printStackTrace();
        }

        return element;
    }

    public WebElement waitUntilElementAbleToPerformAction(String xpath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//        waitFor(1);
        return driver.findElement(By.xpath(xpath));
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

    public void waitFor(int n){
        try {
            wait.wait(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

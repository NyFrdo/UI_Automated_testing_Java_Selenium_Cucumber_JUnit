package util;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import qa.controller.WebController;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hook extends WebController {

//    @After
//    public void beforeScenario(){
//        System.out.println("start");
//    }

    @After
    public void after(Scenario scenario) throws Exception{
        if (scenario.isFailed()){
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmm"));
            String screenshotName = "["+scenario.getId().split(";")[0]+"]"+"-"+scenario.getId().split(";")[1]+"-"+currentDateTime +".jpg";
            File destFile = new File(System.getProperty("user.dir") + "/ScreenCapture/" + screenshotName);
//                FileUtil.copyFile(srcFile, destFile);
            FileUtils.copyFile(srcFile, destFile);
        }
        driver.quit();
    }


}

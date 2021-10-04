package stepDefinition;

import controller.WebController;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hook extends WebController {

//    @After
//    public void beforeScenario(){
//        System.out.println("start");
//    }

//    @After
    public void afterScenario(Scenario scenario){
        if (scenario.isFailed()){
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmm"));
                String screenshotName = "["+scenario.getId().split(";")[0]+"]"+"-"+scenario.getId().split(";")[1]+"-"+currentDateTime +".jpg";
                File destFile = new File(System.getProperty("user.dir") + "/ScreenCapture/" + screenshotName);
//                FileUtils.copyFile(srcFile, destFile);
            } catch (Exception e) {
//            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        driver.
    }


}

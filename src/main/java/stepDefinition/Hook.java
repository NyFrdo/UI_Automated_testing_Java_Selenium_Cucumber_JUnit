package stepDefinition;

import controller.WebController;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;

public class Hook extends WebController {

    @Before
    public void beforeScenario(){
        System.out.println("start");
    }

    @After
    public void afterScenario(){
//        driver.
    }


}

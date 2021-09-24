package stepDefinition;

import cucumber.api.java.en.Given;
import controller.WebOperation;

public class StepDefinition {
    public static WebOperation operation = new WebOperation();

    @Given("^Login and check$")
    public void login() throws Throwable{
        operation.login();
//        System.out.println("aaa");
    }
}

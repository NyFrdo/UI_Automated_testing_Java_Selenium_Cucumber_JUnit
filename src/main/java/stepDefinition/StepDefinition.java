package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import controller.WebOperation;
import elementDefiniton.WebElementDefinition;

public class StepDefinition {
    public static WebOperation operationStep = new WebOperation();

    @Given("^Login$")
    public void login() throws Throwable{
        operationStep.login();
//        operationStep.wait(5);
        operationStep.clickElement(WebElementDefinition.loginButton);
        operationStep.clickElement(WebElementDefinition.loginByAcccountAndPwdTab);
        operationStep.clickElement(WebElementDefinition.userAccountInput);

//        System.out.println("aaa");
    }

    @And("^upload avator$")
    public void Click() throws Throwable{
        operationStep.login();
//        System.out.println("aaa");
    }
//    loginButton
}

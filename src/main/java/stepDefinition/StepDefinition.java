package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import controller.WebOperation;
import elementDefiniton.WebElementDefinition;
import util.ExcelUtil;

public class StepDefinition {
    public static WebOperation operationStep = new WebOperation();

    @Given("^Login$")
    public void login() throws Throwable{
        operationStep.login();
//        operationStep.wait(5);
        operationStep.switchToIframe("login");
        operationStep.input(WebElementDefinition.userAccountInput, ExcelUtil.getCell("account"));
        operationStep.input(WebElementDefinition.userAccountPassword,ExcelUtil.getCell("password"));
        operationStep.clickElement(WebElementDefinition.loginButton);

        operationStep.clickElement(WebElementDefinition.avaButton);
        operationStep.switchToDefaultContent();
        operationStep.switchToIframe("avatar");
//        operationStep.clickElementByAction(WebElementDefinition.uploadButton);
//        operationStep.waitUntilElementAbleToPerformAction(WebElementDefinition.uploadButton);
//        operationStep.clickByJS(WebElementDefinition.uploadButton);
        operationStep.clickElementByAction(WebElementDefinition.uploadButton);
//        System.out.println("aaa");
    }

    @And("^upload avator$")
    public void Click() throws Throwable{
        operationStep.login();
//        System.out.println("aaa");
    }
//    loginButton
}

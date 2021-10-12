package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import controller.WebOperation;
import elementDefiniton.WebElementDefinition;
import util.ExcelUtil;

import java.io.File;

public class StepDefinition {
    public static WebOperation operationStep = new WebOperation();

    @Given("^Login$")
    public void login() throws Throwable{
        operationStep.login("testSite");
//        operationStep.wait(5);
        operationStep.switchToIframe("login");
        operationStep.input(WebElementDefinition.userAccountInput, ExcelUtil.getCell("account"));
        operationStep.input(WebElementDefinition.userAccountPassword,ExcelUtil.getCell("password"));
        operationStep.clickElement(WebElementDefinition.loginButton);

        operationStep.clickElement(WebElementDefinition.avaButton);
        operationStep.switchToDefaultContent();
        operationStep.switchToIframe("avatar");
        //crossarea issue
//        operationStep.clickElementByAction(WebElementDefinition.uploadButton);
//        operationStep.waitUntilElementAbleToPerformAction(WebElementDefinition.uploadButton);
//        operationStep.clickByJS(WebElementDefinition.uploadButton);
        operationStep.clickElementByAction(WebElementDefinition.uploadButton);
//        System.out.println("aaa");
    }

    @Given("^Login microsoft$")
    public void loginMicrosoft() throws Throwable{
        operationStep.login("testSite");
        operationStep.clickElement(WebElementDefinition.loginEntrance);
        operationStep.input(WebElementDefinition.userAccountInput, ExcelUtil.getCell("Micorsoftaccount"));
        operationStep.clickElement(WebElementDefinition.submitButton);
        operationStep.input(WebElementDefinition.userAccountPassword, ExcelUtil.getCell("Micorsofpassword"));
        operationStep.clickElement(WebElementDefinition.submitButton);

        }

    @Given("^Login baidu")
    public void loginBaidu() throws Throwable{
        operationStep.login("testSite");

        operationStep.clickElement(WebElementDefinition.loginEntrance);
        operationStep.input(WebElementDefinition.userAccountInput, ExcelUtil.getCell("Micorsoftaccount"));
        operationStep.input(WebElementDefinition.userAccountPassword, ExcelUtil.getCell("Micorsofpassword"));
        operationStep.clickElement(WebElementDefinition.submitButton);
        operationStep.waitUntilElementInvisibletToPerformAction(WebElementDefinition.submitButton);
        operationStep.wait(1);
        operationStep.login("avaSite");
        operationStep.clickElementByAction(WebElementDefinition.uploadbutton);
        operationStep.wait(1);
        operationStep.upload(new File(ExcelUtil.getCell("imagepath")).getAbsolutePath());

        operationStep.wait(3);

    }
//    https://passport.baidu.com/v3/ucenter/accountportrait
    @And("^upload avator$")
    public void Click() throws Throwable{

//        System.out.println("aaa");
    }
//    loginButton
}

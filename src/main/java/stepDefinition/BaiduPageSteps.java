package stepDefinition;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import controller.WebOperation;
import elementDefiniton.BaiduHomePage;
import stepRealization.BaiduPageStepsRealization;
import util.ExcelUtil;

import java.io.File;

public class BaiduPageSteps {
    public static BaiduPageStepsRealization baiduPageSteps = new BaiduPageStepsRealization();


    @Given("^Login baidu")
    public void loginBaidu() {
        baiduPageSteps.loginBaidu();
    }

    @And("^upload Avatar$")
    public void uploadAvatar() {
        baiduPageSteps.uploadAvatar();
    }
}

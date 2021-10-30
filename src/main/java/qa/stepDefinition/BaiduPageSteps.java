package qa.stepDefinition;


import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import qa.stepRealization.BaiduPageStepsRealization;

import java.util.List;
import java.util.Map;

public class BaiduPageSteps {
    public static BaiduPageStepsRealization baiduPageSteps = new BaiduPageStepsRealization();


    @Given("^Login baidu")
    public void loginBaidu(DataTable dataTable) {
        List<Map<String,String>> dataList = dataTable.asMaps(String.class,String.class);
        baiduPageSteps.loginBaidu(dataList.get(0));
    }

    @And("^upload Avatar$")
    public void uploadAvatar() {
        baiduPageSteps.uploadAvatar();
    }
}

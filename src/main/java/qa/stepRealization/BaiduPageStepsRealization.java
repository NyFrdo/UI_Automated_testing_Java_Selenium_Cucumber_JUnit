package qa.stepRealization;


import qa.controller.WebController;
import qa.controller.WebOperation;
import qa.elementDefinition.BaiduHomePage;
import qa.elementDefinition.BaiduSelfProfilePage;
import util.ExcelUtil;

import java.io.File;
import java.util.Map;

public class BaiduPageStepsRealization extends WebController {
    public static WebOperation operationStep = new WebOperation();
    public static BaiduHomePage baiduHome = new BaiduHomePage(driver);
    public static BaiduSelfProfilePage baiduProfile = new BaiduSelfProfilePage(driver);

    public void loginBaidu(Map<String,String> map) {
        System.out.println("test datatable content" + map.get("testedKey"));
        operationStep.login("testSite");
        operationStep.clickElement(baiduHome.loginEntrance);
//        operationStep.wait(1);
        operationStep.clickElement(getElement("BaiduHomePage.cancelButton","a","TANGRAM__PSP_4__closeBtn"));
        operationStep.clickElement(baiduHome.loginEntrance);
        operationStep.input(baiduHome.userAccountInput, ExcelUtil.getCell("microsoftAccount"));
        operationStep.input(baiduHome.userAccountPassword, ExcelUtil.getCell("microsoftPassword"));
        operationStep.clickElement(baiduHome.submitButton);
        operationStep.waitUntilElementInvisibletToPerformAction(baiduHome.submitButton);
        operationStep.wait(2);
    }

    public void uploadAvatar() {
        operationStep.login("avaSite");
        operationStep.waitUntilElementVisibletToPerformAction(baiduProfile.uploadButton);
        operationStep.clickElementByAction(baiduProfile.uploadButton);
        operationStep.wait(1);
        operationStep.upload(new File(ExcelUtil.getCell("imagePath")).getAbsolutePath());
    }
}

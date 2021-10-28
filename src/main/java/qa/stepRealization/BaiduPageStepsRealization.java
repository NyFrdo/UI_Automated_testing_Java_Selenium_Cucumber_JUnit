package qa.stepRealization;


import qa.controller.WebController;
import qa.controller.WebOperation;
import qa.elementDefiniton.BaiduHomePage;
import qa.elementDefiniton.BaiduSelfProfilePage;
import util.ExcelUtil;

import java.io.File;

public class BaiduPageStepsRealization extends WebController {
    public static WebOperation operationStep = new WebOperation();
    public static BaiduHomePage baiduHome = new BaiduHomePage(driver);
    public static BaiduSelfProfilePage baiduProfile = new BaiduSelfProfilePage(driver);

    public void loginBaidu() {
        operationStep.login("testSite");
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

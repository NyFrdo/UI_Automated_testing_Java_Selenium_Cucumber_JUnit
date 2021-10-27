package stepRealization;


import controller.WebController;
import controller.WebOperation;
import elementDefiniton.BaiduHomePage;
import elementDefiniton.BaiduSelfProfilePage;
import org.openqa.selenium.support.PageFactory;
import util.ExcelUtil;

import java.io.File;

public class BaiduPageStepsRealization extends WebController {
    public static WebOperation operationStep = new WebOperation();
    public static BaiduHomePage baiduHome = PageFactory.initElements(driver,BaiduHomePage.class);
    public static BaiduSelfProfilePage baiduProfile = PageFactory.initElements(driver,BaiduSelfProfilePage.class);

    public void loginBaidu() {
        operationStep.login("testSite");
        operationStep.clickElement(baiduHome.loginEntrance);
        operationStep.input(baiduHome.userAccountInput, ExcelUtil.getCell("microsoftAccount"));
        operationStep.input(baiduHome.userAccountPassword, ExcelUtil.getCell("microsoftPassword"));
        operationStep.clickElement(baiduHome.submitButton);
        operationStep.waitUntilElementInvisibletToPerformAction(baiduHome.submitButton);
    }

    public void uploadAvatar() {
        operationStep.clickElementByAction(baiduProfile.uploadButton);
        operationStep.wait(1);
        operationStep.upload(new File(ExcelUtil.getCell("imagePath")).getAbsolutePath());
    }
}

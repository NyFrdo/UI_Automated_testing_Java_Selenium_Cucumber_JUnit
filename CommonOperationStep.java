package hk.org.ha.qa.step.dh.cims.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

import hk.org.ha.dh.cims.common.util.CommonOperation;
import hk.org.ha.qa.step.BaseSeleniumStep;

public class CommonOperationStep extends BaseSeleniumStep {

    private static String propFile = System.getProperty("user.dir") + "/src/test/resources/properties/pmi/store.properties";
    public static String  testvar = "test";
    @Autowired
    private CommonController controller;

    public static void test(){
        System.out.println(testvar);System.out.println(testvar);
        testvar = "abctest";testvar = "vvv";testvar = "test";testvar = "Rez";
		System.out.println(testvar);System.out.println(testvar);
    }

    public void inputValueToSearchCriteria(String value, String columnName) {
        List<WebElement> elements = controller.getElementsByXpath("//span[text()='" + columnName + "']");        
        WebElement element = null;
        String columnId = null;
        if(elements.size()>0) {
            for (WebElement e : elements) {
                if (e.isDisplayed()) {
                    element=e;
                }
            }
        } else {
            element=elements.get(0);
        }
        controller.clickByJS(element);
        controller.moveToElement(element);
        controller.clickElementByXpath("//*[contains(@class,'ag-column-hover')]//span[@ref='eMenu']//span");

        Select optionGroup = new Select(controller.getElementByXpath("//*[@ref='eOptions1']"));
        optionGroup.selectByVisibleText("Equals");

        controller.inputValueWithXpath(value, "//*[@ref='eValue1']");
        controller.sendTab();
        element.click();
        columnId = element.getAttribute("aria-colindex");

        int i = 0;
        while (i++ < 10) {
            String columnText = controller.getElementTextByXpath("//div[@ref='eCenterContainer']/div[@row-index='0']//span[@aria-colindex='" + columnId + "']");
            if (value.equals(columnText)) {
                break;
            } else {
                controller.waitFor(1);
            }
        }
    }

    public void selectOptionInSearchCriteria(String optionText, String columnName) {
        WebElement element = controller.getElementByXpath("//span[text()='" + columnName + "']");
        controller.moveToElement(element);
        controller.clickElementByXpath("//*[contains(@class,'ag-column-hover')]//span[@ref='eMenu']//span");
        Select optionGroup = new Select(controller.getElementByXpath("//*[@ref='eOptions1']"));
        optionGroup.selectByVisibleText(optionText);
        controller.sendTab();
        element.click();
    }


    public void selectOptionInDropdown(String optionText, String fieldKey) {
        if (optionText.length() > 0) {
            WebElement element = controller.getElement(fieldKey);
            controller.webDriverWaitVisibility(element);
            element.findElement(By.xpath(".//input")).sendKeys(optionText);
            By option = By.xpath("//div[contains(@id,'menu_container')]//div[text()='" + optionText + "']");
            controller.webDriverWaitPresenceOfElementLocated(option).click();
        }
    }

    public void putData(String columnName, String value) {
        CommonOperation.updateProp(propFile, columnName, value);
    }

    public String getData(String columnName) {
        return CommonOperation.getValueFromProp(propFile, columnName);
    }

    public int verifyElementNotCheck(String element) throws InterruptedException {
        int i = 0;
        Thread.sleep(5000);
        try {
            webElementAccessor.getElement(element).findElement(By.xpath("./*[contains(@class,'Mui-checked')]")).isEnabled();
            i++;
        } catch (Exception ignored) {
        }
        return i;
    }

    public int verifyElementNotCheckWithInputXpath(String element) throws InterruptedException {
        int i = 0;
        Thread.sleep(5000);
        try {
            webElementAccessor.getElement(element).findElement(By.xpath("./parent::*/parent::*[contains(@class,'Mui-checked')]")).isEnabled();
            i++;
        } catch (Exception ignored) {
        }
        return i;
    }

    public void saveProperties(String fileName, HashMap<String, String> mapValue) {
        String resourceFolder = System.getProperty("user.dir") + "/src/test/resources/properties/";
        if (fileName.startsWith("/")) {
            fileName = fileName.substring(1);
        }
        String propFile = resourceFolder + fileName;
        Set<String> set = mapValue.keySet();
        for (String entry : set) {
            CommonOperation.updateProp(propFile, entry, mapValue.get(entry));
        }
    }

    public HashMap<String, String> getProperties(String fileName) {
        String resourceFolder = System.getProperty("user.dir") + "/src/test/resources/properties/";
        if (fileName.startsWith("/")) {
            fileName = fileName.substring(1);
        }
        String propFile = resourceFolder + fileName;

        Properties prop = new Properties();
        HashMap<String, String> mapValue = new HashMap<String, String>();
        try {
            prop.load(new FileInputStream(propFile));
            for (String name : prop.stringPropertyNames()) {
                mapValue.put(name, prop.getProperty(name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapValue;
    }

    public void waitLoadingBarDisappear() {
        controller.waitUntilInvisibilityByXpath("//div[@id='loadingBar' and @style='display: flex;']");
    }

    public void verifyElementIsDisplayed(String fieldKey) {
        WebElement element = controller.getElement(fieldKey);
        try {
            controller.webDriverWaitVisibility(element);
        } catch (TimeoutException e) {
            System.out.println(fieldKey + "is not visibility");
        }

        if (!controller.isElementDisplayed(element)) {
            throw new RuntimeException(fieldKey + " should be displayed.");
        }
    }

	public String getSnackbarMessage() {
		String actualText = "";
		int retryTime = 0;
		while (retryTime < 20 && actualText.length() == 0) {
			retryTime++;
			controller.waitForMilliSeconds(50);
			actualText = controller.getMessageText("cims.message.txtSnackBar");
		}
		System.out.println("snackbar:" + actualText);
		return actualText;
	}
    
    public void verifySnackbarMessage(String messageID) {
        verifySnackbarMessage(messageID, "");
    }

    public void verifySnackbarMessage(String messageID, String parameter) {
        String actualText = getSnackbarMessage();
        String expectedText = "";
        if (parameter.length() == 0) {
            expectedText = getExpectMessageWithMsgID(messageID);
        } else {
            expectedText = getExpectMessageWithMsgID(messageID, parameter);
        }
        controller.assertEquals(expectedText, actualText);
    }

    public void verifyMessageByID(String messageID) {
        String expectMessageHeader = getExpectMessageHeader(messageID);
        String expectMessageContent = getExpectMessage(messageID);
        verifyMessageInPromptDialog(expectMessageHeader, expectMessageContent);
    }

    public void verifyMessageBehindField(String expectedText, String fieldKey) {
        WebElement element = controller.webDriverWaitVisibility(controller.getElement(fieldKey));
        String actualText = element.findElement(By.xpath("./.")).getText();
        controller.assertEquals(expectedText, actualText);
    }

    public void verifyMessageInPromptDialog(String expectMessageHeader, String expectMessageContent) {
        String messageHeaderField = "cims.message.txtMsgHeader";
        String messageContentField = "cims.message.txtMsgDescription";
        controller.webDriverWaitTextToBePresentInElement(controller.getElement(messageHeaderField), expectMessageHeader);
        String actualMessageHeader = controller.getElementText(messageHeaderField);
        String actualMessageContent = controller.getElementText(messageContentField);
        controller.assertContains(expectMessageHeader, actualMessageHeader);
        controller.assertContains(expectMessageContent.trim(), actualMessageContent.trim());
    }

    public void verifyMessageInPromptDialog(String expectMessageHeader, String expectMessageContentOne, String expectMessageContentTwo) {
        String messageHeaderField = "cims.message.txtMsgHeader";
        String messageContentField = "cims.message.txtMsgDescription";
        String actualMessageHeader = controller.getElementText(messageHeaderField);
        String actualMessageContent = controller.getElementText(messageContentField);
        controller.assertContains(expectMessageHeader, actualMessageHeader);
        controller.assertContains(expectMessageContentOne, actualMessageContent);
        actualMessageContent = actualMessageContent.replaceAll("\n| ", "");
        controller.assertContains(expectMessageContentTwo.replaceAll(" ", ""), actualMessageContent);
    }

    public String getExpectMessageHeader(String messageID) {
        return CommonOperation.getSystemMessageValue(messageID).get(0) + " (MSG:" + messageID + ")";
    }

    public String getExpectMessage(String messageID) {
        return CommonOperation.getSystemMessageValue(messageID).get(1).replace("</br>", "\n");
    }

    public String getExpectMessageWithMsgID(String messageID) {
        return "(MSG:" + messageID + ") " + getExpectMessage(messageID);
    }

    public String getExpectMessageWithMsgID(String messageID, String parameter) {
        String expectedText = getExpectMessageWithMsgID(messageID);
        expectedText = expectedText.replaceAll("%.+?%", parameter);
        return expectedText;
    }

}

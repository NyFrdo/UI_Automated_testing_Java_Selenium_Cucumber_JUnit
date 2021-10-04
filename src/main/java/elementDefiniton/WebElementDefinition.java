package elementDefiniton;

import org.openqa.selenium.By;

public class WebElementDefinition {
    public static By avaButton =  By.xpath("//*[contains(@class,'gWel-avatar')]//a[contains(@class,'nui-faceEdit ')]//img");
//    public static By uploadButton =  By.className("m-input-file");
    public static By uploadButton =  By.xpath("//div[@id='dvAvatarFalsh']//input");
    public static By loginButton =  By.id("dologin");
    public static By userAccountInput =  By.xpath("//div[@class='u-input box']//input[@name='email']");
    public static By userAccountPassword =  By.xpath("//div[@class='u-input box']//input[@name='password']");
    public static By iframeOne =  By.xpath("//*[@id='loginDiv']/iframe");
    public static By iframeTwo =  By.xpath("//*[@id='dvAvatarFalsh']/iframe");

    public static By getIframe(String iframeID){
        switch (iframeID){
            case "login": return iframeOne;
            case "avatar":
                return iframeTwo;
        }
        return null;
    }
}

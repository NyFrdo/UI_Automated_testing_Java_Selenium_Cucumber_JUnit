package elementDefiniton;

import org.openqa.selenium.By;

public class WebElementDefinition {
    //163
    public static By avaButton =  By.xpath("//*[contains(@class,'gWel-avatar')]//a[contains(@class,'nui-faceEdit ')]//img");
    public static By uploadButton =  By.className("m-input-file");
//    public static By uploadButton =  By.xpath("//input");
    public static By loginButton =  By.id("dologin");
//    public static By userAccountInput =  By.xpath("//div[@class='u-input box']//input[@name='email']");
//    public static By userAccountPassword =  By.xpath("//div[@class='u-input box']//input[@name='password']");
    public static By iframeOne =  By.xpath("//*[@id='loginDiv']/iframe");
    public static By iframeTwo =  By.xpath("//*[@id='dvAvatarFalsh']/iframe");

    //microsoft
//    public static By userAccountInput =  By.xpath("//input[@type='email']");
//    public static By userAccountPassword =  By.xpath("//input[@type='password']");
//    public static By submitButton =  By.xpath("//input[@type='submit']");
//    public static By loginEntrance =  By.id("meControl");

    //baidu
    public static By userAccountInput =  By.id("TANGRAM__PSP_11__userName");
    public static By userAccountPassword =  By.id("TANGRAM__PSP_11__password");
    public static By submitButton =  By.id("TANGRAM__PSP_11__submit");
    public static By loginEntrance =  By.id("s-top-loginbtn");
    public static By uploadbutton =  By.xpath("//input[@name='openImgBtn']//following-sibling::input");

    public static By getIframe(String iframeID){
        switch (iframeID){
            case "login": return iframeOne;
            case "avatar":
                return iframeTwo;
        }
        return null;
    }
}

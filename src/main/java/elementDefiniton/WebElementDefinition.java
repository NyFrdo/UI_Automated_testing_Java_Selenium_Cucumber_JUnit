package elementDefiniton;

import org.openqa.selenium.By;

public class WebElementDefinition {
    public static By avaButton =  By.xpath("//*[contains(@class,'gWel-avatar')]//a[contains(@class,'nui-faceEdit ')]//img");
    public static By uploadButton =  By.className("m-input-file");
    public static By loginButton =  By.id("dologin");
    public static By userAccountInput =  By.xpath("//div[@class='u-input box']//input[@name='email']");
    public static By userAccountPassword =  By.xpath("//div[@class='u-input box']//input[@name='password']");

//    public static By avaButton =  By.xpath("");
//    public static By avaButton =  By.xpath("");
//    public static By avaButton =  By.xpath("");
}

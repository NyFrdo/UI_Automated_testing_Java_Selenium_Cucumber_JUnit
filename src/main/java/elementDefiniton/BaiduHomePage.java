package elementDefiniton;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaiduHomePage {
    @FindBy(id = "TANGRAM__PSP_11__userName")
    public WebElement userAccountInput;

    @FindBy(id = "s-top-loginbtn")
    public  WebElement userAccountPassword;

    @FindBy(id = "TANGRAM__PSP_11__submit")
    public  WebElement submitButton;

    @FindBy(id = "s-top-loginbtn")
    public WebElement loginEntrance;


 }

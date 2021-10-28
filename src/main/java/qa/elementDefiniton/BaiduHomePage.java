package qa.elementDefiniton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaiduHomePage {
    @FindBy(id = "TANGRAM__PSP_11__userName")
    public WebElement userAccountInput;

    @FindBy(id = "TANGRAM__PSP_11__password")
    public  WebElement userAccountPassword;

    @FindBy(id = "TANGRAM__PSP_11__submit")
    public  WebElement submitButton;

    @FindBy(id = "s-top-loginbtn")
    public WebElement loginEntrance;

    public BaiduHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

 }

package qa.elementDefiniton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaiduSelfProfilePage {

    @FindBy(xpath = "//input[@name='openImgBtn']//following-sibling::input")
    public  WebElement uploadButton;

    public BaiduSelfProfilePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
 }

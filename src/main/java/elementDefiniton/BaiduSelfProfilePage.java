package elementDefiniton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaiduSelfProfilePage {

    @FindBy(xpath = "//input[@name='openImgBtn']//following-sibling::input")
    public  WebElement uploadButton;

 }

import cucumber.api.java.en.Given;

public class WebStepDefinition extends WebController{
    public static WebElementDefinition we = new WebElementDefinition();
    @Given("Login and check")
    public void loginJustTest(){
        login();
        clickElement(we.avaButton);
        clickElement(we.profilePerson);
    }




}

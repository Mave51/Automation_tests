package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(linkText = "Register")
    private WebElement registerAccountButton;

    @FindBy(name = "username")
    private WebElement loginUserNameInput;

    @FindBy(name = "password")
    private WebElement loginPasswordInput;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    private WebElement submitLoginButton;


     public RegisterAccountPage goToRegisterAccountPage(){
        LOGGER.info("Go to the register account page from main page");
        registerAccountButton.click();
        return new RegisterAccountPage();
    }

    public MainPage typeIntoLoginUserNameInput(String userName){
         LOGGER.info("On Main Page type user name into loginUserNameInput");
         loginUserNameInput.sendKeys(userName);
         return this;
    }

    public MainPage typeIntoLoginPasswordInput(String password){
         LOGGER.info("On Main Page type password into loginPasswordInput");
         loginPasswordInput.sendKeys(password);
         return this;
    }

    public AccountServicesPage submitLogin(){
         LOGGER.info("Sumbit login on Main Page by click log in button ");
         submitLoginButton.click();
         return new AccountServicesPage();
    }

}

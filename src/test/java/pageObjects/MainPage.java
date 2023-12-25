package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.DTO.LoginDataDTO;

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
        click(registerAccountButton);
        return new RegisterAccountPage();
    }

    public MainPage typeIntoLoginUserNameInput(String userName){
         LOGGER.info("On Main Page type user name into loginUserNameInput");
         sendKeys(loginUserNameInput, userName);
         return this;
    }

    public MainPage typeIntoLoginPasswordInput(String password){
         LOGGER.info("On Main Page type password into loginPasswordInput");
         sendKeys(loginPasswordInput, password);
         return this;
    }

    public AccountServicesPage submitLogin(){
         LOGGER.info("Sumbit login on Main Page by click log in button ");
         click(submitLoginButton);
         return new AccountServicesPage();
    }

    public AccountServicesPage loginUser(LoginDataDTO loginDataDTO) {
         typeIntoLoginUserNameInput(loginDataDTO.getUserName());
         typeIntoLoginPasswordInput(loginDataDTO.getPassword());
         submitLogin();
         return new AccountServicesPage();
    }

}

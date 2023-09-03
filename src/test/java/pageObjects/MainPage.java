package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static common.DriverManager.getWebDriver;

public class MainPage extends BasePage {

    @FindBy(linkText = "Register")
    private WebElement registerAccountButton;

    @FindBy(name = "username")
    private WebElement loginUserNameInput;

    @FindBy(name = "password")
    private WebElement loginPasswordInput;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    private WebElement submitLoginButton;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static MainPage using(WebDriver driver, WebDriverWait wait) {
        return new MainPage(driver, wait);
    }


     public RegisterAccountPage goToRegisterAccountPage(){
        LOGGER.info("Go to the register account page from main page");
        registerAccountButton.click();
        return new RegisterAccountPage(getWebDriver(), wait);
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
         return new AccountServicesPage(getWebDriver(), wait);
    }

}

package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountServicesPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    public WebElement succesfullRegisterMessage;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/h2")
    public WebElement accountServicesMenu;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    public WebElement failedLoginAttemptMessage;

    public String getSuccessfulRegisterMessage(){
        LOGGER.info("After correct account registration get confirmation text");
        waitUntilElementIsVisible(succesfullRegisterMessage);
        return succesfullRegisterMessage.getText();
    }

    public String getAccountServicesMenuTitleNameAfterLogin(){
        LOGGER.info("After correct login get account services menu title name");
        waitUntilElementIsVisible(accountServicesMenu);
        return accountServicesMenu.getText();
    }

    public String getErrorMessageAfterFailedLoginAttempt(){
        LOGGER.info("Get error message text after failed login attempt");
        waitUntilElementIsVisible(failedLoginAttemptMessage);
        return failedLoginAttemptMessage.getText();
    }
}

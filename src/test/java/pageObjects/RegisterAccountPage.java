package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterAccountPage extends BasePage {

    @FindBy(id = "customer.firstName")
    private WebElement firstNameInput;

    @FindBy(id= "customer.lastName")
    private WebElement lastNameInput;

    @FindBy(id = "customer.address.street")
    private WebElement addressInput;

    @FindBy(id = "customer.address.city")
    private WebElement cityInput;

    @FindBy(id = "customer.address.state")
    private WebElement stateInput;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCodeInput;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumberInput;

    @FindBy(id = "customer.ssn")
    private WebElement ssnInput;

    @FindBy(id = "customer.username")
    private WebElement userNameInput;

    @FindBy(id = "customer.password")
    private WebElement passwordInput;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
    private WebElement submitAccountRegistrationButton;

    public RegisterAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public RegisterAccountPage typeIntoFirstNameInput(String firstName){
        LOGGER.info("Type user first name into firstNameInput");
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegisterAccountPage typeIntoLastNameInput(String lastName){
        LOGGER.info("Type user last name into firstNameInput");
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegisterAccountPage typeIntoAddressInput (String address){
        LOGGER.info("Type user address into addressInput");
        addressInput.sendKeys(address);
        return this;
    }

    public RegisterAccountPage typeIntoCityInput(String city){
       LOGGER.info("Type user address into addressInput");
       cityInput.sendKeys(city);
       return this;
    }

    public RegisterAccountPage typeIntoStateInput(String state){
        LOGGER.info("Type user state into stateInput");
        stateInput.sendKeys(state);
        return this;
    }

    public RegisterAccountPage typeIntoZipCodeInput(String zipCode){
        LOGGER.info("Type user zip code into zipCodeInput");
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    public RegisterAccountPage typeIntoPhoneNumberInput(String phoneNumber){
        LOGGER.info("Type user phone number into phoneNumberInput");
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    public RegisterAccountPage typeIntoSSNInput(String ssnNumber){
        LOGGER.info("Type user SSN into ssnNumber");
        ssnInput.sendKeys(ssnNumber);
        return this;
    }

    public RegisterAccountPage typeIntoUserNameInput(String userName){
        LOGGER.info("Type user name into userNameInput");
        userNameInput.sendKeys(userName);
        return this;
    }

    public RegisterAccountPage typeIntoPasswordInput(String password){
        LOGGER.info("Type user password into passwordInput");
        passwordInput.sendKeys(password);
        return this;
    }

    public RegisterAccountPage typeIntoConfirmPasswordInput(String password){
        LOGGER.info("Type user password into confirmPasswordInput");
        confirmPasswordInput.sendKeys(password);
        return this;
    }

    public AccountServicesPage submitAccountRegistration(){
        LOGGER.info("Submit account registration by clicking button");
        submitAccountRegistrationButton.click();
        return new AccountServicesPage(driver, wait);
    }
}


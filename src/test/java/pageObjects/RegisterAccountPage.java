package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.DTO.AccountRegistrationDTO;

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

    public RegisterAccountPage typeIntoFirstNameInput(String firstName){
        LOGGER.info("Type user first name into firstNameInput");
        sendKeys(firstNameInput, firstName);
        return this;
    }

    public RegisterAccountPage typeIntoLastNameInput(String lastName){
        LOGGER.info("Type user last name into firstNameInput");
        sendKeys(lastNameInput, lastName);
        return this;
    }

    public RegisterAccountPage typeIntoAddressInput (String address){
        LOGGER.info("Type user address into addressInput");
        sendKeys(addressInput, address);
        return this;
    }

    public RegisterAccountPage typeIntoCityInput(String city){
       LOGGER.info("Type user address into addressInput");
       sendKeys(cityInput, city);
       return this;
    }

    public RegisterAccountPage typeIntoStateInput(String state){
        LOGGER.info("Type user state into stateInput");
        sendKeys(stateInput, state);
        return this;
    }

    public RegisterAccountPage typeIntoZipCodeInput(String zipCode){
        LOGGER.info("Type user zip code into zipCodeInput");
        sendKeys(zipCodeInput, zipCode);
        return this;
    }

    public RegisterAccountPage typeIntoPhoneNumberInput(String phoneNumber){
        LOGGER.info("Type user phone number into phoneNumberInput");
        sendKeys(phoneNumberInput, phoneNumber);
        return this;
    }

    public RegisterAccountPage typeIntoSSNInput(String ssnNumber){
        LOGGER.info("Type user SSN into ssnNumber");
        sendKeys(ssnInput, ssnNumber);
        return this;
    }

    public RegisterAccountPage typeIntoUserNameInput(String userName){
        LOGGER.info("Type user name into userNameInput");
        sendKeys(userNameInput, userName);
        return this;
    }

    public RegisterAccountPage typeIntoPasswordInput(String password){
        LOGGER.info("Type user password into passwordInput");
        sendKeys(passwordInput, password);
        return this;
    }

    public RegisterAccountPage typeIntoConfirmPasswordInput(String password){
        LOGGER.info("Type user password into confirmPasswordInput");
        sendKeys(confirmPasswordInput, password);
        return this;
    }

    public AccountServicesPage submitAccountRegistration(){
        LOGGER.info("Submit account registration by clicking button");
        click(submitAccountRegistrationButton);
        return new AccountServicesPage();
    }

    public AccountServicesPage registerNewAccount(AccountRegistrationDTO accountRegistrationDTO) {
        AccountServicesPage accountServicesPage = new MainPage()
                .goToRegisterAccountPage()
                .typeIntoFirstNameInput(accountRegistrationDTO.getName())
                .typeIntoLastNameInput(accountRegistrationDTO.getSurname())
                .typeIntoAddressInput(accountRegistrationDTO.getStreet())
                .typeIntoCityInput(accountRegistrationDTO.getCity())
                .typeIntoStateInput(accountRegistrationDTO.getState())
                .typeIntoZipCodeInput(accountRegistrationDTO.getZipcode())
                .typeIntoPhoneNumberInput(accountRegistrationDTO.getPhoneNumber())
                .typeIntoSSNInput(accountRegistrationDTO.getSsnNumber())
                .typeIntoUserNameInput(accountRegistrationDTO.getUserName())
                .typeIntoPasswordInput(accountRegistrationDTO.getPassword())
                .typeIntoConfirmPasswordInput(accountRegistrationDTO.getPassword())
                .submitAccountRegistration();
        return new AccountServicesPage();
    }
}



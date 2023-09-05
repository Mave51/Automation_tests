package tests;

import org.junit.jupiter.api.Tag;

import org.junit.jupiter.api.Test;
import pageObjects.AccountServicesPage;
import pageObjects.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountRegistrationTest extends TestBase {
    @Test
    @Tag("RegressionTest")
    public void registerNewAccountTest(){

        String userName = createRandomUserName(5);
        String desiredMessage = "Your account was created successfully. You are now logged in.";

        AccountServicesPage accountServicesPage = new MainPage()
                .goToRegisterAccountPage()
                .typeIntoFirstNameInput("John")
                .typeIntoLastNameInput("Johnson")
                .typeIntoAddressInput("Brooklyn 99")
                .typeIntoCityInput("New York")
                .typeIntoStateInput("New York")
                .typeIntoZipCodeInput("00-000")
                .typeIntoPhoneNumberInput("180080000")
                .typeIntoSSNInput("00000")
                .typeIntoUserNameInput(userName)
                .typeIntoPasswordInput("Pass1")
                .typeIntoConfirmPasswordInput("Pass1")
                .submitAccountRegistration();

        assertEquals(desiredMessage, accountServicesPage.getSuccessfulRegisterMessage());







    }
}

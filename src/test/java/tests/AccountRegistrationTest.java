package tests;

import org.testng.annotations.Test;
import pageObjects.AccountServicesPage;
import pageObjects.MainPage;

import static org.junit.Assert.assertEquals;

public class AccountRegistrationTest extends TestBase {
    @Test
    public void registerNewAccountTest(){

        String userName = createRandomUserName(5);


        MainPage mainPage = new MainPage();

        mainPage
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

        AccountServicesPage accountServicesPage = new AccountServicesPage();

        assertEquals(accountServicesPage.getSuccessfulRegisterMessage(), "Your account was created successfully. You are now logged in.");







    }
}

package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageObjects.AccountServicesPage;
import pageObjects.DTO.AccountRegistrationDTO;
import pageObjects.RegisterAccountPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountRegistrationTest extends BaseTest {
    @Test
    @Tag("RegressionTest")
    void should_register_new_account() {
        String desiredMessage = "Your account was created successfully. You are now logged in.";

        AccountServicesPage accountServicesPage = new RegisterAccountPage()
                .registerNewAccount(AccountRegistrationDTO.getDefaultDTO());
        assertEquals(desiredMessage, accountServicesPage.getSuccessfulRegisterMessage());

    }
}

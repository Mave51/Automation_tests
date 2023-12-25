package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageObjects.AccountServicesPage;
import pageObjects.DTO.LoginDataDTO;
import pageObjects.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTest extends BaseTest {
    @Test
    @Tag("RegressionTest")
    void should_login_the_user() {

        AccountServicesPage accountServicesPage = new MainPage()
                .loginUser(LoginDataDTO.getDefaultLoginDataDTO());
        assertEquals("Customer Login", accountServicesPage.getAccountServicesMenuTitleNameAfterLogin());
    }
}

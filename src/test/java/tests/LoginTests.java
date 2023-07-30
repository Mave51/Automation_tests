package tests;

import org.junit.jupiter.api.Tag;
import org.testng.annotations.Test;
import pageObjects.AccountServicesPage;
import pageObjects.MainPage;

import static org.testng.AssertJUnit.assertEquals;


public class LoginTests extends TestBase {
    @Test
    @Tag("RegressionTest")
    public void TestPositiveLogin() {

        String userName = "John123";
        String password = "John123";

       AccountServicesPage accountServicesPage = MainPage.using(driver, wait)
                .typeIntoLoginUserNameInput(userName)
                .typeIntoLoginPasswordInput(password)
                .submitLogin();

        assertEquals(accountServicesPage.getAccountServicesMenuTitleNameAfterLogin(), "Account Services");

    }
}

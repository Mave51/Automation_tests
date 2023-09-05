package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageObjects.AccountServicesPage;
import pageObjects.MainPage;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTests extends TestBase {
    @Test
    @Tag("RegressionTest")
    public void TestPositiveLogin() {
        String userName = "John123";
        String password = "John123";

        AccountServicesPage accountServicesPage = new MainPage()
                .typeIntoLoginUserNameInput(userName)
                .typeIntoLoginPasswordInput(password)
                .submitLogin();
        assertEquals("Customer Login", accountServicesPage.getAccountServicesMenuTitleNameAfterLogin());
    }
}

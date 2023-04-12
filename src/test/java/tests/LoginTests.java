package tests;

import org.testng.annotations.Test;
import pageObjects.AccountServicesPage;
import pageObjects.MainPage;

import static org.testng.AssertJUnit.assertEquals;


public class LoginTests extends TestBase {



    @Test public void TestPositiveLogin() {

        String userName = "John123";
        String password = "John123";

        MainPage mainPage = new MainPage();
        AccountServicesPage accountServicesPage = new AccountServicesPage();

        mainPage
                .typeIntoLoginUserNameInput(userName)
                .typeIntoLoginPasswordInput(password)
                .submitLogin();

        assertEquals(accountServicesPage.getAccountServicesMenuTitleNameAfterLogin(), "Account Services");

    }
}

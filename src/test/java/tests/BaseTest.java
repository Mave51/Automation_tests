package tests;

import common.DriverManager;
import common.DriverUtils;
import common.makeScreenShotOnFailure;
import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Properties;

import static navigation.ApplicationURLs.APPLICATION_URL;

@ExtendWith(makeScreenShotOnFailure.class)
public class BaseTest {

    @BeforeAll
    public static void beforeAll() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @BeforeEach
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

   @AfterEach
    public void afterTest() {
        DriverManager.disposeDriver();
    }

    public static String createRandomUserName(int n) {


        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
            return sb.toString();


        }
        return "User" + sb;
    }
}



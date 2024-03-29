package tests;

import common.DriverManager;
import common.DriverUtils;
import common.MakeScreenShotOnFailure;
import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Properties;

import static navigation.ApplicationURLs.APPLICATION_URL;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(MakeScreenShotOnFailure.class)
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

}



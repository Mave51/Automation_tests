package common;

import configuration.ConfigurationProperties;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotMaker {

    private static final WebDriver driver = DriverManager.getWebDriver();

    @Attachment(value = "Page screenshot test failure", type = "image/png")
    public static void makeScreenShot() throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        String filePath = ConfigurationProperties.getProperties().getProperty("screenshot.file.path") + timestamp + ".png";
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File(filePath));
    }
}

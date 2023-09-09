package common;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import static common.ScreenShotMaker.makeScreenShot;

public class makeScreenShotOnFailure implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        if (throwable instanceof Exception || throwable instanceof Error) {
            System.out.println("There was an error during test execution, check the screenshot for more context");
            makeScreenShot();
            throw throwable;
        }
    }
}

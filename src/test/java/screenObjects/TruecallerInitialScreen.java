package screenObjects;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import utility.Helper;

import java.time.Duration;

public class TruecallerInitialScreen {
    private final AndroidDriver driver;
    private final String screenTitle = "//android.widget.TextView[@resource-id=\"com.truecaller:id/title\"]";
    private final String stopSpamNowButton = "//android.widget.Button[@resource-id=\"com.truecaller:id/nextButton\"]";
    private final String allowButton = "com.android.permissioncontroller:id/permission_allow_button";

    public TruecallerInitialScreen(AndroidDriver driver){
        this.driver = driver;
    }
    public void verifyScreenTitleIsDisplayed() {
        Assert.assertTrue(new Helper(driver).waitForElementToBeVisibleByXpath(screenTitle).isDisplayed());
    }

    public void clickStopSpamNowButton() {
        driver.findElement(By.xpath(stopSpamNowButton)).click();
    }

    public void handleAlert() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().dismiss();
    }

    public void clickAllowButton() {
        new Helper(driver).waitForElementToBeVisibleById(allowButton).click();
    }
}

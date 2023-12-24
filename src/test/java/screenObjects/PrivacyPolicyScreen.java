package screenObjects;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Helper;

public class PrivacyPolicyScreen extends DefaultDriver{
    AndroidDriver driver;
    private final String privacyScreenTitle = "//android.widget.TextView[@resource-id=\"com.truecaller:id/privacyPolicyTitle\"]";
    private final String agreeAndContinueButton = "//android.widget.Button[@resource-id=\"com.truecaller:id/nextButton\"]";

    public PrivacyPolicyScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void verifyPrivacyPolicyScreenIsDisplayed() {
        WebElement privacyScreen = new Helper(driver).waitForElementToBeVisibleByXpath(privacyScreenTitle);
        Assert.assertTrue(privacyScreen.isDisplayed());
    }

    public void clickAgreeAndContinueButton() {
        driver.findElement(By.xpath(agreeAndContinueButton)).click();
    }
}

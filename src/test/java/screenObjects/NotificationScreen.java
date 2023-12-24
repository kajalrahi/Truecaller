package screenObjects;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Helper;

public class NotificationScreen{
    AndroidDriver driver;
    private final String notificationScreenTitle = "//android.widget.TextView[@resource-id=\"android:id/message\"]";
    private final String okButton = "//android.widget.Button[@resource-id=\"android:id/button1\"]";

    public NotificationScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void verifyNotificationScreenIsDisplayed() {
        WebElement confirmAndContinueButton = new Helper(driver).waitForElementToBeVisibleByXpath(notificationScreenTitle);
        Assert.assertTrue(confirmAndContinueButton.isDisplayed());
    }

    public void clickOkButton() {
        driver.findElement(By.xpath(okButton)).click();
    }
}

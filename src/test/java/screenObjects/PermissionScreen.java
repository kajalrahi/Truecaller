package screenObjects;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Helper;

public class PermissionScreen extends DefaultDriver{
    private final AndroidDriver driver;
    private final String permissionScreenTitle = "//android.widget.TextView[@resource-id=\"com.truecaller:id/permissions_title\"]";
    private final String continueButton = "//android.widget.Button[@resource-id=\"android:id/button1\"]";

    public PermissionScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void verifyPermissionScreenIsShown() {
        WebElement permissionScreen = new Helper(driver).waitForElementToBeVisibleByXpath(permissionScreenTitle);
        Assert.assertTrue(permissionScreen.isDisplayed());
    }

    public void clickContinueButton() {
        driver.findElement(By.xpath(continueButton)).click();
    }


}

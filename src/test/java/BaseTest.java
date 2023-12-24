
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class BaseTest {
    public static void main(String[] args) {
        //AndroidDriver driver;

        // Define desired capabilities for the app
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");  // or "iOS"
        capabilities.setCapability("platformVersion", "12");
        //capabilities.setCapability("deviceName", "Pixel 5 API 31");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("exported", true);


        // For Android
        capabilities.setCapability("appPackage", "com.truecaller");  // Android package name
        capabilities.setCapability("appActivity", "com.truecaller.ui.TruecallerInit");  // Android activity name

        // For iOS
        // capabilities.setCapability("bundleId", "com.example.yourapp");  // iOS bundle identifier

        // Set the Appium server URL
        String appiumServerURL = "http://127.0.0.1:4723/wd/hub";

        // Initialize the Appium driver
        AppiumDriver driver;
        String platformName = capabilities.getCapability("platformName").toString();

        try {
            if (platformName.equals("ANDROID")) {
                driver = new AndroidDriver(new URL(appiumServerURL), capabilities);
            } else {
                driver = new IOSDriver(new URL(appiumServerURL), capabilities);
            }
            Thread.sleep(5000);
            Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.truecaller:id/title\"]")).isDisplayed());
            driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.truecaller:id/nextButton\"]")).click();
            Thread.sleep(3000);
            //driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"com.android.permissioncontroller:id/list\"]/android.widget.LinearLayout[2]/android.widget.RadioButton")).click();
            //driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
            //driver.findElement(By.id("com.truecaller:id/buttonPanel")).click();
            //driver.findElement(By.xpath("//android.widget.ScrollView[@resource-id=\"com.truecaller:id/buttonPanel\"]")).click();
            //driver.findElement(By.xpath("//android.widget.ScrollView[@resource-id=\"com.truecaller:id/buttonPanel\"]")).click();
            //driver.findElement(By.linkText("CONTINUE")).click();
            final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
            Point tapPoint = new Point(856, 2131);
            Sequence tap = new Sequence(FINGER, 1);
            tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
            tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
                    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
            tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(tap));
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
            Thread.sleep(3000);
            Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.truecaller:id/privacyPolicyTitle\"]")).isDisplayed());
            driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.truecaller:id/nextButton\"]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.truecaller:id/countryText\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]")).click();
            driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@resource-id=\"com.truecaller:id/search_src_text\"]")).click();
            driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@resource-id=\"com.truecaller:id/search_src_text\"]")).sendKeys("Sweden");
            driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.truecaller:id/countryText\"]")).click();

            Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.truecaller:id/phoneNumberEditText\"]")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.truecaller:id/phoneNumberEditText\"]")).sendKeys("707634076");

            driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.truecaller:id/nextButton\"]")).click();


            // Your test steps go here
            // For example, you might want to perform some actions or assertions after launching the app.

            // Close the app
            driver.quit();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            // Handle errors or perform cleanup actions if needed
        }
    }
}

package screenObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultDriver {
    private AndroidDriver androidDriver;

    public AndroidDriver launchApp(){
        // Define desired capabilities for the app
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");  // or "iOS"
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("exported", true);

        // For Android
        capabilities.setCapability("appPackage", "com.truecaller");  // Android package name
        capabilities.setCapability("appActivity", "com.truecaller.ui.TruecallerInit");  // Android activity name

        // Set the Appium server URL
        String appiumServerURL = "http://127.0.0.1:4723/wd/hub";
        try {
            this.androidDriver = new AndroidDriver(new URL(appiumServerURL), capabilities);
        }catch (MalformedURLException mue){
            mue.printStackTrace();
        }
        return androidDriver;
    }

    public void quitDriver(AndroidDriver driver) {
        driver.quit();
    }
}

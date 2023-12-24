package utility;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Helper {
    AndroidDriver driver;
    public Helper(AndroidDriver driver){
        this.driver =driver;
    }
    public WebElement waitForElementToBeVisibleById(String locator){
         return (new WebDriverWait(driver, Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(5)))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
    }
    public WebElement waitForElementToBeVisibleByXpath(String locator){
        return (new WebDriverWait(driver, Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(5)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public String readDataFromFile(String propertyKey) {
        String propertyValue;
        try {
            InputStream input = new FileInputStream("src/test/resources/test-data/register.properties");
            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            propertyValue = prop.getProperty(propertyKey);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return propertyValue;
    }
    public void clickByAxes(int xAxis, int yAxis){
        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
        //Point tapPoint = new Point(856, 2131);
        Point tapPoint = new Point(xAxis, yAxis);
        Sequence tap = new Sequence(FINGER, 1);
        tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }
}

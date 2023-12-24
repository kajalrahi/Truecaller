package screenObjects;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Helper;

public class EnterYourPhoneScreen{
    private final AndroidDriver driver;
    private final String screenTitle = "//android.widget.TextView[@resource-id=\"com.truecaller:id/titleText\"]";
    private final String countryDropDown = "//android.widget.EditText[@resource-id=\"com.truecaller:id/countryText\"]";
    private final String searchButton = "//android.widget.ImageView[@content-desc=\"Search\"]";
    private final String searchTextBox = "//android.widget.AutoCompleteTextView[@resource-id=\"com.truecaller:id/search_src_text\"]";
    private final String searchResult = "//android.widget.TextView[@resource-id=\"com.truecaller:id/countryText\"]";
    private final String phoneNumberTextBox = "//android.widget.EditText[@resource-id=\"com.truecaller:id/phoneNumberEditText\"]";
    private final String verifyMyNumber = "//android.widget.Button[@resource-id=\"com.truecaller:id/nextButton\"]";
    private final String confirmButton = "//android.widget.Button[@resource-id=\"android:id/button1\"]";

    public EnterYourPhoneScreen(AndroidDriver driver) {
        this.driver =driver;
    }

    public void verifyPhoneNumberScreenIsVisible() {
        WebElement phoneScreenTitle = new Helper(driver).waitForElementToBeVisibleByXpath(screenTitle);
        Assert.assertTrue(phoneScreenTitle.isDisplayed());
    }

    public void selectCountry() {
        driver.findElement(By.xpath(countryDropDown)).click();
        WebElement countrySearch = new Helper(driver).waitForElementToBeVisibleByXpath(searchButton);
        countrySearch.isDisplayed();
        countrySearch.click();
        driver.findElement(By.xpath(searchTextBox)).click();
        driver.findElement(By.xpath(searchTextBox)).sendKeys(new Helper(driver).readDataFromFile("country_name"));
        driver.findElement(By.xpath(searchResult)).click();
    }

    public void inputPhoneNumber() {
        WebElement phoneNumberText = new Helper(driver).waitForElementToBeVisibleByXpath(phoneNumberTextBox);
        phoneNumberText.isDisplayed();
        phoneNumberText.click();
        phoneNumberText.clear();
        phoneNumberText.sendKeys(new Helper(driver).readDataFromFile("phone_number"));
    }

    public void clickVerifyMyNumber() {
        WebElement verifyMyNumberButton = new Helper(driver).waitForElementToBeVisibleByXpath(verifyMyNumber);
        verifyMyNumberButton.isDisplayed();
        verifyMyNumberButton.click();
    }

    public void clickConfirmButton() {
        WebElement confirmAndContinueButton = new Helper(driver).waitForElementToBeVisibleByXpath(confirmButton);
        confirmAndContinueButton.isDisplayed();
        confirmAndContinueButton.click();
    }

}

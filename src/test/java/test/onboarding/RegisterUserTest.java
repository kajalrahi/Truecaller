package test.onboarding;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screenObjects.*;

public class RegisterUserTest {
    TruecallerInitialScreen truecallerInitialScreen;
    PrivacyPolicyScreen privacyPolicyScreen;
    PermissionScreen permissionScreen;
    NotificationScreen notificationScreen;
    EnterYourPhoneScreen enterYourPhoneScreen;
    DefaultDriver defaultDriver;
    AndroidDriver androidDriver;
    ExtentReports extentReports = new ExtentReports();
    ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("report/Truecaller_report.html");
    ExtentTest extentTest;

    @BeforeClass
    public void setUp(){
        defaultDriver = new DefaultDriver();
        androidDriver = defaultDriver.launchApp();
        truecallerInitialScreen = new TruecallerInitialScreen(androidDriver);
        privacyPolicyScreen = new PrivacyPolicyScreen(androidDriver);
        permissionScreen = new PermissionScreen(androidDriver);
        notificationScreen = new NotificationScreen(androidDriver);
        enterYourPhoneScreen = new EnterYourPhoneScreen(androidDriver);
    }

    @BeforeTest
    public void setupReport() {
        extentReports.attachReporter(extentSparkReporter);
    }

    @Test
    public void registerNewUser() {
        extentTest = extentReports.createTest("Register new user on Truecaller.");
        truecallerInitialScreen.verifyScreenTitleIsDisplayed();
        truecallerInitialScreen.clickStopSpamNowButton();
        truecallerInitialScreen.handleAlert();
        extentTest.log(Status.PASS, "Launched initial screen.");

        permissionScreen.verifyPermissionScreenIsShown();
        permissionScreen.clickContinueButton();
        extentTest.log(Status.PASS, "Accept permission.");

        truecallerInitialScreen.clickAllowButton();
        truecallerInitialScreen.clickAllowButton();
        truecallerInitialScreen.clickAllowButton();
        truecallerInitialScreen.clickAllowButton();
        extentTest.log(Status.PASS, "Allow different access.");

        privacyPolicyScreen.verifyPrivacyPolicyScreenIsDisplayed();
        privacyPolicyScreen.clickAgreeAndContinueButton();
        extentTest.log(Status.PASS, "Accept privacy policy.");

        notificationScreen.verifyNotificationScreenIsDisplayed();
        notificationScreen.clickOkButton();
        extentTest.log(Status.PASS, "Accept notification.");

        enterYourPhoneScreen.verifyPhoneNumberScreenIsVisible();
        enterYourPhoneScreen.selectCountry();
        enterYourPhoneScreen.inputPhoneNumber();
        enterYourPhoneScreen.clickVerifyMyNumber();
        enterYourPhoneScreen.clickConfirmButton();
        extentTest.log(Status.PASS, "Select country and input phone number.");

        privacyPolicyScreen.verifyPrivacyPolicyScreenIsDisplayed();
        privacyPolicyScreen.clickAgreeAndContinueButton();
        extentTest.log(Status.PASS, "Accept privacy policy.");
    }

    @AfterTest
    public void tearDown() {
        defaultDriver.quitDriver(androidDriver);
        extentReports.flush();
    }
}

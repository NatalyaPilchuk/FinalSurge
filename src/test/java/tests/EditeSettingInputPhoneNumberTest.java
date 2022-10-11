package tests;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.RetryAnalyser;

public class EditeSettingInputPhoneNumberTest extends BaseTest {

    @Test(priority = 1,retryAnalyzer = RetryAnalyser.class,description = "user try to input to the phone number field 12nletters instead of 10digits")
    public void inputPhoneNumberTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSettings();
        AllSettingsPage allSettingsPage = new AllSettingsPage(driver);
        allSettingsPage.clickEditeSettings();
        EditeSettingsPage editeSettingsPage = new EditeSettingsPage(driver);
        editeSettingsPage.input12Letters();
        editeSettingsPage.saveButtonClick();
        Assert.assertTrue(allSettingsPage.isWarningMessageDisplayed(),"it's possible to input  12 letters ");
    }
}
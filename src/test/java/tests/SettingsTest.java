package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.SettingsPage;
import pages.UpdateEmailAddressPage;
import utils.RetryAnalyser;

public class SettingsTest extends BaseTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyser.class, description = "fill all fields in User Profile")
    public void fillInFieldsInUserProfile() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSettings();
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickEditProfile();
        settingsPage.clickFemale();
        settingsPage.inputDate();
        settingsPage.inputWeight();
        settingsPage.chooseCountry();
        settingsPage.inputCity();
        settingsPage.inputZip();
        settingsPage.clickSaveButton();
        Assert.assertEquals(settingsPage.getText(), "Name: Natalya Pilchuk", "we didn't input sll fields");
    }

    @Test(priority = 2, description = "add 3 digits at the end of email at settings")
    public void updateEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSettings();
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickEditProfile();
        settingsPage.clickHere();
        UpdateEmailAddressPage updateEmail = new UpdateEmailAddressPage(driver);
        updateEmail.changeEmail();
        Assert.assertTrue(updateEmail.isWarningMessageDisplayed(), "there isn't such message");
    }

}

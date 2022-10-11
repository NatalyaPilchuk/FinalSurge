package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.RetryAnalyser;

public class SettingUpdateEmailTest extends BaseTest{
    @Test(priority = 1,retryAnalyzer = RetryAnalyser.class, description = "add 3 digits at the end of email at settings")
    public void updateEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSettings();
        EditeProfilePage editeProfilePage = new EditeProfilePage(driver);
        AllSettingsPage allSettingsPage=new AllSettingsPage(driver);
        allSettingsPage.clickEditProfile();
        editeProfilePage.clickHere();
        UpdateEmailAddressPage updateEmail = new UpdateEmailAddressPage(driver);
        updateEmail.changeEmail();
        Assert.assertTrue(updateEmail.isWarningMessageDisplayed(), "there isn't such message");
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class FinalSurgeTest extends BaseTest {
    @Test
    public void createAccountTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isSignFinalSurgeDisplayed(), "there isn't sign FinalSurge");
    }

    @Test
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

    @Test
    public void addNewShoes() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGearAndRoutes();
        GearAndRoutesPage gearAndRoutes = new GearAndRoutesPage(driver);
        gearAndRoutes.inputFields();
        Assert.assertTrue(gearAndRoutes.isSignPencilDisplayed(), "There isn't sign on the page");
    }
}
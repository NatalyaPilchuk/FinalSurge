package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.RetryAnalyser;

public class SettingUpdateEmailTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(SettingUpdateEmailTest.class.getName());
    @Test(priority = 1,retryAnalyzer = RetryAnalyser.class, description = "add 3 digits at the end of email at settings")
    public void updateEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized",LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page",LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Input username and password");
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        LOGGER.info(String.format("Page %s initialized",MainPage.class.getName()));
        LOGGER.info("Follow Settings");
        mainPage.clickSettings();
        AllSettingsPage allSettingsPage=new AllSettingsPage(driver);
        LOGGER.info(String.format("Page %s initialized",AllSettingsPage.class.getName()));
        LOGGER.info("Follow Edite Profile");
        allSettingsPage.clickEditProfile();
        EditeProfilePage editeProfilePage = new EditeProfilePage(driver);
        LOGGER.info(String.format("Page %s initialized",EditeProfilePage.class.getName()));
        LOGGER.info("Go to update email address page");
        editeProfilePage.clickHere();
        UpdateEmailAddressPage updateEmail = new UpdateEmailAddressPage(driver);
        LOGGER.info(String.format("Page %s initialized",UpdateEmailAddressPage.class.getName()));
        LOGGER.info("Change the email");
        updateEmail.changeEmail();
        LOGGER.info("Check if warning message is displayed");
        Assert.assertTrue(updateEmail.isWarningMessageDisplayed(), "there isn't such message");
    }
}

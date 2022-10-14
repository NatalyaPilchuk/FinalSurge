package tests;

import com.sun.net.httpserver.Authenticator;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.RetryAnalyser;


public class EditeSettingInputPhoneNumberTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(EditeSettingInputPhoneNumberTest.class.getName());

    @Test(description = "user try to input to the phone number field 12 letters instead of 10 digits")
    @Description("User try to input into phone number field 12 letters instead of 10 digits")
    public void inputPhoneNumberTest() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Input username and password");
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        LOGGER.info("Follow Settings");
        mainPage.clickSettings();
        AllSettingsPage allSettingsPage = new AllSettingsPage(driver);
        LOGGER.info(String.format("Page %s initialized", AllSettingsPage.class.getName()));
        LOGGER.info("Follow Edite Settings");
        allSettingsPage.clickEditeSettings();
        EditeSettingsPage editeSettingsPage = new EditeSettingsPage(driver);
        LOGGER.info(String.format("Page %s initialized", EditeSettingsPage.class.getName()));
        LOGGER.info("Input 12 letters instead of 10digits");
        editeSettingsPage.input12Letters();
        LOGGER.info("Follow calculator button");
        editeSettingsPage.saveButtonClick();
        LOGGER.info("Check if warning message is displayed");
        Assert.assertTrue(allSettingsPage.isWarningMessageDisplayed(), "it's possible to input  12 letters ");
    }
}
package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSettingsPage;
import pages.LoginPage;
import pages.MainPage;
import pages.EditeProfilePage;
import utils.RetryAnalyser;


public class SettingUpdateFirstNameTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(SettingUpdateFirstNameTest.class.getName());

    @Test(description = "user update first name at settings")
    @Description("User try to update the first name in settings")
    public void updateFirstNameTest() {
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
        LOGGER.info("Follow Edite Profile");
        allSettingsPage.clickEditProfile();
        EditeProfilePage editeProfilePage = new EditeProfilePage(driver);
        LOGGER.info(String.format("Page %s initialized", EditeProfilePage.class.getName()));
        LOGGER.info("Input updated first name");
        editeProfilePage.updateFirstName();
        LOGGER.info("Click save button");
        editeProfilePage.clickSaveButton();
        LOGGER.info(String.format("Check if expected result and actual name are the same:%s=%s", editeProfilePage.getText(), "Name: Natasha Pilchuk"));
        Assert.assertEquals(editeProfilePage.getText(), "Name: Natasha Pilchuk", "the first name isn't update");

    }
}

package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSettingsPage;
import pages.LoginPage;
import pages.MainPage;
import pages.EditeProfilePage;
import utils.RetryAnalyser;

public class SettingsInputAllFieldsTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(SettingsInputAllFieldsTest.class.getName());
    @Test(priority = 1, retryAnalyzer = RetryAnalyser.class, description = "fill all fields in User Profile")
    public void fillInFieldsInUserProfile() {
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
        LOGGER.info("Fill in fields in ");
        editeProfilePage.fillingAllFields();
        LOGGER.info(String.format("Check if expected result and actual name are the same:%s=%s",editeProfilePage.getText(), "Name: Natasha Pilchuk"));
        Assert.assertEquals(editeProfilePage.getText(), "Name: Natasha Pilchuk", "we didn't input ll fields");
    }
}

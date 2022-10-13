package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


public class RegisterTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(RegisterTest.class.getName());

    @Test(priority = 2, description = "user login at FinalSurge")
    @Description("User try to log in with valid data")
    public void loginWithValidDataTest() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Input username and password");
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        LOGGER.info("Check if  logoutButton is displayed");
        Assert.assertTrue(mainPage.isLogoutButtonDisplayed(), "there isn't sign FinalSurge");
    }

    @Test(priority = 1, description = "user login at FinalSurge with invalid Data")
    @Description("User try to log in with invalid data")
    public void loginWithInvalidData() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Input username and password");
        loginPage.loginToFinalSurgeWithInvalidData();
        LOGGER.info("Check if  warning message is displayed");
        Assert.assertTrue(loginPage.isWarningMessageDisplayed(), "there isn't a warning message");
    }


}
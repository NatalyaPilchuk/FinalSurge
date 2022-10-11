package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.RetryAnalyser;

public class RegisterTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(RegisterTest.class.getName());

    @Test(priority = 2,retryAnalyzer = RetryAnalyser.class,description = "user login at FinalSurge")
    public void createAccountWithValidDataTest() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized",LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page",LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Input username and password");
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        LOGGER.info(String.format("Page %s initialized",MainPage.class.getName()));
        LOGGER.info("Check if  logoutButton is displayed");
        Assert.assertTrue(mainPage.isSignFinalSurgeDisplayed(), "there isn't sign FinalSurge");
    }
    @Test(priority = 1,retryAnalyzer = RetryAnalyser.class,description = "user login at FinalSurge with invalid Data")
    public void createAccountWithInvalidData(){
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized",LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page",LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Input username and password");
        loginPage.loginToFinalSurgeWithInvalidData();
        LOGGER.info("Check if  warningMessage is displayed");
        Assert.assertTrue(loginPage.isWarningMessageDisplayed(),"there is a warning message");
    }



}
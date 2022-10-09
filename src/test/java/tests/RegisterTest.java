package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.RetryAnalyser;

public class RegisterTest extends BaseTest {
    @Test(priority = 2,retryAnalyzer = RetryAnalyser.class,description = "user login at FinalSurge")
    public void createAccountWithValidDataTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isSignFinalSurgeDisplayed(), "there isn't sign FinalSurge");
    }
    @Test(priority = 1,retryAnalyzer = RetryAnalyser.class,description = "user login at FinalSurge with invalid Data")
    public void createAccountWithInvalidData(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToFinalSurgeWithInvalidData();
        Assert.assertTrue(loginPage.isWarningMessageDisplayed(),"there isn't warning message");
    }



}
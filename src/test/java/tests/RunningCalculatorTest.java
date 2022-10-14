package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.WorkoutCalculatorsPage;
import utils.RetryAnalyser;

public class RunningCalculatorTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(RegisterTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyser.class,description = "user calculate running paces")
    @Description("User try to calculate paces")
    public void calculateRunningDistance() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Input username and password");
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        mainPage.clickWorkoutCalculator();
        LOGGER.info(String.format("Page %s initialized", WorkoutCalculatorsPage.class.getName()));
        WorkoutCalculatorsPage workoutCalculatorsPage = new WorkoutCalculatorsPage(driver);
        LOGGER.info("Input fields for calculating paces");
        workoutCalculatorsPage.inputFields();
        LOGGER.info("Check if the calculating of paces is displayed");
        Assert.assertTrue(workoutCalculatorsPage.isTablesWithDataDisplayed(), "there isn't result of calculating paces");
    }
}

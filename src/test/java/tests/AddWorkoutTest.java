package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.LoginPage;
import pages.MainPage;



public class AddWorkoutTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(AddWorkoutTest.class.getName());

    @Test(description = "user add new workout")
    @Description("User try to add new workout")
    public void addWorkoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Input username and password");
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        LOGGER.info("Attempt to notice calendarPage");
        mainPage.clickViewCalendar();
        LOGGER.info(String.format("Page %s initialized", CalendarPage.class.getName()));
        CalendarPage calendarPage = new CalendarPage(driver);
        LOGGER.info("Follow to quick add workout");
        calendarPage.quickAddClick();
        LOGGER.info("Input date");
        calendarPage.inputDate();
        LOGGER.info("choose sport activity");
        calendarPage.chooseActivity();
        LOGGER.info("input workout name");
        calendarPage.inputWorkoutName();
        LOGGER.info("Input description of workout");
        calendarPage.inputWorkoutDescription();
        LOGGER.info("click saveButton");
        calendarPage.clickSaveButton();
        LOGGER.info("click weekButton");
        calendarPage.clickWeekButton();
        LOGGER.info(String.format("Check if actual workout name %s and expected workout name  %s are the same", calendarPage.getActualWorkoutName(), calendarPage.getExpectedWorkoutName()));
        Assert.assertEquals(calendarPage.getActualWorkoutName(), calendarPage.getExpectedWorkoutName(), "Actual workout name and expected workout name are differ");
    }
}

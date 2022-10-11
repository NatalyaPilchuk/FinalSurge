package tests;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.LoginPage;
import pages.MainPage;
import utils.FakeMessageGenerator;
import utils.RetryAnalyser;

public class AddWorkoutTest extends BaseTest {
    @Test(priority = 1,description = "user add new workout")
    public void addWorkoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickViewCalendar();
        CalendarPage calendarPage = new CalendarPage(driver);
        calendarPage.quickAddClick();
        calendarPage.inputDate();
        calendarPage.chooseActivity();
      calendarPage.inputWorkoutName();
      //String expectedNameWorkout=calendarPage.getExpectedWorkoutName(FakeMessageGenerator.generateBrand());
        calendarPage.inputWorkoutDescription();

        calendarPage.clickSaveButton();
        calendarPage.clickWeekButton();
        String actualNameWorkout= calendarPage.getActualWorkoutName();
        Assert.assertEquals(actualNameWorkout,calendarPage.getExpectedWorkoutName(),"no");


      //  Assert.assertEquals(calendarPage.getTextOfName(), calendarPage.getWorkoutName(), "different workout");
    }
}

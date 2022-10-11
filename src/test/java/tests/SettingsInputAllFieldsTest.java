package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSettingsPage;
import pages.LoginPage;
import pages.MainPage;
import pages.EditeProfilePage;
import utils.RetryAnalyser;

public class SettingsInputAllFieldsTest extends BaseTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyser.class, description = "fill all fields in User Profile")
    public void fillInFieldsInUserProfile() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSettings();
        EditeProfilePage editeProfilePage = new EditeProfilePage(driver);
        AllSettingsPage allSettingsPage=new AllSettingsPage(driver);
        allSettingsPage.clickEditProfile();
        editeProfilePage.clickFemale();
        editeProfilePage.inputDate();
        editeProfilePage.inputWeight();
        editeProfilePage.chooseCountry();
        editeProfilePage.inputCity();
        editeProfilePage.inputZip();
        editeProfilePage.clickSaveButton();
        Assert.assertEquals(editeProfilePage.getText(), "Name: Natasha Pilchuk", "we didn't input sll fields");
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSettingsPage;
import pages.LoginPage;
import pages.MainPage;
import pages.EditeProfilePage;
import utils.RetryAnalyser;

public class SettingUpdateFirstNameTest extends BaseTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyser.class, description = "update first name at settings")
    public void updateFirstNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSettings();
        EditeProfilePage editeProfilePage = new EditeProfilePage(driver);
        AllSettingsPage allSettingsPage=new AllSettingsPage(driver);
        allSettingsPage.clickEditProfile();
        editeProfilePage.updateFirstName();
        editeProfilePage.clickSaveButton();
        Assert.assertEquals(editeProfilePage.getText(),"Name: Natasha Pilchuk","the first name isn't update");

    }
}

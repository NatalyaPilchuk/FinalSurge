package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GearAndRoutesPage;
import pages.LoginPage;
import pages.MainPage;
import utils.RetryAnalyser;

public class GearAndRoutesTest extends BaseTest{
    @Test(priority = 1,description = "user add new shoes")
    public void addNewShoesTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGearAndRoutes();
        GearAndRoutesPage gearAndRoutes = new GearAndRoutesPage(driver);
        gearAndRoutes.inputFields();
      //  Assert.assertEquals(gearAndRoutes.getText(),gearAndRoutes.getNameOfShoes(),"not the same shoes");
        Assert.assertTrue(gearAndRoutes.isSignDistanceDisplayed(),"there isn't the sign");
    }

}

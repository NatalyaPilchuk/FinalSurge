package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalculatorPage;
import pages.LoginPage;
import pages.MainPage;
import utils.RetryAnalyser;

public class CalculatorTest extends BaseTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyser.class,description = "user calculate caloric needs")
    public void caloricNeedsCalculatorTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCalculator();
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.inputWeight();
        calculatorPage.inputHeight();
        calculatorPage.inputAge();
        calculatorPage.inputGender();
        calculatorPage.inputDistance();
        calculatorPage.clickCalculateButton();
        Assert.assertTrue(calculatorPage.isGreenMessageDisplayed(),"the caloric needs is displayed");
    }
}

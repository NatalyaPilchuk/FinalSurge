package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalculatorPage;
import pages.LoginPage;
import pages.MainPage;


public class CalculatorTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(CalculatorTest.class.getName());

    @Test(description = "user calculate caloric needs")
    @Description("User calculate caloric needs")
    public void caloricNeedsCalculatorTest() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Input username and password");
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        LOGGER.info("Follow to calculator");
        mainPage.clickCalculator();
        LOGGER.info(String.format("Page %s initialized", CalculatorPage.class.getName()));
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        LOGGER.info("Input weight");
        calculatorPage.inputWeight();
        LOGGER.info("Input height");
        calculatorPage.inputHeight();
        LOGGER.info("Input age");
        calculatorPage.inputAge();
        LOGGER.info("Check gender");
        calculatorPage.inputGender();
        LOGGER.info("Input distance traveled");
        calculatorPage.inputDistance();
        LOGGER.info("Follow calculator button");
        calculatorPage.clickCalculateButton();
        LOGGER.info("Check if the message with caloric needs is displayed");
        Assert.assertTrue(calculatorPage.isGreenMessageDisplayed(), "the caloric needs isn't displayed");
    }
}

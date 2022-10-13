package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(MainPage.class.getName());
    private By logoutButton = By.xpath("//a[contains(@href, 'logout.cshtml')]");
    private By settings = By.linkText("Settings");
    private By calculator = By.cssSelector("[class='icsw16-calculator']");
    private By viewCalendar = By.cssSelector("[class='btn btn-small btn-info ptip_s']");
    private By trainingPlans = By.xpath("//a[contains(@href, 'TrainingPlans.cshtml')]");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Button logout is displayed")
    public boolean isLogoutButtonDisplayed() {
        LOGGER.info(String.format("Attempt to find logoutButton:%s", logoutButton));
        return driver.findElement(logoutButton).isDisplayed();
    }

    @Step("Follow th settings page")
    public void clickSettings() {
        LOGGER.info("Attempt to click Settings");
        driver.findElement(settings).click();
    }

    @Step("Follow the calculator")
    public void clickCalculator() {
        LOGGER.info("Follow to calculator");
        driver.findElement(calculator).click();
    }


    @Step("Follow the calendar")
    public void clickViewCalendar() {
        LOGGER.info("Follow to calendar");
        driver.findElement(viewCalendar).click();
    }

    @Step("Follow the training plans")
    public void clickTrainingPlans() {
        LOGGER.info("Follow to training plans");
        driver.findElement(trainingPlans).click();
    }
}

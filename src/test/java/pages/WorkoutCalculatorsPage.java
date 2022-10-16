package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.FakeMessageGenerator;

public class WorkoutCalculatorsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(WorkoutCalculatorsPage.class.getName());


    private By iframeWorkoutCalculators = By.cssSelector("[id='IntensityCalciFrame']");
    private By checkMarathon = By.id("MARATHON");

    private By hours = By.id("TimeHH");
    private By minutes = By.id("TimeMM");
    private By seconds = By.id("TimeSS");
    private By calculateButton = By.id("saveButtonSettings");
    private By tables = By.cssSelector("[class='w-box w-box-green']");

    public WorkoutCalculatorsPage(WebDriver driver) {
        super(driver);
    }


    @Step("Input Fields")
    public void inputFields() {
        LOGGER.info(String.format("Attempt to send hours:%s", FakeMessageGenerator.generateTime()));
        WebElement element = driver.findElement(iframeWorkoutCalculators);
        driver.switchTo().frame(element);
        driver.findElement(hours).sendKeys(FakeMessageGenerator.generateTime());
        LOGGER.info(String.format("Attempt to send minutes:%s", FakeMessageGenerator.generateTime()));
        driver.findElement(minutes).sendKeys(FakeMessageGenerator.generateTime());
        LOGGER.info(String.format("Attempt to send seconds:%s", FakeMessageGenerator.generateTime()));
        driver.findElement(seconds).sendKeys(FakeMessageGenerator.generateTime());
        LOGGER.info("Attempt choose marathon");
        driver.findElement(checkMarathon).click();
        LOGGER.info("Attempt to click calculate button");
        driver.findElement(calculateButton).click();
    }

    @Step("Tables with calculating paces are displayed")
    public boolean isTablesWithDataDisplayed() {
        LOGGER.info("Attempt to find out tables with data");
        return driver.findElement(tables).isDisplayed();
    }
}

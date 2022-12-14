package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.FakeMessageGenerator;

import java.util.List;

public class CalendarPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(CalendarPage.class.getName());
    private By quickAdd = By.id("QuickAddToggle");
    private By date = By.id("WorkoutDate");
    private By selectActivity = By.id("ActivityType");
    private By workoutName = By.id("Name");
    private String workoutNameAdd = FakeMessageGenerator.generateBrand();
    private By workoutDescription = By.cssSelector("[name='Desc']");
    private By saveButton = By.id("saveButton");
    private By workoutNameCalendar = By.xpath("//span[contains(@class,'muted')]//strong");
    private By weekButton = By.xpath("//div[@class='fc-header-left']//span[1]//span[@class='fc-button-content']");

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click add workout")
    public void quickAddClick() {
        LOGGER.info("Attempt to quick add workout");
        driver.findElement(quickAdd).click();
    }

    @Step("Input date")
    public void inputDate() {
        LOGGER.info(String.format("Attempt to send date: %s", "10/11/2022"));
        driver.findElement(date).clear();
        driver.findElement(date).sendKeys("10/20/2022");
    }

    @Step("Choose sport activity")
    public void chooseActivity() {
        LOGGER.info(String.format("Attempt to choose sport activity:%s", FakeMessageGenerator.generateNumberFromTo()));
        WebElement dropdownList = driver.findElement(selectActivity);
        Select selectOption = new Select(dropdownList);
        selectOption.selectByIndex(FakeMessageGenerator.generateNumberFromTo());
    }

    @Step("Input workout name")
    public void inputWorkoutName() {
        LOGGER.info(String.format("Attempt to send workout name:%s", workoutNameAdd));
        driver.findElement(workoutName).sendKeys(workoutNameAdd);
    }

    @Step("Input workout description")
    public void inputWorkoutDescription() {
        LOGGER.info(String.format("Attempt to send description of workout:%s", FakeMessageGenerator.generateDescription()));
        driver.findElement(workoutDescription).sendKeys(FakeMessageGenerator.generateDescription());
    }

    @Step("Click save button")
    public void clickSaveButton() {
        LOGGER.info("Attempt to follow save button");
        driver.findElement(saveButton).click();
    }

    @Step("Change calendar from month to week")
    public void clickWeekButton() {
        LOGGER.info("Attempt to choose week calendar");
        driver.findElement(weekButton).click();
    }

    @Step("Input date")
    public String getExpectedWorkoutName() {
        return workoutNameAdd;
    }

    @Step("Get actual workout name")
    public String getActualWorkoutName() {
        List<WebElement> workoutList = driver.findElements(workoutNameCalendar);
        int amountElements = workoutList.size();
        LOGGER.info(String.format("Attempt to displayed actual workout name", workoutList.get(amountElements - 1).getText()));
        String actualElement = workoutList.get(amountElements - 1).getText();
        return actualElement;

    }
}

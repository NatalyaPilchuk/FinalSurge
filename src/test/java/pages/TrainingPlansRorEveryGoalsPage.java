package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TrainingPlansRorEveryGoalsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(TrainingPlansRorEveryGoalsPage.class.getName());
    private By search = By.xpath("//input[@placeholder='Search by title, coach, description']");
    private By filterSign = By.xpath("//div[contains(@class,'col-auto')]//div[@class='action-button__notification']");

    public TrainingPlansRorEveryGoalsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input kind of spots into the search line")
    public void inputSportIntoSearchLine() {
        LOGGER.info(String.format("Attempt to input sport activity:%s", "running"));
        driver.findElement(search).sendKeys("running");
    }

    @Step("Sign '1' with filter is displayed")
    public boolean isFilterSign1Displayed() {
        LOGGER.info(String.format("Attempt to be sign %s near the filter", "1"));
        return driver.findElement(filterSign).isDisplayed();
    }
}

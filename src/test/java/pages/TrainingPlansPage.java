package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrainingPlansPage extends BasePage{
    private static final Logger LOGGER = LogManager.getLogger(TrainingPlansPage.class.getName());
    private By findPlan=By.cssSelector("[class='btn btn-large btn-success btn-block']");
    public TrainingPlansPage(WebDriver driver) {
        super(driver);
    }
    public void clickFindPlans(){
        LOGGER.info("Attempt to click find plans button");
        driver.findElement(findPlan).click();
    }
}

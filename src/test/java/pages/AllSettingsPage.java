package pages;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllSettingsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(AllSettingsPage.class.getName());
    private By editProfile = By.xpath("(//span)[4]");

    private By editeSettings = By.xpath("(//span)[10]");
    private By warningMessage = By.cssSelector("[class='alert alert-error']");

    public AllSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void clickEditProfile() {
        LOGGER.info(String.format("Attempt to click edite profile:%s", editProfile));
        driver.findElement(editProfile).click();
    }

    @Step("Click Edite Settings")
    public void clickEditeSettings() {
        LOGGER.info(String.format("Attempt to click edite settings:%s", editeSettings));
        driver.findElement(editeSettings).click();
    }

    @Step("Warning message isn't displayed")
    public boolean isWarningMessageDisplayed() {
        LOGGER.info("Attempt the warning message");
        return driver.findElement(warningMessage).isDisplayed();
    }
}

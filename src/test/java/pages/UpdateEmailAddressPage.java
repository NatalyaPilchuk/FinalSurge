package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateEmailAddressPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(UpdateEmailAddressPage.class.getName());
    private By email = By.id("email");
    private By password = By.id("upassword");
    private By saveButton = By.id("saveButton");
    private By warningMessage = By.cssSelector("[class='alert alert-error']");

    public UpdateEmailAddressPage(WebDriver driver) {
        super(driver);
    }

    @Step("Update email address")
    public void changeEmail() {
        LOGGER.info(String.format("Attempt to send email with '123' at the end:%s", "natalya_pilchuk@yopmail.com123"));
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys("natalya_pilchuk@yopmail.com123");
        LOGGER.info(String.format("Attempt to send password:%s", "8692421qweQWE"));
        driver.findElement(password).sendKeys("8692421qweQWE");
        LOGGER.info(String.format("Attempt to follow save button", saveButton));
        driver.findElement(saveButton).click();
    }

    @Step("Warning message isn't displayed")
    public boolean isWarningMessageDisplayed() {
        LOGGER.info("Attempt to find out warning message");
        return driver.findElement(warningMessage).isDisplayed();
    }
}

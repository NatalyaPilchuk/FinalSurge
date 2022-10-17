package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditeSettingsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(EditeSettingsPage.class.getName());
    private By inputPhoneNumber = By.cssSelector("[id='phonenum']");
    private By saveButton = By.cssSelector("[name='btnSubmitSettings']");

    public EditeSettingsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input 12 letters into phone number field")
    public void input12Letters() {
        LOGGER.info(String.format("Attempt to send 12 letters:%s", "aaaaaaaaaaaa"));
        driver.findElement(inputPhoneNumber).clear();
        driver.findElement(inputPhoneNumber).sendKeys("aaaaaaaaaaaa");
    }

    @Step("Click save button")
    public void saveButtonClick() {
        LOGGER.info(String.format("Attempt to click save button", saveButton));
        driver.findElement(saveButton).click();
    }
}

package pages;

import constants.Credentials;
import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakeMessageGenerator;

public class LoginPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());
    private By userNameInput = By.id("login_name");
    private By passwordInput = By.id("login_password");
    private By loginButton = By.xpath("//div[contains(@class,'panel')]//button[text()='Login']");
    private By warningMessage = By.cssSelector("[style='font-weight: bold;']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open LogIn page")
    public void openLoginPage() {
        LOGGER.info(String.format("Attempt to open url: %s", Urls.FINAL_SURGE_LOGIN));
        driver.get(Urls.FINAL_SURGE_LOGIN);
    }

    @Step("Input valid email, password. Follow the main page")
    public void loginToFinalSurge() {
        LOGGER.info(String.format("Attempt to send email: %s", Credentials.EMAIL));
        driver.findElement(userNameInput).sendKeys(Credentials.EMAIL);
        LOGGER.info(String.format("Attempt to send password: %s", Credentials.PASSWORD));
        driver.findElement(passwordInput).sendKeys(Credentials.PASSWORD);
        LOGGER.info(String.format("Attempt to click loginButton:%s", loginButton));
        driver.findElement(loginButton).click();
    }

    @Step("Input invalid email, password. Follow the main page")
    public void loginToFinalSurgeWithInvalidData() {
        LOGGER.info(String.format("Attempt to send email: %s", FakeMessageGenerator.generateEmail()));
        driver.findElement(userNameInput).sendKeys(FakeMessageGenerator.generateEmail());
        LOGGER.info(String.format("Attempt to send email: %s", FakeMessageGenerator.generatePassword()));
        driver.findElement(passwordInput).sendKeys(FakeMessageGenerator.generatePassword());
        LOGGER.info(String.format("Attempt to click loginButton:%s", loginButton));
        driver.findElement(loginButton).click();
    }

    @Step("Warning message is displayed")
    public boolean isWarningMessageDisplayed() {
        LOGGER.info(String.format("Attempt to find warningMessage:%s", warningMessage));
        return driver.findElement(warningMessage).isDisplayed();
    }
}


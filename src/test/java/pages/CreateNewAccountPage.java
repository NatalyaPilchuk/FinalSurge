package pages;

import constants.Urls;
import models.CreateNewAccountModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.CreateNewAccountTest;
import utils.FakeMessageGenerator;

public class CreateNewAccountPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(CreateNewAccountPage.class.getName());
    private By firstName = By.cssSelector("[id='create_first']");
    private By lastName = By.cssSelector("[id='create_last']");
    private By emailAddress = By.cssSelector("[id='create_email']");
    private By password = By.cssSelector("[id='password_meter']");
    private By confirmPassword = By.cssSelector("[id='create_passwordmatch']");
    private By createNewAccountButton = By.cssSelector("[type='submit']");
    private By warningMessage=By.cssSelector("[class='alert alert-error']");


    public CreateNewAccountPage(WebDriver driver) {
        super(driver);
    }

    public void openUrl() {
        LOGGER.info(String.format("Attempt to open url:%s",Urls.FINAL_SURGE_CREATE_NEW_LOGIN));
        driver.get(Urls.FINAL_SURGE_CREATE_NEW_LOGIN);
    }

    public void inputAllFields(CreateNewAccountModel createNewAccount) {
        LOGGER.info(String.format("Attempt to send firstName: %s", createNewAccount.getFirstName() ));
        driver.findElement(firstName).sendKeys(createNewAccount.getFirstName());
        LOGGER.info(String.format("Attempt to send lastName: %s", createNewAccount.getLastName() ));
        driver.findElement(lastName).sendKeys(createNewAccount.getLastName());
        LOGGER.info(String.format("Attempt to send email: %s", createNewAccount.getEmailAddress() ));
        driver.findElement(emailAddress).sendKeys("natalya_pilchuk@yopmail.com");
        LOGGER.info(String.format("Attempt to send password: %s", createNewAccount.getPassword() ));
        driver.findElement(password).sendKeys(createNewAccount.getPassword());
        LOGGER.info(String.format("Attempt to send confirmPassword: %s", createNewAccount.getConfirmPassword()));
        driver.findElement(confirmPassword).sendKeys(createNewAccount.getConfirmPassword());
        LOGGER.info(String.format("Attempt to click createNewAccountButton",createNewAccountButton));
        driver.findElement(createNewAccountButton).click();
    }
    public  boolean isWarningMessageDisplayed(){
        LOGGER.info(String.format("Attempt to find warningMessage:%s",warningMessage));
        return driver.findElement(warningMessage).isDisplayed();
    }
}

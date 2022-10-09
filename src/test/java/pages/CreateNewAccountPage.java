package pages;

import constants.Urls;
import models.CreateNewAccountModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakeMessageGenerator;

public class CreateNewAccountPage extends BasePage {
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
        driver.get(Urls.FINAL_SURGE_CREATE_NEW_LOGIN);
    }

    public void inputAllFields(CreateNewAccountModel createNewAccount) {
        driver.findElement(firstName).sendKeys(createNewAccount.getFirstName());
        driver.findElement(lastName).sendKeys(createNewAccount.getLastName());
        driver.findElement(emailAddress).sendKeys("natalya_pilchuk@yopmail.com");
        driver.findElement(password).sendKeys(createNewAccount.getPassword());
        driver.findElement(confirmPassword).sendKeys(createNewAccount.getConfirmPassword());
        driver.findElement(createNewAccountButton).click();
    }
    public  boolean isWarningMessageDisplayed(){
        return driver.findElement(warningMessage).isDisplayed();
    }
}

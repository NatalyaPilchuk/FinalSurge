package pages;

import constants.Credentials;
import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakeMessageGenerator;

public class LoginPage extends BasePage{
    private By userNameInput=By.id("login_name");
    private By passwordInput=By.id("login_password");
    private By loginButton=By.xpath("//div[contains(@class,'panel')]//button[text()='Login']");
    private By warningMessage=By.cssSelector("[style='font-weight: bold;']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void loginToFinalSurge(){
        driver.get(Urls.FINAL_SURGE_LOGIN);
        driver.findElement(userNameInput).sendKeys(Credentials.EMAIL);
        driver.findElement(passwordInput).sendKeys(Credentials.PASSWORD);
        driver.findElement(loginButton).click();
    }
    public void loginToFinalSurgeWithInvalidData(){
        driver.get(Urls.FINAL_SURGE_LOGIN);
        driver.findElement(userNameInput).sendKeys(FakeMessageGenerator.generateEmail());
        driver.findElement(passwordInput).sendKeys(FakeMessageGenerator.generatePassword());
        driver.findElement(loginButton).click();
    }
    public boolean isWarningMessageDisplayed(){
        return driver.findElement(warningMessage).isDisplayed();
    }
}


package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateEmailAddressPage extends BasePage{
    private By email=By.id("email");
    private By password=By.id("upassword");
    private By saveButton=By.id("saveButton");
private By warningMessage=By.cssSelector("[class='alert alert-error']");
    public UpdateEmailAddressPage(WebDriver driver) {
        super(driver);
    }
    public void changeEmail(){
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys("natalya_pilchuk_qa15_onl@yopmail.com123");
        driver.findElement(password).sendKeys("8692421qweQWE");
        driver.findElement(saveButton).click();
    }
    public boolean isWarningMessageDisplayed(){
        return driver.findElement(warningMessage).isDisplayed();
    }
}

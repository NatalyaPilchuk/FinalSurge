package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class AllSettingsPage extends BasePage{
    private By editProfile = By.xpath("(//span)[4]");

   private By editeSettings=By.xpath("(//span)[10]");
    private By warningMessage=By.cssSelector("[class='alert alert-error']");
    public AllSettingsPage(WebDriver driver) {
        super(driver);
    }
    public void clickEditProfile() {
        driver.findElement(editProfile).click();
    }

    public void clickEditeSettings(){
        driver.findElement(editeSettings).click();
    }
    public boolean isWarningMessageDisplayed(){
        return driver.findElement(warningMessage).isDisplayed();
    }
}

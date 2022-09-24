package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage {
    private By editProfile =By.xpath("(//span)[4]");
    private By clickHere=By.linkText("click here");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }
    public void clickEditProfile(){
        driver.findElement(editProfile).click();
    }
    public void clickHere(){
        driver.findElement(clickHere).click();
    }
}

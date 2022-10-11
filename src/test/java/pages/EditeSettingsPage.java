package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditeSettingsPage extends BasePage{
    private By inputPhoneNumber=By.cssSelector("[id='phonenum']");
    private By saveButton=By.cssSelector("[name='btnSubmitSettings']");
    public EditeSettingsPage(WebDriver driver) {
        super(driver);
    }
    public void input12Letters(){
        driver.findElement(inputPhoneNumber).clear();
        driver.findElement(inputPhoneNumber).sendKeys("aaaaaaaaaaaa");
    }
    public void saveButtonClick(){
        driver.findElement(saveButton).click();
    }
}

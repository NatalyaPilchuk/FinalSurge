package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.FakeMessageGenerator;

public class EditeProfilePage extends BasePage {

    private By clickHere = By.linkText("click here");
    private By clickFemale = By.cssSelector("[id='female']");
    private By date = By.cssSelector("[id='BDay']");
    private By weight = By.cssSelector("[id='Weight']");
    private By selectCountry = By.cssSelector("[id='Country']");
    private By city = By.cssSelector("[id='City']");
    private By zip=By.cssSelector("[id='Zip']");
    private By getTextName=By.xpath("//div[contains(@class,'span10')]//p[@class='formSep'][1]");
    private By saveButton=By.cssSelector("[id='saveButtonProfile']");
    private By firstName=By.cssSelector("[id='fname']");

    public EditeProfilePage(WebDriver driver) {
        super(driver);
    }



    public void clickHere() {
        driver.findElement(clickHere).click();
    }

    public void clickFemale() {
        driver.findElement(clickFemale).click();
    }

    public void inputDate() {
        driver.findElement(date).clear();
        driver.findElement(date).sendKeys("02/03/1990");
    }

    public void inputWeight() {
        driver.findElement(weight).clear();
        driver.findElement(weight).sendKeys(FakeMessageGenerator.generateWeight());
    }

    public void chooseCountry() {
        WebElement dropdownList = driver.findElement(selectCountry);
        Select selectOption = new Select(dropdownList);
        selectOption.selectByIndex(FakeMessageGenerator.generateNumberFromTo());
    }
    public void inputCity(){
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(FakeMessageGenerator.generateCity());
    }
    public void inputZip(){
        driver.findElement(zip).clear();
        driver.findElement(zip).sendKeys(FakeMessageGenerator.generateZipCode());
    }
    public void clickSaveButton(){
        driver.findElement(saveButton).click();
    }
    public String getText(){
        return driver.findElement(getTextName).getText();
    }
public void updateFirstName(){
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys("Natasha");
}

}
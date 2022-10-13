package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.FakeMessageGenerator;

public class EditeProfilePage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(EditeProfilePage.class.getName());

    private By clickHere = By.linkText("click here");
    private By clickFemale = By.cssSelector("[id='female']");
    private By date = By.cssSelector("[id='BDay']");
    private By weight = By.cssSelector("[id='Weight']");
    private By selectCountry = By.cssSelector("[id='Country']");
    private By city = By.cssSelector("[id='City']");
    private By zip = By.cssSelector("[id='Zip']");
    private By getTextName = By.xpath("//div[contains(@class,'span10')]//p[@class='formSep'][1]");
    private By saveButton = By.cssSelector("[id='saveButtonProfile']");
    private By firstName = By.cssSelector("[id='fname']");

    public EditeProfilePage(WebDriver driver) {
        super(driver);
    }


    public void clickHere() {
        driver.findElement(clickHere).click();
    }

    public void fillingAllFields() {
LOGGER.info(String.format("Attempt to choose gender:%s","female"));
        driver.findElement(clickFemale).click();
        LOGGER.info(String.format("Attempt to send the date:%s","02/03/1990"));
        driver.findElement(date).clear();
        driver.findElement(date).sendKeys("02/03/1990");
        LOGGER.info(String.format("Attempt to send the weight:%s",FakeMessageGenerator.generateWeight()));
        driver.findElement(weight).clear();
        driver.findElement(weight).sendKeys(FakeMessageGenerator.generateWeight());
        LOGGER.info("Attempt to choose the country");
        WebElement dropdownList = driver.findElement(selectCountry);
        Select selectOption = new Select(dropdownList);
        selectOption.selectByIndex(FakeMessageGenerator.generateNumberFromTo());
        LOGGER.info(String.format("Attempt to send the city:%s",FakeMessageGenerator.generateCity()));
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(FakeMessageGenerator.generateCity());
        driver.findElement(zip).clear();
        LOGGER.info(String.format("Attempt to send the zipCode:%s",FakeMessageGenerator.generateZipCode()));
        driver.findElement(zip).sendKeys(FakeMessageGenerator.generateZipCode());
        driver.findElement(saveButton).click();
    }

    public String getText() {
        return driver.findElement(getTextName).getText();
    }

    public void updateFirstName() {
        LOGGER.info(String.format("Attempt to send firstName:%s","Natasha"));
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys("Natasha");
    }
    public void clickSaveButton(){
        LOGGER.info(String.format("Attempt to click save button",saveButton));
        driver.findElement(saveButton).click();
    }

}

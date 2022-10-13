package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FakeMessageGenerator;


public class CalculatorPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(CalculatorPage.class.getName());
    private By iframeElement = By.id("OtherCalciFrame");
    private By weight = By.id("Weight");
    private By height = By.cssSelector("[id='HeightInchCent']");
    private By age = By.id("Age");
    private By gender = By.cssSelector("[id='optionsRadios6']");
    private By distance = By.id("RunDist");
    private By calculateButton = By.id("saveButtonSettings");
    private By greenMessageCaloricNeeds = By.xpath("//div[contains(@class,'main-wrapper')]//div[@class='w-box w-box-green']");

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input Weight")
    public void inputWeight() {
        LOGGER.info(String.format("Attempt to send weight:%s", "30"));
        WebElement element = driver.findElement(iframeElement);
        driver.switchTo().frame(element);
        WebElement myWeight = driver.findElement(weight);
        myWeight.sendKeys("30");

    }

    @Step("Input Height")
    public void inputHeight() {
        LOGGER.info(String.format("Attempt to send height:%s", "30"));
        driver.findElement(height).sendKeys("30");
    }

    @Step("Input Age")
    public void inputAge() {
        LOGGER.info(String.format("Attempt to send age:%s", "30"));
        driver.findElement(age).sendKeys("30");
    }

    @Step("Choose gender")
    public void inputGender() {
        LOGGER.info(String.format("Attempt to choose gender:%s", "female"));
        driver.findElement(gender).click();
    }

    @Step("Input Distance")
    public void inputDistance() {
        LOGGER.info(String.format("Attempt to choose distance:%s", FakeMessageGenerator.generateCaloricDistance()));
        driver.findElement(distance).sendKeys(FakeMessageGenerator.generateCaloricDistance());
    }

    @Step("Click calculate button")
    public void clickCalculateButton() {
        LOGGER.info(String.format("Attempt to click calculate caloric needs button:%s", calculateButton));
        driver.findElement(calculateButton).click();
    }

    @Step("Calculation of caloric needs is displayed")
    public boolean isGreenMessageDisplayed() {
        LOGGER.info("Attempt to calculate caloric needs message displayed");
        return driver.findElement(greenMessageCaloricNeeds).isDisplayed();
    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends BasePage {
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

    public void inputWeight() {
        WebElement element = driver.findElement(iframeElement);
        driver.switchTo().frame(element);
        WebElement myWeight = driver.findElement(weight);
        myWeight.sendKeys("30");

    }

    public void inputHeight() {
        driver.findElement(height).sendKeys("30");
    }

    public void inputAge() {
        driver.findElement(age).sendKeys("30");
    }

    public void inputGender() {
        driver.findElement(gender).click();
    }

    public void inputDistance() {
        driver.findElement(distance).sendKeys("300");
    }

    public void clickCalculateButton() {
        driver.findElement(calculateButton).click();
    }

    public boolean isGreenMessageDisplayed() {
        return driver.findElement(greenMessageCaloricNeeds).isDisplayed();
    }


}

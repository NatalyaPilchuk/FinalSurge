package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.FakeMessageGenerator;

public class GearAndRoutesPage extends BasePage {
    private By shoes = By.linkText("Shoes");
    private By shoeName = By.id("ShoeName");
    private By shoeModel = By.id("ShoeModel");
    private By brandShoes = By.xpath("//div[contains(@class,'formSep')]//label[@for='ShoeBrand']//following::b");
    private By getShoesBrand = By.cssSelector("[class='select2-result-label']");
    private By datePurchased = By.id("ShoeDate");
    private By septemberDate = By.xpath("//table[contains(@class,' table-condensed')]//td[text()='28']");
    private By startingDistance = By.id("StartDist");
    private By coast = By.id("ShoeCost");
    private By notes = By.id("ShoeNotes");
    private By addShoe = By.id("saveButton");
    private By signPencil = By.xpath("//div[contains(@style,'padding-top: 10px;')]//i[@class='icon-pencil']");
    private By theNameOfShoes = By.xpath("//td[contains(@style,'width: 60px;')]//following::strong[1]//a");
    private By getTakeNameOfShoes = By.xpath("//div[contains(@class,'formSep')]//input[@name='ShoeName']");
    private By signDistance=By.cssSelector("[class='label label-success']");

    public GearAndRoutesPage(WebDriver driver) {
        super(driver);
    }

    public void inputFields() {
        driver.findElement(shoes).click();
        driver.findElement(shoeName).sendKeys("Abc");
        driver.findElement(brandShoes).click();
        driver.findElement(getShoesBrand).click();
        driver.findElement(shoeModel).sendKeys(FakeMessageGenerator.generateBrand());
        driver.findElement(datePurchased).click();
        driver.findElement(septemberDate).click();
        driver.findElement(startingDistance).clear();
        driver.findElement(startingDistance).sendKeys("300");
        driver.findElement(coast).sendKeys(FakeMessageGenerator.generateMoney());
        driver.findElement(notes).sendKeys(FakeMessageGenerator.generateNotes());
        driver.findElement(addShoe).click();
    }

    public boolean isSignPencilDisplayed() {
        return driver.findElement(signPencil).isDisplayed();
    }

    public String getText() {
        return driver.findElement(theNameOfShoes).getText();
    }

    public String getNameOfShoes() {
        return driver.findElement(getTakeNameOfShoes).getText();
    }
    public boolean isSignDistanceDisplayed() {
        return driver.findElement(signDistance).isDisplayed();
    }

}

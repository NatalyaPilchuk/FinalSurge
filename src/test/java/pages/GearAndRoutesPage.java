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
    private By brandShoes = By.cssSelector("[class='select2-choice select2-default']");
    private By adidas = By.xpath("//span[text()='adidas']");
    private By datePurchased = By.id("ShoeDate");
    private By septemberDate = By.xpath("//table[contains(@class,' table-condensed')]//td[text()='28']");
    private By startingDistance=By.id("StartDist");
    private By coast=By.id("ShoeCost");
    private By notes=By.id("ShoeNotes");
    private By addShoe=By.id("saveButton");
    private By signPencil=By.xpath("//div[contains(@style,'padding-top: 10px;')]//i[@class='icon-pencil']");

    public GearAndRoutesPage(WebDriver driver) {
        super(driver);
    }
public void inputFields(){
    driver.findElement(shoes).click();
    driver.findElement(shoeName).sendKeys(FakeMessageGenerator.generateBrand());
    driver.findElement(shoeModel).sendKeys(FakeMessageGenerator.generateBrand());
    driver.findElement(datePurchased).click();
    driver.findElement(septemberDate).click();
    driver.findElement(startingDistance).sendKeys(FakeMessageGenerator.generateDistance());
    driver.findElement(coast).sendKeys(FakeMessageGenerator.generateMoney());
    driver.findElement(notes).sendKeys(FakeMessageGenerator.generateNotes());
    driver.findElement(addShoe).click();
}
public boolean isSignPencilDisplayed(){
        return driver.findElement(signPencil).isDisplayed();
}



   // public void chooseBrand() {
    //    driver.findElement(brandShoes).click();
     //   driver.findElement(adidas).click();

   // }
}

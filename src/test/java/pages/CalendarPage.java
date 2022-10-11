package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.FakeMessageGenerator;

import java.util.List;

public class CalendarPage extends BasePage {
    private By quickAdd = By.cssSelector("[id='QuickAddToggle']");
    private By date = By.cssSelector("[id='WorkoutDate']");
    private By selectActivity = By.cssSelector("[id='ActivityType']");
    private By workoutName = By.cssSelector("[id='Name']");

    private String workoutNameAdd=FakeMessageGenerator.generateBrand();
    private By workoutDescription = By.cssSelector("[name='Desc']");

    private By saveButton = By.cssSelector("[id='saveButton']");
    private By workoutNameCalendar = By.xpath("//span[contains(@class,'muted')]//strong");
    private By weekButton=By.xpath("//div[@class='fc-header-left']//span[1]//span[@class='fc-button-content']");

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    public void quickAddClick() {
        driver.findElement(quickAdd).click();
    }

    public void inputDate() {
        driver.findElement(date).clear();
        driver.findElement(date).sendKeys("10/11/2022");
    }

    public void chooseActivity() {
        WebElement dropdownList = driver.findElement(selectActivity);
        Select selectOption = new Select(dropdownList);
        selectOption.selectByIndex(FakeMessageGenerator.generateNumberFromTo());
    }

    public void inputWorkoutName() {
        driver.findElement(workoutName).sendKeys(FakeMessageGenerator.generateBrand());
    }

    public void inputWorkoutDescription() {
        driver.findElement(workoutDescription).sendKeys(FakeMessageGenerator.generateDescription());
    }


    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }
    public void clickWeekButton(){
        driver.findElement(weekButton).click();
    }


    public String getExpectedWorkoutName() {
        return workoutNameAdd;
    }

    public String  getActualWorkoutName(){
        List <WebElement> workoutList= driver.findElements(workoutNameCalendar);
        int amountElements=workoutList.size();
       String actualElement= workoutList.get(amountElements-1).getText();
       return actualElement;

    }
    public  String getText(){
         return driver.findElement(workoutName).getText();
    }

}

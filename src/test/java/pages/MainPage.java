package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By signFinalSurge = By.cssSelector("[class='main-logo']");
    private By settings = By.linkText("Settings");
    private By calculator=By.cssSelector("[class='icsw16-calculator']");
    private By gearAndRoutes=By.linkText("Gear & Routes");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignFinalSurgeDisplayed() {
        return driver.findElement(signFinalSurge).isDisplayed();
    }
    public void clickSettings(){
        driver.findElement(settings).click();
    }
    public void clickCalculator(){
        driver.findElement(calculator).click();
    }
    public void clickGearAndRoutes(){
        driver.findElement(gearAndRoutes).click();
    }
}

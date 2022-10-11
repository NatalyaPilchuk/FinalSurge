package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(MainPage.class.getName());
    private By logoutButton = By.xpath("//a[contains(@href, 'logout.cshtml')]");
    private By settings = By.linkText("Settings");
    private By calculator=By.cssSelector("[class='icsw16-calculator']");
    private By gearAndRoutes=By.linkText("Gear & Routes");
    private By viewCalendar=By.cssSelector("[class='btn btn-small btn-info ptip_s']");



    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignFinalSurgeDisplayed() {
        LOGGER.info(String.format("Attempt to find logoutButton:%s",logoutButton));
        return driver.findElement(logoutButton).isDisplayed();
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
    public void clickViewCalendar(){
        driver.findElement(viewCalendar).click();
    }
}

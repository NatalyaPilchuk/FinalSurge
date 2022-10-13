package pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllSettingsPage extends BasePage{
    private static final Logger LOGGER = LogManager.getLogger(AllSettingsPage.class.getName());
    private By editProfile = By.xpath("(//span)[4]");

   private By editeSettings=By.xpath("(//span)[10]");
    private By warningMessage=By.cssSelector("[class='alert alert-error']");
    public AllSettingsPage(WebDriver driver) {
        super(driver);
    }
    public void clickEditProfile() {
        LOGGER.info(String.format("Attempt to click edite profile:%s",editProfile));
        driver.findElement(editProfile).click();
    }

    public void clickEditeSettings(){
        LOGGER.info(String.format("Attempt to click edite settings:%s",editeSettings));
        driver.findElement(editeSettings).click();
    }
    public boolean isWarningMessageDisplayed(){
        LOGGER.info("Attempt to warning message is displayed");
        return driver.findElement(warningMessage).isDisplayed();
    }
}

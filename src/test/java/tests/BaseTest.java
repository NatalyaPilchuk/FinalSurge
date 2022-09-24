package tests;

import factorymanager.DriverFactory;
import factorymanager.DriverManager;
import factorymanager.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.TestListeners;

import java.util.concurrent.TimeUnit;

@Listeners(TestListeners.class)
public class BaseTest {
    public WebDriver driver;
    public DriverManager driverManager;


    @BeforeClass
    @Parameters({"browserType"})
    public void setUp(@Optional("chrome") String browser) {
        DriverFactory driverFactory = new DriverFactory();
        DriverType type = null;
        if (browser.equals("chrome")) {
            type = DriverType.CHROME;
        } else if (browser.equals("firefox")) {
            type = DriverType.FIREFOX;

        }
        driverManager = driverFactory.getManager(type);
        driverManager.createDriver();
        driverManager.setTimeout();
        driverManager.startMaximise();
        driver = driverManager.getDriver();

    }

    public void setImplicitlyWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void removeImplicitlyWait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();

    }
}

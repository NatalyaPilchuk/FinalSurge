package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.TrainingPlansPage;
import pages.TrainingPlansRorEveryGoalsPage;

public class TrainingPlansTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(TrainingPlansTest.class.getName());
    @Test
    public void checkTrainingPlans(){
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized",LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page",LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info("Input username and password");
        loginPage.loginToFinalSurge();
        MainPage mainPage = new MainPage(driver);
        LOGGER.info(String.format("Page %s initialized",MainPage.class.getName()));
        LOGGER.info("Go to training plans page");
        mainPage.clickTrainingPlans();
        TrainingPlansPage trainingPlansPage=new TrainingPlansPage(driver);
        LOGGER.info(String.format("Page %s initialized",TrainingPlansPage.class.getName()));
        LOGGER.info("Go to training plans for every goals page");
        trainingPlansPage.clickFindPlans();
        TrainingPlansRorEveryGoalsPage trainingPlans=new TrainingPlansRorEveryGoalsPage(driver);
        LOGGER.info(String.format("Page %s initialized",TrainingPlansRorEveryGoalsPage.class.getName()));
        LOGGER.info("Input sport activity into search line");
        trainingPlans.inputSportIntoSearchLine();
        LOGGER.info("Check if appears sign 1 near the filter");
        Assert.assertTrue(trainingPlans.isFilterSign1Displayed()," parameter 1 isn't displayed");
    }
}

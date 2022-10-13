package tests;

import io.qameta.allure.Description;
import models.CreateNewAccountModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateNewAccountPage;
import testData.CreateNewAccountData;


public class CreateNewAccountTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(CreateNewAccountTest.class.getName());

    @Test(description = "user try to create new account with the same emailAddress")
    @Description("User try to create new account with already existing email address")
    public void createNewAccountTest() {
        CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);
        LOGGER.info(String.format("Page %s initialized", CreateNewAccountPage.class.getName()));
        LOGGER.info(String.format("Open %s page", CreateNewAccountPage.class.getName()));
        createNewAccountPage.openUrl();
        LOGGER.info("Fill registration form with invalid email");
        CreateNewAccountModel createNewAccountModel = CreateNewAccountData.getValidData();
        LOGGER.info("Input registration fields ");
        createNewAccountPage.inputAllFields(createNewAccountModel);
        LOGGER.info("Check if warning message is displayed");
        Assert.assertTrue(createNewAccountPage.isWarningMessageDisplayed(), "there isn't warning message");
    }
}

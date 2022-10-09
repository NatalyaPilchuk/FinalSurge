package tests;

import models.CreateNewAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateNewAccountPage;
import testData.CreateNewAccountData;
import utils.RetryAnalyser;

public class CreateNewAccountTest extends BaseTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyser.class,description = "user try to create new account with the same emailAddress")
    public void createNewAccountTest(){
        CreateNewAccountPage createNewAccountPage=new CreateNewAccountPage(driver);
        createNewAccountPage.openUrl();
        CreateNewAccountModel createNewAccountModel=CreateNewAccountData.getValidData();
        createNewAccountPage.inputAllFields(createNewAccountModel);
        Assert.assertTrue(createNewAccountPage.isWarningMessageDisplayed(),"there isn't warning message");
    }
}

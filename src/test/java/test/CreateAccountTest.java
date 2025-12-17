package test;

import base.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

import java.io.IOException;

public class CreateAccountTest extends BaseTest {

    @DataProvider(name="LoginData")
    public Object[][] getLoginData() throws IOException {

        String filePath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
        ExcelUtils.loadExcel(filePath, "TestDataSheet");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount-1][2];

        for(int i=1; i<rowCount; i++) {

            data[i-1][0] = ExcelUtils.getCellData(i, 0);	// name
            data[i-1][1] = ExcelUtils.getCellData(i, 1);	// email
        }
        ExcelUtils.closeExcel();
        return data;
    }

    @Test(dataProvider = "LoginData")
    public void CreateAccount(String name, String email){
        HomePage home = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Log.info("Verify that home page is visible successfully");
        test = ExtentReportManager.createTest("create account test");
        test.info("Verify that home page is visible successfully");

        // Step 3: Verify that home page is visible successfully
        Assert.assertTrue(home.IsVisibleHomePage());
        Log.info("Click on 'Signup / Login' button");
        // Step 4: Click on 'Signup / Login' button
        home.ClickButtonSignup();
        Log.info("Verify 'New User Signup!' is visible");
        // Step5 : Verify 'New User Signup!' is visible
        Assert.assertTrue(loginPage.isNewUserSignupVisible());
        Log.info("Enter name and email address");
        // Step 6. Enter name and email address
        loginPage.enterNameEmail(name,email);
        // Step 7. Click 'Signup' button
        loginPage.clickSignupButton();
        //Step 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(createAccountPage.isEnterAccountInformationTxt());
        //Step 9. Fill details: Title, Name, Email, Password, Date of birth
        createAccountPage.fillBasicInformation("123456789");
        //Step 10, 11. Select checkbox
        createAccountPage.fillCheckInput();
        // Step 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        createAccountPage.fillAdressInformation("Anna","Ragov","Horus","Tunis","India","patati","Bardo","2000","25689734");
        //Step13. Click 'Create Account button'
        createAccountPage.clickCreateAccountbutton();
        //Step 14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(createAccountPage.isCreatedAccountTxtVisible());
        // Step 15. Click 'Continue' button
        createAccountPage.clickContinueButton();
        // Step 16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(createAccountPage.isLoggedInVisible());
        // Step 17. Click 'Delete Account' button
        createAccountPage.clickDeleteAccountButton();
    }
}

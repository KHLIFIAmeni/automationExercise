package test;

import base.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ExtentReportManager;

public class LogoutUserTest extends BaseTest {
    @Test
    public void LogoutUser(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        test = ExtentReportManager.createTest("Logout User");
        test.info("3. Verify that home page is visible successfully");
        Assert.assertTrue(homePage.IsVisibleHomePage());
        test.info("4. Click on 'Signup / Login' button");
        homePage.ClickButtonSignup();
        test.info("5. Verify 'Login to your account' is visible");
        Assert.assertTrue(loginPage.isLoginAccountVisible());
        test.info("6. Enter correct email address and password");
        loginPage.enterCorrectEmailPassword("admin88@gmail.com","123456789");
        test.info("7. Click 'login' button");
        loginPage.clickLoginButton();
        test.info("8. Verify that 'Logged in as username' is visible");
        Assert.assertTrue("Logged in as username is not visible",accountPage.isLoggedAsTextVisible());
        test.info("9. Click 'Logout' button");
        accountPage.clickLogoutLink();
        test.info("10. Verify that user is navigated to login page");
        Assert.assertTrue("User is not redirected to login page",loginPage.isLoginAccountVisible());
    }

}

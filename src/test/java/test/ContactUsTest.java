package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utils.ExcelUtils;
import utils.ExtentReportManager;

import java.io.IOException;

public class ContactUsTest extends BaseTest {
    @DataProvider(name="ContactData")
    public Object[][] getLoginData() throws IOException {

        String filePath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
        ExcelUtils.loadExcel(filePath, "ContactTest");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount-1][4];

        for(int i=1; i<rowCount; i++) {

            data[i-1][0] = ExcelUtils.getCellData(i, 0);	// name
            data[i-1][1] = ExcelUtils.getCellData(i, 1);	// email
            data[i-1][2] = ExcelUtils.getCellData(i, 2);	// subject
            data[i-1][3] = ExcelUtils.getCellData(i, 3);	// message
        }
        ExcelUtils.closeExcel();
        return data;
    }

    @Test(dataProvider = "ContactData")

    public void contactUsTest(String name, String email,String subject, String message){
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactPage = new ContactUsPage(driver);
        test = ExtentReportManager.createTest("contact test");

        test.info("3. Verify that home page is visible successfully");
        //Assert.assertTrue(homePage.IsVisibleHomePage(),"home Page not visible");
        test.info("4. Click on 'Contact Us' button");
        homePage.clickContactLink();
        test.info("5. Verify 'GET IN TOUCH' is visible");
        contactPage.isPageContactVisible();
        test.info("6. Enter name, email, subject and message");
        contactPage.enterInformationMessage(name, email,subject, message);
        test.info("7. Upload file");
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/files/testfile.pdf";
        contactPage.uploadFile(filePath);
        test.info("click submit button");
        contactPage.clickButton();
        test.info("is the success Message visible");
        Assert.assertTrue(contactPage.isSuccessMessageVisible(),"Success Message in not visible");
        test.info("redirect to home page");
        contactPage.clickHomeButton();

    }
}

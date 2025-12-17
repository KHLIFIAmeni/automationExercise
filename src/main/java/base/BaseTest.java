package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReportManager;
import utils.Log;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;


    @BeforeSuite
    public void setupReport(){
        extent = ExtentReportManager.getReportInstance();
    }
    @AfterSuite
    public void teardownReport(){
        extent.flush();
    }

    @BeforeMethod
    public void setUp() {
        // Selenium Manager gère automatiquement le driver
        Log.info("starting WebDriver");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Log.info("navigate to URL");
        driver.get("https://www.automationexercise.com");
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE) {

            String screenshotPath = ExtentReportManager.captureScreenshot(driver, "LoginFailure");
            test.fail("Test Failed.. Check Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if(driver != null){
            driver.quit();
        }
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[contains(text(),'New User Signup')]")
    WebElement newUserSignupText;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupButton;

    // Without PageFactory
//    private By newUserSignupText = By.xpath("//h2[contains(text(),'New User Signup')]");
//    private By signupName = By.xpath("//input[@data-qa='signup-name']");
//    private By signupEmail = By.xpath("//input[@data-qa='signup-email']");
//    private By signupButton = By.xpath("//button[@data-qa='signup-button']");

    public boolean isNewUserSignupVisible(){
        return newUserSignupText.isDisplayed();
    }

    public void enterNameEmail(String name,String email ){
        signupName.sendKeys(name);
        signupEmail.sendKeys(email);
    }
    public void clickSignupButton(){
        signupButton.click();
    }
}

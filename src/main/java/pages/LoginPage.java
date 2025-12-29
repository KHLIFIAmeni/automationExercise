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
    @FindBy(xpath = "//h2[normalize-space()='Login to your account']")
    WebElement loginAccountText;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupButton;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmail;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement loginPassword;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    WebElement errorMessage;

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
    public boolean isLoginAccountVisible(){
        return loginAccountText.isDisplayed();
    }
    public void enterCorrectEmailPassword(String email, String password){
        loginEmail.sendKeys(email);
        loginPassword.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public boolean isErrorMessageVisible(){
        return errorMessage.isDisplayed();
    }
}

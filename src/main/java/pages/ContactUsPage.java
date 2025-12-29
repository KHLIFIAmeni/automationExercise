package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    private WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    WebElement getTouchTxt;
    @FindBy(xpath = "//input[@data-qa='name']")
    WebElement nameInput;
    @FindBy(xpath = "//input[@data-qa='email']")
    WebElement emailInput;
    @FindBy(xpath = "//input[@data-qa='subject']")
    WebElement subjectInput;
    @FindBy(xpath = "//textarea[@id='message']")
    WebElement messageInput;
    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement uploadFile;
    @FindBy(xpath = "//input[@data-qa='submit-button']")
    WebElement submitButton;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successMessage;
    @FindBy(xpath = "//a[@class='btn btn-success']")
    WebElement homeButton;
    public boolean isPageContactVisible(){
        return  getTouchTxt.isDisplayed();
    }
    public void enterInformationMessage(String name, String email,String subject, String message ){
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        subjectInput.sendKeys(subject);
        messageInput.sendKeys(message);
    }
    public void uploadFile(String filePath){
        uploadFile.sendKeys(filePath);
    }
    public  void clickButton(){
        submitButton.click();
        driver.switchTo().alert().accept();
    }
    public boolean isSuccessMessageVisible(){
        return successMessage.isDisplayed();
    }
    public void clickHomeButton(){
        homeButton.click();
    }

}

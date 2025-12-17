package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    WebElement enterAccountInformationTxt;
    //private By enterAccountInformationTxt = By.xpath("//b[normalize-space()='Enter Account Information']");
    @FindBy(id = "id_gender1")
    WebElement titleMr;
   // private By titleMr = By.id("id_gender1");
   @FindBy(id = "password")
   WebElement passwordInput;
    //private By passwordInput = By.id("password");
    @FindBy(id="days")
    WebElement dayDropdown;
    //private By dayDropdown = By.id("days");
    @FindBy(id="months")
    WebElement monthDropdown;
    //private By monthDropdown = By.id("months");
    @FindBy(id="years")
    WebElement yearDropdown;
    //private By yearDropdown = By.id("years");

    @FindBy(id="newsletter")
    WebElement newsletterCheckbox;
    //private By newsletterCheckbox = By.id("newsletter");
    @FindBy(id="optin")
    WebElement offersCheckbox;
    //private By offersCheckbox = By.id("optin");
    @FindBy(id = "first_name")
    WebElement firstNameInput;
    //private By firstNameInput = By.id("first_name");
    @FindBy(id="last_name")
    WebElement lastNameInput;
    //private By lastNameInput = By.id("last_name");
    @FindBy(id="company")
    WebElement companyInput;
    //private By companyInput = By.id("company");
    @FindBy(id="address1")
    WebElement address1Input;
    //private By address1Input = By.id("address1");
    @FindBy(id="address2")
    WebElement address2Input;
    //private By address2Input = By.id("address2");
    @FindBy(id="country")
    WebElement countryDropdown;
    //private By countryDropdown = By.id("country");
    @FindBy(id="state")
    WebElement stateInput;
    //private By stateInput = By.id("state");
    @FindBy(id="city")
    WebElement cityInput;
    //private By cityInput = By.id("city");
    @FindBy(id="zipcode")
    WebElement zipcodeInput;
    //private By zipcodeInput = By.id("zipcode");
    @FindBy(id="mobile_number")
    WebElement mobileInput;
    //private By mobileInput = By.id("mobile_number");
    @FindBy(xpath ="//button[@data-qa='create-account']")
    WebElement createAccountButton;
    //private By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    @FindBy(xpath="//b[normalize-space()='Account Created!']")
    WebElement accountCreatedTxt;
    //private By accountCreatedTxt = By.xpath("//b[normalize-space()='Account Created!']");
    @FindBy(xpath="//a[@data-qa='continue-button']")
    WebElement countinueButton;
    //private By countinueButton = By.xpath("//a[@data-qa='continue-button']");
    @FindBy(xpath ="//a[contains(text(), 'Logged in as')]")
    WebElement loggedInTxt;
    //private By loggedInTxt = By.xpath("//a[contains(text(), 'Logged in as')]");
    @FindBy(xpath ="//a[normalize-space()='Delete Account']")
    WebElement deleteAccountButton;
    //private By deleteAccountButton =By.xpath("//a[normalize-space()='Delete Account']");

    
    public boolean isEnterAccountInformationTxt(){
        return enterAccountInformationTxt.isDisplayed();
    }
    public void fillBasicInformation(String password){
        titleMr.click();
        passwordInput.sendKeys(password);
        dayDropdown.sendKeys("12");
        monthDropdown.sendKeys("October");
        yearDropdown.sendKeys("1999");
    }
    public void fillCheckInput(){
        newsletterCheckbox.click();
       offersCheckbox.click();
    }
    public void fillAdressInformation(String firstName, String lastName, String company, String adress, String adress2, String state, String city, String zipCode, String mobileNumber){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        companyInput.sendKeys(company);
        address1Input.sendKeys(adress);
        address2Input.sendKeys(adress2);
        countryDropdown.sendKeys("India");
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipCode);
        mobileInput.sendKeys(mobileNumber);
    }
    public void clickCreateAccountbutton(){
        createAccountButton.click();
    }
    public boolean isCreatedAccountTxtVisible(){
       return accountCreatedTxt.isDisplayed();
    }
    public void clickContinueButton(){
       countinueButton.click();
    }
    public boolean isLoggedInVisible(){
        return loggedInTxt.isDisplayed() ;
    }
    public void clickDeleteAccountButton(){
        deleteAccountButton.click();
    }


    
}

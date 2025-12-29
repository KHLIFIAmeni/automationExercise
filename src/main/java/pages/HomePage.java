package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="slider")
    WebElement HomePageVisible;
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement SignupButton;
    @FindBy(linkText = "Contact us")
    WebElement contactLink;
    // without PageFactory
//    private By HomePageVisible = By.id("slider");
//    private By SignupButton = By.xpath("//a[normalize-space()='Signup / Login']");

    public boolean IsVisibleHomePage(){
//        return driver.findElement(HomePageVisible).isDisplayed();
        return HomePageVisible.isDisplayed();
    }
    public void ClickButtonSignup(){
      SignupButton.click();
    }
    public void clickContactLink(){contactLink.click();}
}

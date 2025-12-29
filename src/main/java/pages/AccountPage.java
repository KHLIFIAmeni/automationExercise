package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver ,this);
    }
    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement loggedAsText;
    @FindBy(linkText = "Logout")
    WebElement logoutLink;
    public boolean isLoggedAsTextVisible(){
       return loggedAsText.isDisplayed();
    }
    public void clickLogoutLink(){
        logoutLink.click();
    }
}

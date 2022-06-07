package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignInPage {
    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    public WebElement signInHeading;

    @FindBy(css = "div[class='column-1']>p")
    public WebElement underHeadingParagraph;

    @FindBy(name = "user[email]") // id we can use if it is in style or JS
    public WebElement emailInputBox;

    @FindBy(css = "label[for='email']")
    public WebElement emailInputBoxLabel;

    @FindBy(name = "user[password]")
    public WebElement passwordInputBox;

    @FindBy(css = "label[for='password']")
    public WebElement passwordInputBoxLabel;

    @FindBy(linkText = "Forgot password?") //.password-help a
    public WebElement forgotPasswordLink;

    @FindBy(css = "div[class='password-help']>p")
    public WebElement passwordWarning8CharsMinMessage;

    @FindBy(className = "sds-disclaimer") // css--> .password-help a
    public WebElement disclaimerMessage;

    @FindBy(css = "button[class='sds-button']")
    public WebElement signInButton;

    @FindBy(css = ".social-title")
    public WebElement connectWithSocialHeading;

    @FindBy(css = "a[data-component='continue-with-social']") ////div[@class='column-2 sidebar-social-login']//a ----> Naim's @FindBy(css = ".column-2 ul a")
    public List<WebElement> signInSocialMedia;

    @FindBy(className = "sds-notification__desc")
    public WebElement errorMessage2;

    @FindBy(className = "sds-notification__title")
    public WebElement errorMessage1;

    public void signIn(String email, String password){
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        signInButton.click();
    }

















}

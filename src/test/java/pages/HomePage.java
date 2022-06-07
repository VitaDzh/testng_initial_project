package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import utilities.Driver;
import utilities.Waiter;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(linkText = "Sign In")
    public WebElement signInLink;

    public void goToSignInPage(){
        signInLink.click();
        Waiter.waitUntilPageIsLoaded(Driver.getDriver(), 30, "https://www.cars.com/signin/?redirect_path=%2F");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F");
    }
}

package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.SignInPage;
import utilities.Driver;

public class Base {

    WebDriver driver;
    WebDriverWait explicitWait;
    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }


    public void goToSignInPage(){
        driver.get("https://www.cars.com/");
        homePage.signInLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F");
    }





}

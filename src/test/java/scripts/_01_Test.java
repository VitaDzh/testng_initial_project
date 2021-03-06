package scripts;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;

public class _01_Test extends Base{

    /*
    Test Case 1: Validate Cars.com Sign in page form
    Given user navigates to “https://www.cars.com/”
    When user clicks on top right “Sign In” link
    Then user should be navigated to “Sign in” page
    And user should be able to see heading1 as "Sign in"
    And user should be able to see paragraph under “Sign in” header as “New to Cars.com? Sign up. Are you a dealer?”
    And user should be able to see Email input box with “Email” label and enabled
    And user should be able to see Password input box with “Password” label and enabled
    And user should be able to see warning under Password input box as “Minimum of eight characters”
    And user should be able to a link as “Forgot password?” under the Password input box
    And user should be able see “By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.” Text
    And user should be able to see “Sign in” button with its text and be displayed and enabled
     */
    @Test(priority = 1, description = "TC1: Validate Cars Sign In Page")
    public void validateCarsSignInPage(){
        goToSignInPage();
        Assert.assertTrue(signInPage.signInHeading.isDisplayed() && signInPage.signInHeading.getText().equals("Sign in"));
        Assert.assertTrue(signInPage.underHeadingParagraph.isDisplayed() && signInPage.underHeadingParagraph.getText().equals("New to Cars.com? Sign up. Are you a dealer?"));
        Assert.assertTrue(signInPage.emailInputBox.isDisplayed() && signInPage.emailInputBoxLabel.getText().equals("Email") && signInPage.emailInputBox.isEnabled());
        Assert.assertTrue(signInPage.passwordInputBox.isDisplayed() && signInPage.passwordInputBoxLabel.getText().equals("Password") && signInPage.passwordInputBox.isEnabled());
        Assert.assertTrue(signInPage.passwordWarning8CharsMinMessage.isDisplayed());
        Assert.assertEquals(signInPage.passwordWarning8CharsMinMessage.getText(), "Minimum of eight characters");
        Assert.assertTrue(signInPage.forgotPasswordLink.isDisplayed() && signInPage.forgotPasswordLink.isEnabled() && signInPage.forgotPasswordLink.getText().equals("Forgot password?"));
        Assert.assertTrue(signInPage.disclaimerMessage.isDisplayed());
        Assert.assertEquals(signInPage.disclaimerMessage.getText(), "By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.");
        Assert.assertTrue(signInPage.signInButton.isDisplayed() && signInPage.signInButton.isEnabled());
    }

    /*
    Test Case 2: Validate Cars.com Sign in page social media section
    Given user navigates to “https://www.cars.com/”
    When user clicks on top right “Sign In” link
    Then user should be navigated to “Sign in” page
    And user should be able to see headings as "Connect with social"
    And user should be able to “Sign in with Facebook” link with its text and be displayed and enabled
    And user should be able to “Sign in with Google” link with its text and be displayed and enabled
    And user should be able to “Sign in with Apple” link with its text and be displayed and enabled

    @Test(priority = 1, description = "TC2: Validate Cars Sign In Page")
    public void validateCarsSignInPageSocialMedia() {
        goToSignInPage();
        Assert.assertTrue(signInPage.connectWithSocialHeading.isDisplayed() && signInPage.connectWithSocialHeading.getText().equals("Connect with social"));

        Assert.assertTrue(signInPage.signInSocialMedia.get(0).isDisplayed() && signInPage.signInSocialMedia.get(0).isEnabled());
        Assert.assertTrue(signInPage.signInSocialMedia.get(1).isDisplayed() && signInPage.signInSocialMedia.get(1).isEnabled());
        Assert.assertTrue(signInPage.signInSocialMedia.get(2).isDisplayed() && signInPage.signInSocialMedia.get(2).isEnabled());

        Assert.assertEquals(signInPage.signInSocialMedia.get(0).getText(), "Sign in with Facebook");
        Assert.assertEquals(signInPage.signInSocialMedia.get(1).getText(), "Sign in with Google");
        Assert.assertEquals(signInPage.signInSocialMedia.get(2).getText(), "Sign in with Apple");

        }

     */

        @Test(priority = 1, description = "TC2: Validate Cars Sign In Page")
        public void validateCarsSignInPageSocialMediaa() {
        goToSignInPage();

        String[] arr = {"Sign in with Facebook", "Sign in with Google", "Sign in with Apple"};
        for (int i = 0; i < signInPage.signInSocialMedia.size(); i++) {
            Assert.assertTrue(signInPage.signInSocialMedia.get(i).isDisplayed() && signInPage.signInSocialMedia.get(i).isEnabled());
            Assert.assertEquals(signInPage.signInSocialMedia.get(i).getText(), arr[i]);
        }
            Assert.assertTrue(signInPage.connectWithSocialHeading.isDisplayed() && signInPage.connectWithSocialHeading.getText().equals("Connect with social"));
        }



        /* NAIM's solution

    @Test(priority = 2, description = "TASK-2 - Social Media Section")
    public void testMediaSection(){
        driver.get("https://www.cars.com/");
        carsHomePage.signInButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F");

        Assert.assertEquals(carsSignInPage.connectWithSocialHeading.getText(), "Connect with social");

        for (int i = 0; i < carsSignInPage.socialLinks.size(); i++) {
            Assert.assertTrue(carsSignInPage.socialLinks.get(i).isDisplayed());
            Assert.assertTrue(carsSignInPage.socialLinks.get(i).isEnabled());

            switch (i){
                case 0:
                    Assert.assertEquals(carsSignInPage.socialLinks.get(i).getText(), "Sign in with Facebook");
                    break;
                case 1:
                    Assert.assertEquals(carsSignInPage.socialLinks.get(i).getText(), "Sign in with Google");
                    break;
                case 2:
                    Assert.assertEquals(carsSignInPage.socialLinks.get(i).getText(), "Sign in with Apple");
                    break;
                default:
                    throw new NoSuchElementException("This element was not found!!");
            }
        }
    }
         */


    /*
    Test Case 3: Validate user cannot sign in to Cars.com with invalid credentials
    Given user navigates to “https://www.cars.com/”
    When user clicks on top right “Sign In” link
    Then user should be navigated to “Sign in” page
    When user enters johndoe@gmail.com to the Email input box
    And user enters abcd1234 to the Password input box
    And user clicks on the “Sign in” button
    Then user should not be logged in and displayed an error message on the top of the form as below
    “We were unable to sign you in.
    Your email or password was not recognized. Try again soon.”
     */
    @Test(priority = 3, description = "TC3: Validate user can not sign in with invalid credentials")
    public void validateSignInWithInvalidCredentials(){
        goToSignInPage();
        signInPage.signIn("johndoe@gmail.com", "abcd1234");
        /*signInPage.emailInputBox.sendKeys("johndoe@gmail.com");
        signInPage.passwordInputBox.sendKeys("abcd1234");
        signInPage.signInButton.click();
         */
        Assert.assertTrue(signInPage.errorMessage1.isDisplayed() && signInPage.errorMessage1.getText().trim().equals("We were unable to sign you in."));
        Assert.assertTrue(signInPage.errorMessage2.isDisplayed() && signInPage.errorMessage2.getText().trim().equals("Your email or password was not recognized. Try again soon."));

    }

}























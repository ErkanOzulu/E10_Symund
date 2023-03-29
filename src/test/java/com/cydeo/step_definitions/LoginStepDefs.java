package com.cydeo.step_definitions;



import com.cydeo.pages.BasePage;
import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Map;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();

    String password1;

    @When("Go to login page")
    public void go_to_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("symund.url"));
    }

    @When("Enter valid username in username field")
    public void enter_valid_username_in_username_field() {
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("username"));

    }

    @When("Enter valid password in password field")
    public void enter_valid_password_in_password_field() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

    }

    @When("Click on the login button")
    public void click_on_the_login_button() {
        loginPage.logInButton.click();
    }

    @Then("Verify that user can login")
    public void Verify_that_user_can_login() {

        Assert.assertTrue(dashboardPage.accountSetting.isDisplayed());
    }


    @Then("user should not be login and  see the message {string}")
    public void userShouldNotBeLoginAndSeeTheMessage(String message) {


        try {
            Assert.assertEquals(message, loginPage.wrongMessage.getText());
        } catch (Exception e) {
            Assert.assertFalse("There is no message",true);
        }


    }


    @And("Enter referred credentials {string} {string}")
    public void enterReferredCredentials(String username, String password) {

        loginPage.inputUsername.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        password1=password;

    }

    @And("Enter valid username in username field and password in password field")
    public void enterValidUsernameInUsernameFieldAndPasswordInPasswordField(Map<String, String> credentials) {
        loginPage.inputUsername.sendKeys(credentials.get("username"));
        loginPage.inputPassword.sendKeys(credentials.get("password"));
    }


    @And("hit enter key word")
    public void hitEnterKeyWord() {
        loginPage.inputPassword.sendKeys(Keys.ENTER);
    }

    @Then("{string} should not be login and  see the pop-up message {string}")
    public void shouldNotBeLoginAndSeeThePopUpMessage(String username, String popupMessage) {



        System.out.println(loginPage.inputUsername.getAttribute("required"));

        if (username.isEmpty()) {
            String message = loginPage.inputUsername.getAttribute("validationMessage");
            Assert.assertEquals(popupMessage, message);
        }
        if (password1.isEmpty()){
            String message = loginPage.inputPassword.getAttribute("validationMessage");
            Assert.assertEquals(popupMessage, message);
        }

        //https://stackoverflow.com/questions/51156670/selenium-java-how-to-locate-browser-validation-message

    }

    @And("Enter username {string} in username field")
    public void enterUsernameInUsernameField(String username) {
        loginPage.inputUsername.sendKeys(username);

    }


    @And("Enter password {string} in password field")
    public void enterPasswordInPasswordField(String password) {
        loginPage.inputPassword.sendKeys(password);
    }

    @Then("User can see the password in a form of dots by default")
    public void userCanSeeThePasswordInAFormOfDotsByDefault() {
        Assert.assertTrue(loginPage.inputPassword.getAttribute("type").equals("password"));

    }

    @And("Click eye sign in password field")
    public void clickEyeSignInPasswordField() {

        loginPage.eyeSign.click();

    }

    @Then("user should be able to see the password explicitly")
    public void userShouldBeAbleToSeeThePasswordExplicitly() {
        Assert.assertEquals("text", loginPage.inputPassword.getAttribute("type"));
    }

    @When("Check Forget password? link on the login page")
    public void checkForgetPasswordLinkOnTheLoginPage() {
        loginPage.forgotPasswordLink.isDisplayed();

    }

    @And("Click  Forget password? link")
    public void clickForgetPasswordLink() {
        loginPage.forgotPasswordLink.click();
    }

    @Then("User can see the Reset password button on the next page")
    public void userCanSeeTheResetpasswordButtonOnTheNextPage() {

        Assert.assertTrue(loginPage.resetButton.isDisplayed());
    }


    @When("Check username and password field")
    public void checkUsernameAndPasswordField() {
        loginPage.inputUsername.isDisplayed();
        loginPage.inputPassword.isDisplayed();
    }

    @Then("user can see expected placeholders in related field")
    public void userCanSeeExpectedPlaceholdersInRelatedField(Map<String, String> placeHolder) {
        Assert.assertEquals(loginPage.inputPassword.getAttribute("placeholder"), placeHolder.get("in_password"));
        Assert.assertEquals(loginPage.inputUsername.getAttribute("placeholder"), placeHolder.get("in_username"));


    }



}

package stepDefinitions;

import Pages.P02_login;
import Pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class D02_loginStepDef {
    P02_login loginPOM = new P02_login();

    @Given("user click on login button")
    public void goToLogin() {
        WebElement loginBtn = new P03_homePage().getLoginButton();
        loginBtn.click();
    }

    @And("^user enter valid email \"(.*)\" and password \"(.*)\"$")
    public void login(String Username, String Password) throws InterruptedException {
        WebElement email = loginPOM.getEmailTextBox();
        WebElement password = loginPOM.getPasswordTextBox();

        email.sendKeys(Username);
        password.sendKeys(Password);

        // TODO: Last thing for today, find out how to select that button
        WebElement loginBtn = loginPOM.getLoginBtn();
        loginBtn.click();

        Thread.sleep(2000);
    }
}
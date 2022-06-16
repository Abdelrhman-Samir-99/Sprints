package stepDefinitions;

import Pages.P01_register;
import Pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_register registerPOM = new P01_register();

    @Given("user go to register page")
    public void goToRegisterPage() {
        // Can be also fetched by using className("ico-register")
        WebElement registerBtn = new P03_homePage().getRegisterButton();
        registerBtn.click();
    }

    @When("user select gender type")
    public void selectGender() {
        // Now, we are selecting the gender type list, and clicking on male
        WebElement genderType = registerPOM.getMaleGenderButton();
        genderType.click();
    }

    @And("user enter first and last name")
    public void enter_first_last_name() {
        WebElement firstName = registerPOM.getFirstNameTextBox();
        WebElement lastName = registerPOM.getLastNameTextBox();

        firstName.sendKeys("Abdelrhman");
        lastName.sendKeys("Samir");
    }

    @And("user enter date of birth")
    public void enter_date_of_birth() throws InterruptedException {
        // TODO: Static drop down list vs Dynamic drop down list, and selectByIndex 0 or 1 based?
        WebElement birthYear = registerPOM.getBirthYearSelect();
        Select select = new Select(birthYear);
        select.selectByValue("1999");

        WebElement birthMonth = registerPOM.getBirthMonthSelect();
        select = new Select(birthMonth);
        select.selectByIndex(6);

        WebElement birthDay = registerPOM.getBirthDaySelect();
        select = new Select(birthDay);
        select.selectByIndex(3);
    }

    @And("user enter email")
    public void enter_email() {
        WebElement emailField = registerPOM.getEmailTextBox();
        emailField.sendKeys("abdulrhman.samir123@gmail.com");
    }

    @And("user enter company name")
    public void enter_company_name() {
        WebElement companyField = registerPOM.getCompanyNameTextBox();
        companyField.sendKeys("Sprints");
    }

    @And("user enter password and validate it")
    public void enter_password() {
        WebElement passwordField = registerPOM.getPasswordTextBox();
        WebElement confirmationField = registerPOM.getConfirmPasswordTextBox();

        passwordField.sendKeys("123456");
        confirmationField.sendKeys("123456");
    }

    @Then("user click on register button and user see success message")
    public void click_on_registerBtn() {
        WebElement registerBtn = registerPOM.getRegisterBtn();
        registerBtn.sendKeys(Keys.ENTER);

        SoftAssert soft = new SoftAssert();
        WebElement resultBox = registerPOM.getRegisterResult();

        soft.assertTrue(resultBox.getText().contains("completed"));
        soft.assertAll();
    }
}
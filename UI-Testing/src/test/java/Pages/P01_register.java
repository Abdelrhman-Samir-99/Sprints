package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

public class P01_register {

    public WebElement getMaleGenderButton() {
        return Hooks.driver.findElement(By.id("gender-male"));
    }

    public WebElement getFemaleGenderButton() {
        return Hooks.driver.findElement(By.id("gender-female"));
    }

    public WebElement getFirstNameTextBox() {
        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement getLastNameTextBox() {
        return Hooks.driver.findElement(By.id("LastName"));
    }

    public WebElement getBirthYearSelect() {
        return Hooks.driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement getBirthMonthSelect() {
        return Hooks.driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement getBirthDaySelect() {
        return Hooks.driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement getEmailTextBox() {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement getCompanyNameTextBox() {
        return Hooks.driver.findElement(By.id("Company"));
    }

    public WebElement getPasswordTextBox() {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement getConfirmPasswordTextBox() {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement getRegisterBtn() {
        return Hooks.driver.findElement(By.id("register-button"));
    }

    public WebElement getRegisterResult() {
        return Hooks.driver.findElement(By.className("result"));
    }
}

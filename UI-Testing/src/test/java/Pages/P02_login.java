package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

public class P02_login {
    public WebElement getEmailTextBox() {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement getPasswordTextBox() {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement getLoginBtn() {
        return Hooks.driver.findElements(By.className("button-1")).get(2);
    }
}

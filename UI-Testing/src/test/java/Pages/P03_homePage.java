package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

import java.util.List;

public class P03_homePage {
    public WebElement getSlider(String number) {
        return Hooks.driver.findElement(By.cssSelector("a[class=\"nivo-imageLink\"]:nth-child(" + number + ")"));
    }

    public WebElement getRegisterButton() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/register?returnUrl=%2F\""));
    }

    public WebElement getLoginButton() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"]"));
    }

    public WebElement getCurrencyList() {
        return Hooks.driver.findElement(By.id("customerCurrency"));
    }

    public List<WebElement> fetchAllItemsForSale() {
        return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }

    public WebElement getSearchBar() {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public List <WebElement> getProductItems() {
        return Hooks.driver.findElements(By.className("product-item"));
    }

    public WebElement getCategoryByName(String name) {
        return Hooks.driver.findElement(
                By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/" + name + "\"]"));
    }

    public WebElement selectSubCategory(String name) {
        return Hooks.driver.findElement(
                By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/" + name + "\"]"));
    }

    public WebElement getPageTitle() {
        return Hooks.driver.findElement(By.className("page-title"));
    }
}

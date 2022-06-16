package stepDefinitions;

import Pages.P03_homePage;
import io.cucumber.java.en.Given;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    P03_homePage homePagePOM = new P03_homePage();

    private void search(String searchWord) {
        WebElement searchBar = homePagePOM.getSearchBar();
        searchBar.sendKeys(searchWord);
        searchBar.sendKeys(Keys.ENTER);
    }

    @Given("^user could search using product name \"(.*)\"$")
    public void searchProductByName(String searchWord) throws InterruptedException {
        search(searchWord);

        Thread.sleep(2000);
        String currentURL = Hooks.driver.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();

        // Checking if we changed the page or not.
        softAssert.assertTrue(currentURL.contains("https://demo.nopcommerce.com/search?q="),
                                            "Something went wrong, didn't redirect.");

        // Checking whether the result is empty or not
        softAssert.assertFalse(homePagePOM.getProductItems().isEmpty(),
                                "There are no results");

        // TODO: ask if it is something like flushing the buffer or not.
        softAssert.assertAll();
    }

    @Given("^user search using sku \"(.*)\"$")
    public void searchProductBySKU(String SKU) throws InterruptedException {
        search(SKU);

        Thread.sleep(2000);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(Hooks.driver.findElements(By.className("product-item")).isEmpty(),
                "There are no results");


        // Now we are trying to click
        WebElement searchItem = Hooks.driver.findElement(By.className("product-item"));
        searchItem.click();

        Thread.sleep(2000);
        softAssert.assertEquals(Hooks.driver.findElement(By.id("sku-4")).getText(), SKU);
        softAssert.assertAll();
    }
}
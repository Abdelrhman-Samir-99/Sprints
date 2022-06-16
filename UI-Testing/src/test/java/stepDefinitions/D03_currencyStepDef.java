package stepDefinitions;

import Pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class D03_currencyStepDef {
    P03_homePage homePagePOM = new P03_homePage();

    @When("user select random currency")
    public void selectCurrency() {
        WebElement currencyType = homePagePOM.getCurrencyList();
        new Select(currencyType).selectByIndex(1);
    }

    @And("all items show with Euro price")
    public void validate_prices_with_Euro() throws InterruptedException {
        // Fetching all items that are available for sale
        List<WebElement> listItems = homePagePOM.fetchAllItemsForSale();

        // making sure that they all in Euro, in other words, checking for "€";
        for(WebElement item : listItems) {
            Assert.assertTrue(item.getText().contains("€"));
        }

        Thread.sleep(5000);
    }
}

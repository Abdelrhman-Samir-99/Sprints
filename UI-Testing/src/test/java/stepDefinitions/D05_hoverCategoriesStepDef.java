package stepDefinitions;

import Pages.P03_homePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {
    P03_homePage homePagePOM = new P03_homePage();

    @When("user hover category and select subcategory")
    public void user_hover_and_select_category() throws InterruptedException {
        Actions action = new Actions(Hooks.driver);

        WebElement computers = homePagePOM.getCategoryByName("computers");

        action.moveToElement(computers).perform();
        Thread.sleep(1000);
        // Picking a subcategory from computer category.
        WebElement subCategory = homePagePOM.selectSubCategory("desktops");

        subCategory.click();
        Thread.sleep(3000);

        String subCategoryName = homePagePOM.getPageTitle().getText().toLowerCase().trim();
        Assert.assertEquals(subCategoryName, "desktops");
    }
}

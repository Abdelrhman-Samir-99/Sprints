package stepDefinitions;

import Pages.P03_homePage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class D06_homeSlidersStepDef {
    @Given("^user clicked on a slide named \"(.*)\"$")
    public void firstSlider(String slideName) {
        WebElement slider = null;
        Integer slideNumber = -1;
        String URL = "";

        switch (slideName) {
            case "Nokia":
                slideNumber = 1;
                URL = "https://demo.nopcommerce.com/";
                break;
            case "iPhone":
                slideNumber = 2;
                URL = "https://demo.nopcommerce.com/";
                break;
        }

        // TODO: when you click on any slide, you redirect to the same page!
        slider = new P03_homePage().getSlider(slideNumber.toString());
        slider.click();
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), URL);
    }
}

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {

    private void validateRedirect(String URL) {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), URL);
    }

    @Given("user clicks on Facebook icon")
    public void goToFacebook() {
        // Clicking on the Facebook icon
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();

        // getting current opened tabs
        ArrayList <String> currentTabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        // Switching to facebook (can be ignored, and just check the URL)
        Hooks.driver.switchTo().window(currentTabs.get(1));

        validateRedirect("https://www.facebook.com/nopCommerce");
    }

    @Given("user clicks on Twitter icon")
    public void goToTwitter() {
        // Clicking on the Facebook icon
        Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]")).click();

        // getting current opened tabs
        ArrayList <String> currentTabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        // Switching to facebook (can be ignored, and just check the URL)
        Hooks.driver.switchTo().window(currentTabs.get(1));

        validateRedirect("https://twitter.com/nopCommerce");
    }

    // TODO: Problem with this part, asking me to download a file.
    // @Given("user clicks on RSS icon")
    public void goToRSS() {
        // Clicking on the Facebook icon
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();

        // getting current opened tabs
        ArrayList <String> currentTabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        // Switching to facebook (can be ignored, and just check the URL)
        Hooks.driver.switchTo().window(currentTabs.get(1));

        validateRedirect("https://www.facebook.com/nopCommerce");
    }

    @Given("user clicks on YouTube icon")
    public void goToYouTube() {
        // Clicking on the Facebook icon
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]")).click();

        // getting current opened tabs
        ArrayList <String> currentTabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        // Switching to facebook (can be ignored, and just check the URL)
        Hooks.driver.switchTo().window(currentTabs.get(1));

        validateRedirect("https://www.youtube.com/user/nopCommerce");
    }
}

package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver = null;

    @Before
    public static void openBrowser() {
        // Establishing the bridge
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abdul\\Desktop\\Work\\Projects\\UI-Testing\\src\\main\\resources\\WebDrivers\\chromedriver.exe");
        // Initializing the driver (WebDriver is an interface)
        driver = new ChromeDriver();

        // Characterising our window
        driver.manage().window().maximize();
        // Implicit wait, so we make sure that all element present in the DOM before we call them.
        // i.e. prevent "NoSuchElement" exception! (when you try to call an item before it loads in the DOM!)
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        // Navigation to a URL
        driver.get("https://demo.nopcommerce.com/");
    }

    @After
    public static void quitBrowser() throws InterruptedException {
        Thread.sleep(2000); // so it doesn't close immediately.
        driver.quit();
    }
}

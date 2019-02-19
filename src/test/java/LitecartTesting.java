import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LitecartTesting {

    static WebDriver driver;

    //Initialization Chrome and login in litecart
    @Before
    public void driver_init() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.get("http://localhost/litecart/admin");
            System.out.println("Initialization success");
        } catch (Exception e) {
            System.out.println("Can't initialization!");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

    }

    //Verifying that element is present on the page
    boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    //Test clicks all elements in side bar and verify that <h1> is  present
    @Test
    public void checkAppearence() {

        driver.findElement(By.partialLinkText("Appearence")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-template")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-logotype")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Catalog")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-catalog")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-product_groups")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-option_groups")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-manufacturers")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-suppliers")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-delivery_statuses")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-sold_out_statuses")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-quantity_units")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-csv")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Countries")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Currencies")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Customers")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-customers")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-csv")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-newsletter")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Geo Zones")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Languages")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-languages")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-storage_encoding")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Modules")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-jobs")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-customer")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-shipping")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-payment")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-order_total")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-order_success")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-order_action")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Orders")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-orders")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-order_statuses")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Pages")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Reports")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-monthly_sales")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-most_sold_products")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-most_shopping_customers")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Settings")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-store_info")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-defaults")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-general")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-listings")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-images")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-checkout")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-advanced")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-security")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Slides")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Tax")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-tax_classes")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-tax_rates")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Translations")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-search")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-scan")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-csv")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("Users")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.partialLinkText("vQmods")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.id("doc-vqmods")).findElement((By.tagName("a"))).click();
        isElementPresent(driver, By.tagName("h1"));

    }
        @After
        public void litecartTesting_cleanup () {
            driver.quit();
        }



}

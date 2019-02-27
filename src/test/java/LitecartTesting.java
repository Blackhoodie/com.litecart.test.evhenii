import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LitecartTesting {

    static WebDriver driver;
    private String url = "http://localhost/litecart/admin";
    private String login = "admin";
    private String password = "admin";

    //Initialization Chrome and login in litecart
    @Before
    public void driver_init() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.get(url);
            System.out.println("Initialization success");
        } catch (Exception e) {
            System.out.println("Can't initialization!");
            return;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
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

        String sidebarPath = "#sidebar ul#box-apps-menu";
        By menuBlock = By.cssSelector(sidebarPath);
        int counterLi = driver.findElement(menuBlock).findElements(By.xpath("./li")).size();

        By selectedItem = By.cssSelector("li.selected");

        for(int menuItem = 1; menuItem < counterLi; menuItem++)
        {
            driver.findElement(menuBlock).findElement(By.xpath("./li[" + menuItem + "]")).click();
            Assert.assertTrue("h1 element not found on the page", isElementPresent(driver, By.tagName("h1")));

            int subMenusize = driver.findElement(menuBlock).findElement(selectedItem).findElements(By.cssSelector("li")).size();
            if (subMenusize > 0)
            {
                for(int subMenuItem = 1; subMenuItem <= subMenusize; subMenuItem++)
                {
                    driver.findElement(selectedItem).findElement(By.cssSelector("li:nth-of-type(" + subMenuItem + ")")).click();
                    Assert.assertTrue("h1 element not found on the page", isElementPresent(driver, By.tagName("h1")));
                }
            }
        }
    }
        @After
        public void litecartTesting_cleanup () {
            driver.quit(); // quit
        }



}

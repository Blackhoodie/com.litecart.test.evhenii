import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsTesting {

    WebDriver driver;
    private String url = "http://localhost/litecart/admin";
    private String login = "admin";
    private String password = "admin";
    private String countriesURL = "http://localhost/litecart/admin/?app=countries&doc=countries";

    @Before
    public void driver_init()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get(url);
        driver.findElement(By.name("username")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); //Change this

    }

    @Test
    public void windowsTesting(){

        driver.get(countriesURL); //Redirect to the "Countries" page
        int listSize;
        By table = By.cssSelector(".dataTable");
        List<WebElement> rows = driver.findElement(table).findElements(By.className("row")); //Find all rows(Countries) on the page
        listSize = rows.size(); // Count of countries

        /*
        Random click on "Add new country"(0) or "Edit random country"(1)
         */
        if(random(2) == 0)
        {
            driver.findElement(By.className("button")).click(); //Click on Add new country "button"
        }else {
            rows.get(random(listSize)).findElement(By.xpath("./td[7]/a")).click(); //Click on Edit random country
        }

        List<WebElement> arrows = driver.findElement(By.id("content")).findElements(By.className("fa-external-link")); //Find all arrow icons on the page
        WebDriverWait wait = new WebDriverWait(driver, 10); //wait
        String originalW = driver.getWindowHandle(); //current window ID
        Set<String> existWs = driver.getWindowHandles(); //  windows IDs

        for(int a = 0; a < arrows.size(); a++) {

            try {
                System.out.println("Click on " + a + " arrow");
                arrows.get(a).click();
                String newW = wait.until(anyWindowOtherThan(existWs));
                driver.switchTo().window(newW);
                driver.close();
                driver.switchTo().window(originalW);
                }


             catch (org.openqa.selenium.NoSuchElementException ex) {
                System.out.println(a + "  arrow icon not found!");
                return;
            }
        }

    }

    public int random(int listSize)
    {
        Random rand = new Random();
        return rand.nextInt(listSize);
    }

    public ExpectedCondition<String> anyWindowOtherThan(Set<String> windows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver input) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(windows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }

    @After
    public void cleanup()
    {
        driver.quit();
    }
}

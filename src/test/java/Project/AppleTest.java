package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AppleTest {

    @Test
    public void testAppleWebsite() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://www.apple.com/");

            // Search for iPhone
            WebElement searchButton = driver.findElement(By.id("globalnav-menubutton-link-search"));
            searchButton.click();

            WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search apple.com']"));
            Actions action = new Actions(driver);
            action.moveToElement(searchInput)
                    .click()
                    .sendKeys("iphone")
                    .sendKeys(Keys.ENTER)
                    .perform();
            Thread.sleep(2000);

            // Verify search result image is displayed
            WebElement searchImage = driver.findElement(By.xpath("//img[@src='https://www.apple.com/autopush/ww/search/modules/iphone/image__cnyoqnzvxxaq_large_2x.jpg?']"));
            Assert.assertTrue("Search image is not displayed", searchImage.isDisplayed());

            // Click on shop link
            WebElement shopLink = driver.findElement(By.xpath("//a[@data-analytics-title='Shop|iPhone']"));
            shopLink.click();

            // Verify shop header is displayed
            WebElement shopHeader = driver.findElement(By.xpath("//h1[@class='rs-shop-header']"));
            Assert.assertTrue("Shop header is not displayed", shopHeader.isDisplayed());

            // Click on buy button
            WebElement buyButton = driver.findElement(By.xpath("//a[@data-autom='IPHONE15PRO_MAIN']"));
            buyButton.click();

            // Verify product page header is displayed
            WebElement productHeader = driver.findElement(By.xpath("//h1[@class='fwl']"));
            Assert.assertTrue("Product header is not displayed", productHeader.isDisplayed());

            // Select iPhone with 6.1-inch display
            WebElement selectIphone = driver.findElement(By.xpath("//span[text()='6.1-inch display']"));
            Actions selectAction = new Actions(driver);
            selectAction.click(selectIphone)
                    .sendKeys(Keys.TAB, Keys.TAB, Keys.RIGHT, Keys.ENTER)
                    .sendKeys(Keys.TAB, Keys.ENTER)
                    .sendKeys(Keys.TAB, Keys.TAB, Keys.RIGHT)
                    .sendKeys(Keys.TAB, Keys.ENTER)
                    .perform();
        } finally {
            driver.quit();
        }
    }
}
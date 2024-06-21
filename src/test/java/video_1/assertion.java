package video_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class assertion {

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.automationexercise.com/");
        WebElement logoElement= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElement.isDisplayed());
        WebElement ProductsElement= driver.findElement(By.xpath("//a[@href='/products']"));
        ProductsElement.click();
        String beklenenurl="https://www.automationexercise.com/products";
        String sonuçurl= driver.getCurrentUrl();
        Assert.assertEquals(beklenenurl,sonuçurl);
        WebElement aramacubugu= driver.findElement(By.xpath("//input[@id='search_product']"));
        aramacubugu.sendKeys("Fancy Green Top");
        WebElement searchbutton= driver.findElement(By.xpath("//button[@id='submit_search']"));
        searchbutton.click();
        WebElement productsElement= driver.findElement(By.xpath("//h2[text()='Searched Products']"));
        Assert.assertTrue(productsElement.isDisplayed());
        driver.close();










    }

}

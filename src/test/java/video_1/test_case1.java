package video_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class test_case1 {



    @Test
    public void test() {


         WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.get("http://automationexercise.com");


        WebElement logo= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());
        WebElement product= driver.findElement(By.xpath("//h2[text()='Rs. 500']"));
        WebElement ekleme= driver.findElement(By.xpath("//a[@data-product-id='1']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(product).click(ekleme).perform();
        WebElement viewproduct= driver.findElement(By.xpath("//a[text()='View Product']"));
        viewproduct.click();
        String beklenenurl= "https://automationexercise.com/product_details/1";
        String sonuçurl= driver.getCurrentUrl();
        Assert.assertEquals(beklenenurl,sonuçurl);
        WebElement ordernumber= driver.findElement(By.xpath("//input[@type='number']"));
        actions.click(ordernumber)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("4")
                .perform();
        WebElement addbutton= driver.findElement(By.xpath("//button[@type='button']"));
        addbutton.click();
        WebElement clickbutton = driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
        clickbutton.click();
        WebElement viewcart= driver.findElement(By.xpath("//a[@href='/view_cart']"));
        viewcart.click();
        WebElement sayıkontrol= driver.findElement(By.xpath("//button[text()='5']"));
        Assert.assertTrue(sayıkontrol.isDisplayed());
        //Assert.assertEquals("Order number is not 4", "4", ordernumber.getText());
        driver.close();

        //WebElement clickbutton = driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
        //clickbutton.click();














        //WebElement ekleme= driver.findElement(By.xpath("//a[href='/product_details/1']"));


     }

}

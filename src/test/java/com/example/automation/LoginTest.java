package com.example.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginTest {
@Test
    public  static  void LoginForm() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://store.khanglobalstudies.com");
    driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("login_form_phone")).sendKeys("9555098765");
    Thread.sleep(2000);
    driver.findElement(By.id("login_form_password")).sendKeys("12343210");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(4000);
    String actualUserName = driver.findElement(By.xpath("//div/button[@type='button']")).getText();
    // String expecteUserName = "Rajnish";
    // Assert.assertEquals(actualUserName,expecteUserName,"actual user Name " + actualUserName + " did not match  expected user name " + expecteUserName );
    Thread.sleep(4000);
    // add first product to the cart
    // First product
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // --- First Product ---
    driver.findElement(By.xpath("//h3[contains(text(),'KGS Practice Notebooks Set of 3 | 300 Pages | Plai')]")).click();

    // Wait for quantity input and set value
    WebElement qtyInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='1']")));
    qtyInput.clear();
    qtyInput.sendKeys("5");

    // Click Add to Cart
    WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[contains(@class,'flex items-center justify-center gap-2')]")));
    addToCartBtn.click();

    // Go back to product list
    driver.navigate().back();
    Thread.sleep(4000);
    // --- Second Product ---
    WebElement secondProduct = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@href,'/products/pocket-gk-history-polity-geography-map-economy-student-atlas-physics-chemistry-and-biology-books-by-khan-sir-hindi-edition')]//img[contains(@alt,'book')]")
    ));
    secondProduct.click();

    // Wait for quantity input on second product page
    WebElement otherQtyInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='1']")));
    otherQtyInput.clear();
    otherQtyInput.sendKeys("4");
    Thread.sleep(4000);
    // Click Add to Cart again
    WebElement otherAddToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[contains(@class,'flex items-center justify-center gap-2')]")));
    otherAddToCartBtn.click();
        
    }

}
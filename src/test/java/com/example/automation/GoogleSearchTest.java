package com.example.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;  // <-- Import Duration

public class GoogleSearchTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(); // Ensure ChromeDriver is in PATH
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
public void testGoogleSearch() throws InterruptedException {
    driver.get("https://www.khanglobalstudies.com/");
    Thread.sleep(5000);  // load page
    assert driver.getTitle().contains("Google");

    // keep browser open until you press Enter
    System.out.println("Test finished. Press Enter to close browser...");
    new java.util.Scanner(System.in).nextLine();
}


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            // driver.quit();
        }
    }
}

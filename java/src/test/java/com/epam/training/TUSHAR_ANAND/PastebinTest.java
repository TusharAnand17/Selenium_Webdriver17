package com.epam.training.TUSHAR_ANAND;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PastebinTest {
    private WebDriver driver;
    private PastebinPage pastebinPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pastebinPage = new PastebinPage(driver);
        driver.get("https://pastebin.com/");
    }

    @RepeatedTest(5)
    public void testCreateNewPaste() {
        pastebinPage.enterCode("Hello from WebDriver");
        pastebinPage.selectExpiration();
        pastebinPage.enterTitle("helloweb");
        pastebinPage.submitPaste();

        // Assert that the paste URL is valid and contains "pastebin.com"
        assertTrue(pastebinPage.getCurrentUrl().contains("pastebin.com"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


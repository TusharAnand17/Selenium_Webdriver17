package com.epam.training.student_tushar_anand;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PastebinPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By codeField = By.xpath("//*[@id=\"postform-text\"]");
    private By expirationDropdown = By.id("select2-postform-expiration-container");
    private By tenMinutesOption = By.xpath("//li[text()='10 Minutes']");
    private By titleField = By.xpath("//*[@id=\"postform-name\"]");
    private By submitButton = By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button");

    public PastebinPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterCode(String code) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(codeField)).sendKeys(code);
    }

    public void selectExpiration() {
        wait.until(ExpectedConditions.elementToBeClickable(expirationDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tenMinutesOption)).click();
    }

    public void enterTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
    }

    public void submitPaste() {
        driver.findElement(submitButton).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}


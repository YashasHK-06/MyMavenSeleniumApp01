package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        options.setBinary("/usr/bin/firefox");

        WebDriver driver = new FirefoxDriver(options);

        try {

            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            sleep(3000);

            if (driver.getCurrentUrl().contains("inventory")) {
                System.out.println("SauceDemo Login Successful");
            } else {
                System.out.println("SauceDemo Login Failed");
            }

            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            sleep(3000);

            if (driver.getCurrentUrl().contains("logged-in-successfully")) {
                System.out.println("PracticeTestAutomation Login Successful");
            } else {
                System.out.println("PracticeTestAutomation Login Failed");
            }

            driver.get("https://automationexercise.com/login");
            driver.findElement(By.name("email")).sendKeys("yudhveerdirghayu@gmail.com");
            driver.findElement(By.name("password")).sendKeys("Jaihanuman@1");
            driver.findElement(By.xpath("//button[text()='Login']")).click();

            sleep(3000);

            if (driver.getPageSource().contains("Logout")) {
                System.out.println("AutomationExercise Login Successful");
            } else {
                System.out.println("AutomationExercise Login Failed");
            }

        } finally {
            driver.quit();
        }
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

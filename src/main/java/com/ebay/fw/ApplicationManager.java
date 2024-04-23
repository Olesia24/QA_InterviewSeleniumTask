package com.ebay.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
    static WebDriver driver;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    String browser;
    SelectHelper select;
    ItemHelper item;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            logger.info("Test starts in Chrome browser");
        }
        if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            logger.info("Test starts in Mozilla browser");
        }
        if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
            logger.info("Test starts in Edge browser");
        }
        if(browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
            logger.info("Test starts in Safari browser");
        }
        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://www.ebay.de");

        logger.info("Current URL --> "+ driver.getCurrentUrl());

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        select = new SelectHelper(driver);
        item =new ItemHelper(driver);
    }

    public SelectHelper getSelect() {
        return select;
    }

    public ItemHelper getItem() {
        return item;
    }

    public static void stop() {
        driver.quit();
    }
}

package com.ebay.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper {
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public String getSecondItemName(String secondItem) {
        return driver.findElement(By.cssSelector(".s-item:nth-child(" + secondItem+ ") h3")).getText();
    }

    public void enterItemNameToSearchBar(String itemName) {
        type(By.id("gh-ac"),itemName);
        click(By.id("gh-btn"));
    }

    public String getFirstItemName(String firstItemName) {
        return driver.findElement(By.cssSelector(".s-item__dsa-on-bottom.s-item__pl-on-bottom:nth-child(" + firstItemName + ") div:nth-child(2)>a>div>span")).getText();
    }
}

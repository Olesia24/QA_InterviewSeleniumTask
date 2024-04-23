package com.ebay.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectHelper extends BaseHelper {

    public SelectHelper(WebDriver driver) {
        super(driver);
    }

    public void selectDepartment(String department) {
        click(By.cssSelector(".vl-flyout-nav__js-tab:nth-child("+ department+")"));
    }

    public void selectSection(String section) {
        click(By.cssSelector(".b-visualnav__tile:nth-child("+ section + ")"));
    }

    public void selectBrand(String brand) {
        click(By.xpath("//div[.='" + brand +  "']"));
    }
}

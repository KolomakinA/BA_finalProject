package com.tests.ui.dispatcherDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kolom on 16.03.2017.
 */
public class MetDD {
    private WebDriver driver;
    public MetDD (WebDriver driver){this.driver=driver;}
    public WebElement findElement(String s, WebDriver driver){
        return  driver.findElement(By.xpath(s));
    }

    public void createNewOrder (WebDriver driver, LocDD dispatcherLocators){
        findElement(dispatcherLocators.dashboardNewOrder,driver).click();
    }
}

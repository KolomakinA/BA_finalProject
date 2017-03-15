package com.tests.ui.orderDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kolom on 16.03.2017.
 */
public class MetOD {
    private WebDriver driver;
    public MetOD (WebDriver driver){this.driver=driver;}
    public WebElement findElement(String s){return  driver.findElement(By.xpath(s));}
}

package com.tests.ui.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kolom on 16.03.2017.
 */
public class MetL {
    private WebDriver driver;
    public MetL (WebDriver driver){this.driver=driver;}
    public WebElement findElement(String s){return  driver.findElement(By.xpath(s));}
}

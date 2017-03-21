package com.tests.ui.login;

import com.common.CP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;

/**
 * Created by kolom on 16.03.2017.
 */
public class MetL {
    private WebDriver driver;
    private LocL loginLocators;
    public MetL (WebDriver driver){
        this.driver=driver;
        this.loginLocators=new LocL();
    }

    public WebElement findElement(String s, WebDriver driver){
        return  driver.findElement(By.xpath(s));
    }

    public void switchToEn(WebDriver driver){
        WebElement en = findElement(loginLocators.loginEnSwitch, driver);
        en.click();
    }

    public void performLogin(WebDriver driver, LocL loginLocators){
        driver.findElement(By.xpath(loginLocators.loginEmailField)).sendKeys(CP.NAME);
        driver.findElement(By.xpath(loginLocators.loginPassField)).sendKeys(CP.PASS);
        driver.findElement(By.xpath(loginLocators.loginSubmitButt)).click();
    }

    public void performNegativeLogin(WebDriver driver, LocL loginLocators, ArrayList<String> badEmails){
        for (String s : badEmails) {
            driver.findElement(By.xpath(loginLocators.loginEmailField)).clear();
            driver.findElement(By.xpath(loginLocators.loginEmailField)).sendKeys(s);
            driver.findElement(By.xpath(loginLocators.loginSubmitButt)).click();
            synchronized (driver){
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String a = driver.findElement(By.xpath(loginLocators.loginEmailField)).getAttribute("value");
            if (a.equalsIgnoreCase(s)) System.out.println("Seems ok: " + s);
            else System.out.println("Error: " + s);

        }

    }

}

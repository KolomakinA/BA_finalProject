package com.tests.ui.createOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

/**
 * Created by kolom on 16.03.2017.
 */
public class MetCO {
    private WebDriver driver;
    public MetCO (WebDriver driver){this.driver=driver;}
    public WebElement findElement(String s, WebDriver driver){return  driver.findElement(By.xpath(s));}

    public void submit(WebDriver driver, LocCO createOrderLocators){
        findElement(createOrderLocators.newOrderSubmitBtn,driver).click();
    }

    public boolean fillInPackingList(WebDriver driver, LocCO createOrderLocators, String packingList){
        WebElement packingListField = findElement(createOrderLocators.newOrderPackingList,driver);
        packingListField.sendKeys(packingList);
        if (packingListField.getText().equals(packingList)) return true;
        else return false;
    }

    public boolean fillInOrderDate(WebDriver driver, LocCO createOrderLocators, String orderDate){
        WebElement orderDateField = findElement(createOrderLocators.newOrderDate,driver);
        orderDateField.sendKeys(orderDate);
        if (orderDateField.getText().equals(orderDate)) return true;
        else return false;
    }

    public void fillInPickupWindow (WebDriver driver, LocCO createOrderLocators, String pickupWindow){
        WebElement pickupWindowField = findElement(createOrderLocators.newOrderPickupWindowSelect,driver);
        pickupWindowField.sendKeys(pickupWindow);
    }
}

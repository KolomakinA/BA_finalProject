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
        if (packingListField.getAttribute("value").equals(packingList)) return true;
        else return false;
    }

    public boolean fillInOrderDate(WebDriver driver, LocCO createOrderLocators, String orderDate){
        WebElement orderDateField = findElement(createOrderLocators.newOrderDate,driver);
        orderDateField.sendKeys(orderDate);
        if (orderDateField.getAttribute("value").equals(orderDate)) return true;
        else return false;
    }

    public void fillInPickupWindow (WebDriver driver, LocCO createOrderLocators, String pickupWindow){
        WebElement pickupWindowField = findElement(createOrderLocators.newOrderPickupWindowSelect,driver);
        pickupWindowField.sendKeys(pickupWindow);
    }

    public boolean fillInRcpName (WebDriver driver, LocCO createOrderLocators, String rcpNAme){
        WebElement rcpNameField = findElement(createOrderLocators.newOrderRCPName,driver);
        rcpNameField.sendKeys(rcpNAme);
        if (rcpNameField.getAttribute("value").equals(rcpNAme)) return true;
        else return false;
    }

    public boolean fillInRcpMobile (WebDriver driver, LocCO createOrderLocators, String rcpMobile){
        WebElement rcpMobileField = findElement(createOrderLocators.newOrderRCPMobile,driver);
        rcpMobileField.sendKeys(rcpMobile);
        if (rcpMobileField.getAttribute("value").equals(rcpMobile)) return true;
        else return false;
    }

    public boolean fillInDeliveryPoint (WebDriver driver, LocCO createOrderLocators, String deliveryPoint){
        WebElement deliveryPointField = findElement(createOrderLocators.newOrderDeliveryPoint,driver);
        deliveryPointField.sendKeys(deliveryPoint);
        if (deliveryPointField.getAttribute("value").equals(deliveryPoint)) return true;
        else return false;
    }

    public void fillInDeliveryTimeSelect (WebDriver driver, LocCO createOrderLocators, String deliveryTime){
        WebElement deliveryTimeField = findElement(createOrderLocators.newOrderDeliveryTimeSelect,driver);
        deliveryTimeField.sendKeys(deliveryTime);
    }
}

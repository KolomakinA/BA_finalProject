package com.tests.ui.createOrder;

/**
 * Created by kolom on 16.03.2017.
 */
public class LocCO {
    public String dashboardNewOrder = "//*[@id=\"app\"]/div/div[3]/button";
    public String dashboardFirstOrder = "//*[@id=\"app\"]/div/div[3]/div[2]/table/tbody[1]/tr[1]";
    public String newOrderHeader = "//div[@class='page-header']/h1";
    public String newOrderSubmitBtn = "//button[@type='submit']";
    public String newOrderPackingList = "//textarea[@name='packingList']";
    public String newOrderDate = "//*[@id=\"app\"]/div/div[3]/form/div[1]/div[4]/div/div[2]/input";
    public String newOrderPickupWindowSelect = "//select[@name='expectedPickUpTimeWindow']";
    public String newOrderRCPName = "//input[@name='firstName']";
    public String newOrderRCPMobile = "//input[@name='mobile']";
    public String newOrderDeliveryPoint = "//input[@name='deliveryPoint']";
    public String newOrderDeliveryTimeSelect= "//div[@class='form-group']/select[@id='formHorizontalEmail']";
}

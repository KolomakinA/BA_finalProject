package com.tests.suites.UI;

import com.common.CP;
import com.tests.ui.createOrder.LocCO;
import com.tests.ui.createOrder.MetCO;
import com.tests.ui.dispatcherDashboard.LocDD;
import com.tests.ui.dispatcherDashboard.MetDD;
import com.tests.ui.login.LocL;
import com.tests.ui.login.MetL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by kolom on 16.03.2017.
 */
public class SmokeUI {
    private LocCO createOrdersLocators;
    private LocDD dispatcherDashboardLocators;
    private LocL loginLocators;
    private MetCO createOrdersMethods;
    private MetDD dispatcherDashboardMethods;
    private MetL loginMethods;
    private WebDriver driver;

    @BeforeSuite
    private void initialize(){
        createOrdersLocators = new LocCO();
        dispatcherDashboardLocators = new LocDD();
        loginLocators = new LocL();

        createOrdersMethods = new MetCO(driver);
        dispatcherDashboardMethods = new MetDD(driver);
        loginMethods = new MetL(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        synchronized (driver) {
            driver.wait(1);
        }
        driver.quit();
    }

    public void getLoginPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String uiURL = "#/login";
        driver.get(CP.URL + uiURL);
    }

    //-----------------------------------------------------Here we go

    @Test
    public void loginComparingTitle(){
        getLoginPage();
        Assert.assertEquals(driver.getTitle(),loginLocators.loginPageTitle);//checking page title
    }

    @Test
    public void loginComparingEmailFieldHintAr(){
        getLoginPage();
        Assert.assertEquals(loginMethods.findElement(loginLocators.loginEmailHint,driver).getText(),"الأيميل");//checking the default language
    }

    @Test
    public void loginComparingPasswordFieldHintAr() {
        getLoginPage();
        Assert.assertEquals(loginMethods.findElement(loginLocators.loginPassHint,driver).getText(),"كلمة المرور");
    }

    @Test
    public void loginCheckingThatEnSwitchDisplayed () {
        getLoginPage();
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginEnSwitch, driver).isDisplayed());
    }

    @Test
    public void loginCheckingThatEmailFieldIsDisplayed(){
        getLoginPage();
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginEmailField, driver).isDisplayed());
    }

    @Test
    public void loginCheckingThatPasswordFieldIsDisplayed(){
        getLoginPage();
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginPassField, driver).isDisplayed());
    }

    @Test
    public void loginCheckingThatSubmitButtonIsDisplayed(){
        getLoginPage();
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginSubmitButt, driver).isDisplayed());
    }

    @Test
    public void loginSwitchToEn(){
        getLoginPage();
        loginMethods.switchToEn(driver);
        Assert.assertEquals(loginMethods.findElement(loginLocators.loginEmailHint,driver).getText(),"Email");//switch to En was successful
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginEmailField,driver).isDisplayed());
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginPassField,driver).isDisplayed());
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginSubmitButt,driver).isDisplayed());
        Assert.assertEquals(loginMethods.findElement(loginLocators.loginSubmitButt,driver).getText(),"Sign in");
    }

    @Test
    public void loginPerformLoginEn(){
        getLoginPage();
        loginMethods.switchToEn(driver);
        loginMethods.performLogin(driver,loginLocators);
        Assert.assertEquals(dispatcherDashboardMethods.
                findElement(dispatcherDashboardLocators.dashboardCurrentOrders,driver).getText(),
                "Current Orders");
    }

    @Test
    public void loginPerformLoginAr(){
        getLoginPage();
        loginMethods.performLogin(driver,loginLocators);
        Assert.assertEquals(dispatcherDashboardMethods.
                findElement(dispatcherDashboardLocators.dashboardCurrentOrders,driver).getText(),
                "الطلبات الحالية");
    }

    @Test
    public void dispDashboardEnIsDisplayed(){
        getLoginPage();
        loginMethods.switchToEn(driver);
        loginMethods.performLogin(driver,loginLocators);
        Assert.assertTrue(dispatcherDashboardMethods.findElement(dispatcherDashboardLocators.dashboardEn,driver).isDisplayed());
    }

    @Test
    public void dispDashboardArIsDisplayed(){
        getLoginPage();
        loginMethods.switchToEn(driver);
        loginMethods.performLogin(driver,loginLocators);
        Assert.assertTrue(dispatcherDashboardMethods.findElement(dispatcherDashboardLocators.dashboardAr,driver).isDisplayed());
    }

    @Test
    public void dispDashboardLogoutIsDisplayed(){
        getLoginPage();
        loginMethods.switchToEn(driver);
        loginMethods.performLogin(driver,loginLocators);
        Assert.assertTrue(dispatcherDashboardMethods.findElement(dispatcherDashboardLocators.dashboardLogout,driver).isDisplayed());
    }

    @Test
    public void dispDashboardCreateOrderIsDisplayed(){
        getLoginPage();
        loginMethods.switchToEn(driver);
        loginMethods.performLogin(driver,loginLocators);
        Assert.assertTrue(dispatcherDashboardMethods.findElement(dispatcherDashboardLocators.dashboardNewOrder,driver).isDisplayed());
    }

    @Test
    public void dispDashboardCreateOrderTextIsCorrect(){
        getLoginPage();
        loginMethods.switchToEn(driver);
        loginMethods.performLogin(driver,loginLocators);
        Assert.assertEquals(dispatcherDashboardMethods.findElement(dispatcherDashboardLocators.dashboardNewOrder,driver).getText(),"+ Create New Order");
    }

    @Test
    public void createNewOrderPageIsLoaded ()throws InterruptedException{
        getLoginPage();
        loginMethods.switchToEn(driver);
        loginMethods.performLogin(driver,loginLocators);
        Thread.sleep(10000);
        dispatcherDashboardMethods.createNewOrder(driver,dispatcherDashboardLocators);
        Thread.sleep(2000);
        Assert.assertEquals(createOrdersMethods.
                findElement(createOrdersLocators.newOrderHeader,driver).getText(),"New Order");
    }

    @Test
    public void createNewOrder() throws InterruptedException {
        getLoginPage();
        loginMethods.switchToEn(driver);
        loginMethods.performLogin(driver,loginLocators);
        Thread.sleep(5000);
        dispatcherDashboardMethods.createNewOrder(driver,dispatcherDashboardLocators);
        Thread.sleep(2000);
        if (createOrdersMethods.fillInPackingList
                (driver,createOrdersLocators,"My new package"));
        else System.out.println("Error filling in Packing list");
        createOrdersMethods.fillInOrderDate
                (driver,createOrdersLocators,"03/31/17");
        createOrdersMethods.findElement(createOrdersLocators.newOrderDate,driver).clear();
        if (createOrdersMethods.fillInOrderDate
                (driver,createOrdersLocators,"03/31/17"));
        Thread.sleep(5000);

    }


}

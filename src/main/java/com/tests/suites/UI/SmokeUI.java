package com.tests.suites.UI;

import com.common.CP;
import com.tests.ui.createOrder.LocCO;
import com.tests.ui.createOrder.MetCO;
import com.tests.ui.dispatcherDashboard.LocDD;
import com.tests.ui.dispatcherDashboard.MetDD;
import com.tests.ui.login.LocL;
import com.tests.ui.login.MetL;
import com.tests.ui.orderDetails.LocOD;
import com.tests.ui.orderDetails.MetOD;
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
    private LocOD orderDetailsLocators;
    private MetCO createOrdersMethods;
    private MetDD dispatcherDashboardMethods;
    private MetL loginMethods;
    private MetOD orderDetailsMethods;
    private WebDriver driver;

    @BeforeSuite
    private void initialize(){
        createOrdersLocators = new LocCO();
        dispatcherDashboardLocators = new LocDD();
        loginLocators = new LocL();
        orderDetailsLocators = new LocOD();

        createOrdersMethods = new MetCO(driver);
        dispatcherDashboardMethods = new MetDD(driver);
        loginMethods = new MetL(driver);
        orderDetailsMethods = new MetOD(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        synchronized (driver) {
            driver.wait(5000);
        }
        driver.quit();
    }

    public void getloginPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String uiURL = "#/login";
        driver.get(CP.URL + uiURL);
    }


    @Test
    public void loginPageIsLoadedCorrectly(){
        getloginPage();

        Assert.assertEquals(driver.getTitle(),loginLocators.loginPageTitle);//checking page title
        Assert.assertEquals(loginMethods.findElement(loginLocators.loginEmailHint,driver).getText(),"الأيميل");//checking the default language
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginEnSwitch,driver).isDisplayed());//checking that En button is present
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginEmailField,driver).isDisplayed());
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginPassField,driver).isDisplayed());
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginSubmitButt,driver).isDisplayed());
    }

    @Test
    public void loginSwitchToEn(){
        getloginPage();
        loginMethods.switchToEn(driver);
        Assert.assertEquals(loginMethods.findElement(loginLocators.loginEmailHint,driver).getText(),"Email");//switch to En was successful
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginEmailField,driver).isDisplayed());
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginPassField,driver).isDisplayed());
        Assert.assertTrue(loginMethods.findElement(loginLocators.loginSubmitButt,driver).isDisplayed());
        Assert.assertEquals(loginMethods.findElement(loginLocators.loginSubmitButt,driver).getText(),"Sign in");
    }

    @Test
    public void loginPerformloginEn(){
        getloginPage();
        loginMethods.switchToEn(driver);
        loginMethods.performLogin(driver,loginLocators);
        Assert.assertEquals(dispatcherDashboardMethods.
                findElement(dispatcherDashboardLocators.dashboardCurrentOrders,driver).getText(),
                "Current Orders");
    }

    @Test
    public void loginPerformloginAr(){
        getloginPage();
        loginMethods.performLogin(driver,loginLocators);
        Assert.assertEquals(dispatcherDashboardMethods.
                findElement(dispatcherDashboardLocators.dashboardCurrentOrders,driver).getText(),
                "الطلبات الحالية");
    }


}

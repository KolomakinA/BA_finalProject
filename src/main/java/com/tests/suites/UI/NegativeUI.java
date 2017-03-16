package com.tests.suites.UI;

import com.common.CP;
import com.common.Utils;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by kolom on 16.03.2017.
 */
public class NegativeUI {
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
        //driver.quit();
    }

    public void getLoginPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String uiURL = "#/login";
        driver.get(CP.URL + uiURL);
    }

    @Test
    public void negativeLogin() throws IOException {
        ArrayList<String> badStrings;
        Utils u = new Utils();
        badStrings = u.readFile("resources\\NegativeStrings\\strings.txt");
        getLoginPage();
        loginMethods.switchToEn(driver);
        loginMethods.performNegativeLogin(driver,loginLocators,badStrings);
    }
}

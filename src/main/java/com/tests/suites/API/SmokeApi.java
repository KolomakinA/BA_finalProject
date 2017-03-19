package com.tests.suites.API;

import com.common.CP;
import com.common.Utils;
import com.tests.api.CreateOrder;
import com.tests.api.SignIn;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.Timestamp;


/**
 * Created by kolom on 10.03.2017.
 */
public class SmokeApi {
//    Get get;
//    Post post;
//    Utils utils;
//
//    @BeforeSuite
//    public void heatUp(){
//        System.out.println(CP.URL);
//        System.out.println(CP.NAME);
//        System.out.println(CP.PASS);
//        get = new Get();
//        post = new Post();
//        utils = new Utils();
//    }
//
//    @AfterSuite
//    public void tearDown(){
//
//    }

//    @Test
//    public void loginResourceIsAvailable(){
//        String restUrl = "api/Dispatchers/login";
//        String jsonBody = "";
//        try {
//            jsonBody = utils.readFile("resources\\JSON_templates\\api\\logIn.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        jsonBody.replace("%NAME%",CP.NAME);
//        jsonBody.replace("%PASS%",CP.PASS);
//        try {
//            System.out.println(post.httpPost(CP.URL + restUrl,jsonBody));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
    private SignIn signIn;
    private CreateOrder createOrder;

    @BeforeSuite
    public void prepare(){
        signIn = new SignIn();
        createOrder = new CreateOrder();
    }

    @Test
    public void logInWrongPass(){
        String result = signIn.signIn(CP.NAME,"1234657");
        Assert.assertEquals(result, "Http code 401 : Unauthorized");
    }

    @Test
    public void logInWrongMail(){
        String result = signIn.signIn("test@eample.com",CP.PASS);
        Assert.assertEquals(result, "Http code 401 : Unauthorized");
    }

    @Test
    public void logIn(){
        String result = signIn.signIn(CP.NAME,CP.PASS);
        Assert.assertEquals(result, "Login successful");
    }

    @Test
    public void userRole(){
        String result = signIn.signIn(CP.NAME,CP.PASS);
        Assert.assertEquals(CP.role, "dispatcher");
    }

    @Test
    public void createOrder(){
        signIn.signIn(CP.NAME,CP.PASS);
        String result = createOrder.createOrder(CP.AUTHTOKEN,CP.userId);
        Assert.assertEquals(result, "Order created successfully");
    }
}
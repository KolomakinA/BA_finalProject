package com.tests.suites.API;

import com.common.CP;
import com.common.Utils;
import com.common.http.Get;
import com.common.http.Post;
import com.tests.api.SignIn;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;


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
    SignIn signIn;
    @BeforeSuite
    public void prepare(){
        signIn = new SignIn();
    }

    @Test
    public void logIn(){
        signIn.signIn();
    }
}
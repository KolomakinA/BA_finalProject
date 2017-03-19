package com.tests.api;

import com.common.CP;
import com.common.Utils;
import com.common.http.Post;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by kolom on 10.03.2017.
 */
public class SignIn {
    private Utils utils = new Utils();
    private Post post = new Post();

    public void signIn(){
        String json = "";
        try {
            json = utils.readFileStr("resources\\JSON_templates\\api\\logIn.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        json = json.replace("%NAME%", CP.NAME);
        json = json.replace("%PASS%", CP.PASS);

        String resURI = "api/Dispatchers/login";
        String response = null;
        try {
            response = post.httpPost(CP.APIURL + resURI, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jo = null;

        if (response.equals("Http code 401 : Unauthorized")){
            System.out.println("Http code 401 : Unauthorized");
            return;
        }else {
            jo = new JSONObject(response);//saving to a json object the result of our post request
        }

//        if (jo.opt("error") != null) {//verification that login was successful
//            System.out.println(jo.getJSONObject("error").getString("message"));
//        } else {
            CP.AUTHTOKEN = jo.getString("id");
            CP.ttl = jo.getString("ttl");
            CP.created = jo.getString("created");
            CP.userId = jo.getString("userId");
            CP.language = jo.getString("language");
            CP.role = jo.getString("role");
            CP.lastLogin = jo.getString("lastLogin");
//        }

    }


}

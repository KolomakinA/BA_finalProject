package com.tests.api;

import com.common.CP;
import com.common.Utils;
import com.common.http.Get;
import com.common.http.Post;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by kolom on 10.03.2017.
 */
public class CreateOrder {
    private Utils utils = new Utils();
    private Post post = new Post();

    public String createOrder(String authToken, String uID){

        String json = "";
        try {
            json = utils.readFileStr("resources\\JSON_templates\\api\\createOrder.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        long ct = utils.getCurrentTime();
        json = json.replace("%deliveryTime%", String.valueOf(ct + 5000000));
        json = json.replace("%pickUpStartTime%", String.valueOf(ct + 5000000));
        json = json.replace("%pickUpEndTime%", String.valueOf(ct + 5000000));
        json = json.replace("%cashOnDeliveryAmount%", String.valueOf(1000));
        json = json.replace("%orderCreatedTime%", String.valueOf(ct));
        json = json.replace("%pickupPointId%", getPickupPointId(uID,authToken));
        json = json.replace("%rcpName%", "rcpFirstName");
        json = json.replace("%rcpLName%", "rcpLastName");
        json = json.replace("%rcpMobile%", String.valueOf(23456789));

        String resURI = "api/Dispatchers/createOrder?access_token=" + authToken;
        String response = null;
        try {
            response = post.httpPost(CP.APIURL + resURI, json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jo = null;
        if (response != null) {
            jo = new JSONObject(response);//saving to a json object the result of our post request
        } else return "Error: No response received";
        CP.orderID = jo.optJSONObject("result").optJSONObject("recipient").optString("id");
        CP.orderCreatedAt = jo.optJSONObject("result").optJSONObject("recipient").optString("createdAt");
        return "Order created successfully";
    }

    public String getPickupPointId(String uID, String authToken){
        Get get = new Get();
        String resURI = "api/Dispatchers/" + uID + "/pickUpPoints?access_token=" + authToken;
        String response = null;

        try {
            response = get.httpGet(CP.APIURL + resURI);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray ja = null;

        if (response != null) {
            if (response.charAt(0) != '['){
                return "Error: invalid response";
            }else {
                ja = new JSONArray(response);//saving to a json array the result of our get request
            }
        } else return "Error: No response received";
        if (ja.length() == 0) return "Error: no pickup point created";
        for (int i = ja.length()-1; i > 0; i--) {
            if (ja.getJSONObject(i).optString("valid").equals("false"));
            else return ja.getJSONObject(i).getString("id");
        }
        return "Error: there are no valid pickup points";
    }
}

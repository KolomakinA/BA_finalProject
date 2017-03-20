package com.tests.api;

import com.common.CP;
import com.common.Utils;
import com.common.http.Get;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by kolom on 10.03.2017.
 */
public class ViewOrders {
    private Get get = new Get();
    private Utils utils = new Utils();

    public String getLatestNewOrderID (String uID, String authToken){
        String resURI = "api/Dispatchers/" + uID + "/orders?access_token=" + authToken;
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
        if (ja.length() == 0) return "Error: there are no orders yet";
//        for (int i = ja.length()-1; i == 0; i--) {
//            if (ja.getJSONObject(i).optString("orderStatus").equals("new")) {
//                System.out.println(ja.getJSONObject(i).getString("id"));
//                return ja.getJSONObject(i).getString("id");
//            }
//        }
//        return "Error: there are no orders in status \"new\"";
        return ja.getJSONObject(ja.length()-1).getString("id");
    }

    public String getOrderDetails(String uID, String authToken, String orderID){
        String resURI = "api/Dispatchers/" + orderID + "/orders/" + uID + "?access_token=" + authToken;
        String response = null;

        try {
            response = get.httpGet(CP.APIURL + resURI);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jo = null;

        if (response != null) {
            jo = new JSONObject(response);//saving to a json array the result of our get request
        } else return "Error: No response received";

        return "Order status: " + jo.getString("orderStatus") + "," +
                "Delivery to: " + jo.getString("deliveryPoint") + "," +
                "Cash amount: " + jo.getString("cashOnDeliveryAmount") + "," +
                "Dispatcher ID: " + jo.getString("dispatcherId") + "," +
                "Order created: " + jo.getString("createdAt") + ".";
    }
}

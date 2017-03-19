package com.common.http;

/**
 * Created by kolom on 09.03.2017.
 */
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.HashMap;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class Post {
    private String url;
    private String jsonBody;
    public String httpPost(String url, String jsonBody) throws IOException {
        try {
            return Request.Post(url).addHeader("Content-Type","application/json").
                    addHeader("Accept","application/json").bodyString(jsonBody, APPLICATION_JSON).
                    execute().returnContent().toString();
        }
        catch (org.apache.http.client.HttpResponseException e){
            return "Http code " + e.getStatusCode() + " : " + e.getMessage();
        }
    }
}

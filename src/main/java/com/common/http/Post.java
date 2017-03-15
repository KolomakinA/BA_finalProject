package com.common.http;

/**
 * Created by kolom on 09.03.2017.
 */
import org.apache.http.client.fluent.Request;

import java.io.IOException;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

/**
 * Created by akolomakin and olazarenko on 07.02.2017.
 */
public class Post {
    private String url;
    private String jsonBody;

    public Post(String url, String jsonBody) {
        this.url=url;
        this.jsonBody=jsonBody;
    }

    public Post() {
    }

    public String httpPost(String url, String jsonBody) throws IOException {
        try {
            return Request.Post(url).addHeader("Content-Type","application/json").
                    bodyString(jsonBody, APPLICATION_JSON).execute().returnContent().toString();
        }
        catch (org.apache.http.client.HttpResponseException e){
            return "Http code " + e.getStatusCode() + " : " + e.getMessage();
        }
    }
    public String httpPost() throws IOException {
        try {
            return Request.Post(url).addHeader("Content-Type","application/json").
                    bodyString(jsonBody, APPLICATION_JSON).execute().returnContent().toString();
        }
        catch (org.apache.http.client.HttpResponseException e){
            return "Http code " + e.getStatusCode() + " : " + e.getMessage();
        }
    }
}

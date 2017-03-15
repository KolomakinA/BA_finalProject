package com.common.http;

/**
 * Created by kolom on 09.03.2017.
 */

import org.apache.http.client.fluent.Request;

import java.io.IOException;

/**
 * Created by akolomakin and olazarenko on 07.02.2017.
 */
public class Get {
    private String url;

    public Get() {
    }

    public Get(String url) {
        this.url=url;
    }

    public String httpGet (String url) throws IOException {
        try {
            return Request.Get(url).execute().returnContent().toString();
        }
        catch (org.apache.http.client.HttpResponseException e){
            return "Http code " + e.getStatusCode() + " : " + e.getMessage();
        }
    }
    public String httpGet () throws IOException {
        try {
            return Request.Get(url).execute().returnContent().toString();
        }
        catch (org.apache.http.client.HttpResponseException e){
            return "Http code " + e.getStatusCode() + " : " + e.getMessage();
        }
    }
}

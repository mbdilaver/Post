package com.company;

import okhttp3.*;

import java.io.IOException;

public class Main {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String url = "http://requestb.in/15vxia61";
        String postBody = "{ 'name' : 'mbd' }";

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON, postBody))
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexcepted code " + response);

        System.out.println(response.body().string());
    }
}

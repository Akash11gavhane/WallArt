package com.example.wallart;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {

    private static Retrofit retrofit = null;
    public static final String API = "xk0t8VsRpgbzOHn0GxRG1m8chZ5Htk6Nzeq6sVvOTkxWtSBXHAByrhbj";

    public static ApiInterface getApiInterface()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }

        return retrofit.create(ApiInterface.class);
    }
}

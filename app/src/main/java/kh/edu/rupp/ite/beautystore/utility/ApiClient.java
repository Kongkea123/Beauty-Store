package kh.edu.rupp.ite.beautystore.utility;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// ApiClient.java
public class ApiClient {
    private static final String BASE_URL = "https://makeup-api.herokuapp.com/api/v1/";

    public static ApiService create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }
}


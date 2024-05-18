package kh.edu.rupp.ite.beautystore.controller;

import androidx.core.util.Consumer;

import java.util.ArrayList;

import kh.edu.rupp.ite.beautystore.model.Product;
import kh.edu.rupp.ite.beautystore.utility.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductController {

    private ApiService apiService;

    public ProductController(ApiService apiService) {
        this.apiService = apiService;
    }

    public void getProducts(String productType, final Consumer<ArrayList<Product>> callback) {
        Call<ArrayList<Product>> call = apiService.getProducts(productType);
        call.enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                if (response.isSuccessful()) {
                    callback.accept(response.body());
                } else {
                    callback.accept(null);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                callback.accept(null);
            }
        });
    }

    public void getProduct(int productId, final Consumer<Product> callback) {
        Call<Product> call = apiService.getProduct(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()) {
                    callback.accept(response.body());
                } else {
                    callback.accept(null);
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                callback.accept(null);
            }
        });
    }
}

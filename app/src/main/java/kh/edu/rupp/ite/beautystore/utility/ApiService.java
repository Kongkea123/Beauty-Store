package kh.edu.rupp.ite.beautystore.utility;

import java.util.ArrayList;

import kh.edu.rupp.ite.beautystore.model.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("products.json/{productId}")
    Call<Product> getProduct(@Path("productId") int productId);

    @GET("products.json")
    Call<ArrayList<Product>> getProducts(@Query("product_type") String productType);
}

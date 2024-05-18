package kh.edu.rupp.ite.beautystore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import kh.edu.rupp.ite.beautystore.model.Product;
import kh.edu.rupp.ite.beautystore.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private final List<Product> productList;
    private OnProductClickListener onProductClickListener;

//    public ProductAdapter(List<Product> productList) {
//        this.productList = productList;
//    }

    public ProductAdapter(List<Product> productList, OnProductClickListener onProductClickListener) {
        this.productList = productList;
        this.onProductClickListener = onProductClickListener;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_make_up_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.tvProductNameMakeUp.setText(product.getName());

        if (product.getPrice() == "0.0") {
            holder.tvProductPriceMakeUp.setText("Free");
        } else {
            holder.tvProductPriceMakeUp.setText((product.getPrice_sign() != null ? product.getPrice_sign() : "$") + product.getPrice());
        }

        if (product.getRating() != null) {
            holder.ratingBar.setRating(product.getRating().floatValue());
        }

        Glide.with(holder.itemView.getContext())
            .load("https:" + product.getApi_featured_image())
            .into(holder.imgProductNameMakeUp);

        holder.linearProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onProductClickListener.onProductClick(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public interface OnProductClickListener {
        void onProductClick(Product product);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvProductNameMakeUp;
        private ImageView imgProductNameMakeUp;
        private TextView tvProductPriceMakeUp;
        private RatingBar ratingBar;
        private LinearLayout linearProduct;

// Set a listener to handle rating changes

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            tvProductNameMakeUp = itemView.findViewById(R.id.tv_product_name_make_up);
            imgProductNameMakeUp = itemView.findViewById(R.id.img_product_make_up);
            tvProductPriceMakeUp = itemView.findViewById(R.id.tv_product_price);
            linearProduct = itemView.findViewById(R.id.linear_product);
        }
    }
}

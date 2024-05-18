package kh.edu.rupp.ite.beautystore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kh.edu.rupp.ite.beautystore.model.SkinCareModel;
import kh.edu.rupp.ite.beautystore.R;

public class SkinCareAdapter extends RecyclerView.Adapter<SkinCareAdapter.ViewHolder> {
    private final List<SkinCareModel> skinCareModelList;

    public SkinCareAdapter(List<SkinCareModel> skinCareModelList) {
        this.skinCareModelList = skinCareModelList;
    }

    @NonNull
    @Override
    public SkinCareAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SkinCareAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_skin_care_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SkinCareAdapter.ViewHolder holder, int position) {
        SkinCareModel skinCareModel = skinCareModelList.get(position);

        holder.tvProductName.setText(skinCareModel.getName());
    }

    @Override
    public int getItemCount() {
        return skinCareModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvProductName;
        private ImageView imgProductName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            imgProductName = itemView.findViewById(R.id.img_product);
        }
    }
}

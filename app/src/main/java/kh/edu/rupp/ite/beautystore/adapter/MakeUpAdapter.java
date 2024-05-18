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

public class MakeUpAdapter extends RecyclerView.Adapter<MakeUpAdapter.ViewHolder> {
    private final List<SkinCareModel> skinCareModelList;

    public MakeUpAdapter(List<SkinCareModel> skinCareModelList) {
        this.skinCareModelList = skinCareModelList;
    }

    @NonNull
    @Override
    public MakeUpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MakeUpAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_make_up_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MakeUpAdapter.ViewHolder holder, int position) {
        SkinCareModel skinCareModel = skinCareModelList.get(position);

        holder.tvProductNameMakeUp.setText(skinCareModel.getName());
    }

    @Override
    public int getItemCount() {
        return skinCareModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvProductNameMakeUp;
        private ImageView imgProductNameMakeUp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductNameMakeUp = itemView.findViewById(R.id.tv_product_name_make_up);
            imgProductNameMakeUp = itemView.findViewById(R.id.img_product_make_up);
        }
    }
}

package com.example.ex1.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex1.R;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private Context context;
    private List<Cat> mlist;

    public CatAdapter(Context context) {
        this.context = context;
        mlist = new ArrayList<>();
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = mlist.get(position);
        if(cat != null){
            holder.img.setImageResource(cat.getImg());
            holder.tvName.setText(cat.getName());
            holder.tvDescribe.setText(cat.getDescribe());
            holder.tvPrice.setText(cat.getPrice() + "");
        }
        else return;

    }

    @Override
    public int getItemCount() {
        if(mlist != null)
            return mlist.size();
        else return 0;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tvName, tvDescribe, tvPrice;
        private Button btRemove;

        public CatViewHolder(@NonNull View view) {
            super(view);
            img = view.findViewById(R.id.img);
            tvName = view.findViewById(R.id.txtName);
            tvDescribe = view.findViewById(R.id.txtDescribe);
            tvPrice = view.findViewById(R.id.txtPrice);
            btRemove = view.findViewById(R.id.btRemove);


        }
    }
}

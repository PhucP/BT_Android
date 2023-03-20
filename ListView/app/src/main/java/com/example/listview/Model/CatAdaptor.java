package com.example.listview.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listview.R;

import java.util.List;

public class CatAdaptor extends RecyclerView.Adapter<CatAdaptor.CatViewHolder>
{
    private List<Cat> mList;
//    private Context context;

    public CatAdaptor(List<Cat> mList ) {
        this.mList = mList;
        //this.context = context;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = mList.get(position);
        if(cat == null)
            return;
        holder.img.setImageResource(cat.getImage());
        holder.tv.setText(cat.getName());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context.getApplicationContext(), cat.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        if(mList != null)
            return mList.size();
        return 0;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView img;
        private TextView tv;
        private CardView cardView;

        public CatViewHolder(@NonNull View view) {
            super(view);
            img = view.findViewById(R.id.img);
            tv = view.findViewById(R.id.name);
            cardView = view.findViewById(R.id.cView);
        }
    }
}

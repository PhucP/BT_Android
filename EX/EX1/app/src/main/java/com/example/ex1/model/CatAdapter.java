package com.example.ex1.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
    private List<Cat> mList;
    private List<Cat> listBackup;
    private CatItemListener mCatItem;

    public CatAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
        listBackup = new ArrayList<>();
    }

    public List<Cat> getBackup() {
        return listBackup;
    }

    public void filterList(List<Cat> filterList) {
        mList = filterList;
        notifyDataSetChanged();
    }

    public void setOnClickListener(CatItemListener catItemListener) {
        this.mCatItem = catItemListener;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = mList.get(position);
        if(cat != null){
            holder.img.setImageResource(cat.getImg());
            holder.tvName.setText(cat.getName());
            holder.tvDescribe.setText(cat.getDescribe());
            holder.tvPrice.setText(cat.getPrice() + "");

            holder.btRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("THONG BAO XOA");
                    builder.setMessage("CHAC CHAN XOA " + cat.getName() + "?");
                    builder.setIcon(R.drawable.remove);
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            int tempIndex = holder.getAdapterPosition();
                            mList.remove(tempIndex);
                            listBackup.remove(tempIndex);
                            notifyDataSetChanged();
                        }
                    });

                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        }
        else return;

    }

    public void add(Cat cat) {
        listBackup.add(cat);
        mList.add(cat);
        notifyDataSetChanged();
    }

    public void update(int position, Cat cat) {
        listBackup.set(position, cat);
        mList.set(position, cat);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mList != null)
            return mList.size();
        else return 0;
    }

    public Cat getItem(int position) {
        return  mList.get(position);
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mCatItem != null) {
                mCatItem.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface CatItemListener {
        void onItemClick(View view, int position);
    }
}

package com.example.ex3.model;

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

import com.example.ex3.R;

import java.util.ArrayList;
import java.util.List;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.HouseViewHolder> {
    private Context context;
    private List<House> mList;
    private List<House> listBackup;
    private HouseItemListener mhouseItem;

    public HouseAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
        listBackup = new ArrayList<>();
    }

    public List<House> getBackup() {
        return listBackup;
    }

    public void filterList(List<House> filterList) {
        mList = filterList;
        notifyDataSetChanged();
    }

    public void setOnClickListener(HouseItemListener houseItemListener) {
        this.mhouseItem = houseItemListener;
    }

    @NonNull
    @Override
    public HouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new HouseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HouseViewHolder holder, int position) {
        House house = mList.get(position);
        if(house != null){
            holder.img.setImageResource(house.getImg());
            holder.diaChi.setText(house.getDiaChi());
            holder.dienTich.setText(house.getDienTich() + "m2");
            holder.gia.setText(house.getGia() + "");

            holder.btRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("THONG BAO XOA");
                    builder.setMessage("CHAC CHAN XOA " + house.getDiaChi() + "?");
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

    public void add(House house) {
        listBackup.add(house);
        mList.add(house);
        notifyDataSetChanged();
    }

    public void update(int position, House house) {
        listBackup.set(position, house);
        mList.set(position, house);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mList != null)
            return mList.size();
        else return 0;
    }

    public House getItem(int position) {
        return  mList.get(position);
    }

    public class HouseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView diaChi, dienTich, gia;
        private Button btRemove;


        public HouseViewHolder(@NonNull View view) {
            super(view);
            img = view.findViewById(R.id.img);
            diaChi = view.findViewById(R.id.diaChi);
            dienTich = view.findViewById(R.id.dienTich);
            gia = view.findViewById(R.id.gia);
            btRemove = view.findViewById(R.id.btRemove);


            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mhouseItem != null) {
                mhouseItem.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface HouseItemListener {
        void onItemClick(View view, int position);
    }
}

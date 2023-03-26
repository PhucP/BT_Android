package com.example.ex2.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex2.R;

import java.util.ArrayList;
import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder>{
    private Context context;
    private List<Job> mList;

    public JobAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Job job = mList.get(position);
        if(job == null) {
            return;
        }

        String gender = job.getGender();
        if (gender.equalsIgnoreCase("man")) {
            holder.img.setImageResource(job.imgs[0]);
        } else {
            holder.img.setImageResource(job.imgs[1]);
        }
        holder.name.setText(job.getName());
        holder.time.setText(job.getTime());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class JobViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name, time;
        private Button btRemove;

        public JobViewHolder(@NonNull View view) {
            super(view);
            init(view);
        }

        public void init(View view) {
            img = view.findViewById(R.id.img);
            name = view.findViewById(R.id.name);
            time = view.findViewById(R.id.time);
            btRemove = view.findViewById(R.id.btRemove);
            btRemove = view.findViewById(R.id.btRemove);
        }
    }

    public void addJob(Job newJob) {
        mList.add(newJob);
        notifyDataSetChanged();
    }
}


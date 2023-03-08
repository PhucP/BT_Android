package com.example.bt.adaptor;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.bt.model.Technology;

public class AdaptorTech extends ArrayAdapter<Technology>
{

    public AdaptorTech(@NonNull Context context, int resource)
    {
        super(context, resource);
    }
}

package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ex2.model.JobAdapter;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private JobAdapter adapter;
    private EditText name;
    private TextView time;
    private Button btTime;
    private Button btAdd;
    private Button btUpdate;
    private RadioGroup rbGroup;
    private RadioButton rbMan;
    private RadioButton rbWoman;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        mainActivity();
    }

    private void init() {
        // define variable
        recyclerView = findViewById(R.id.recyclerView);
        name = findViewById(R.id.name);
        time = findViewById(R.id.time);
        btTime = findViewById(R.id.btTime);
        btAdd = findViewById(R.id.btAdd);
        btUpdate = findViewById(R.id.btUpdate);
        rbGroup = findViewById(R.id.rbGroup);
        rbMan = findViewById(R.id.rbMan);
        rbWoman = findViewById(R.id.rbWoman);
        searchView = findViewById(R.id.searchView);
    }

    private void mainActivity() {
        // set new adapter
        adapter = new JobAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // setup for btn
        btTime.setOnClickListener(this);
        btAdd.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
    }

    private void pickTime() {
        Calendar c = Calendar.getInstance();
        int cy = c.get(Calendar.YEAR);
        int cm = c.get(Calendar.MONTH);
        int cd = c.get(Calendar.DATE);

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                time.setText(d + "/" + (m + 1) + "/" + y);
            }
        }, cy, cm, cd);
        dialog.show();
    }

    @Override
    public void onClick(View view) {
        if(view == btTime)
        {
           pickTime();
        } else if(view == btAdd) {

        } else if(view == btUpdate) {

        }
    }
}
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
import android.widget.Toast;

import com.example.ex2.model.Job;
import com.example.ex2.model.JobAdapter;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
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

        // set new adapter
        adapter = new JobAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        btUpdate.setActivated(false);
    }

    private void mainActivity() {
        pickTime();
        addJob();
    }

    private void pickTime() {
        btTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int cy = c.get(Calendar.YEAR);
                int cm = c.get(Calendar.MONTH);
                int cd = c.get(Calendar.DATE);

                DatePickerDialog dialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        time.setText(d + "/" + (m + 1) + "/" + y);
                    }
                }, cy, cm, cd);
                dialog.show();
            }
        });
    }

    private void addJob() {
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String newName = name.getText().toString();
                    String newTime = time.getText().toString();
                    String newGender = new String();
                    int idGender = rbGroup.getCheckedRadioButtonId();
                    newGender = idGender == R.id.rbWoman ? "woman" : "man";

                    Job newJob = new Job(newName, newTime, newGender);
                    adapter.addJob(newJob);
                    reset();
                } catch (NullPointerException e) {
                    Toast.makeText(MainActivity.this, "NHAP THEM THONG TIN", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void reset() {
        name.setText("");
        time.setText("");
        rbGroup.clearCheck();
    }
}
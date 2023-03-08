package com.example.testlogin;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    public TextView plainTextA;
//    public TextView plainTextB;
//    public TextView textKetQua;
//    public Button btnTinh;
//    public Spinner spnToanTu;

    public TextView textGioPhut;
    public TextView textNgayThang;
    public Button btnGioPhut;
    public Button btnNgayThanh;
    public ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt);

        InitView();
        btnGioPhut.setOnClickListener(this);
        btnNgayThanh.setOnClickListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long l) {
                Toast.makeText(MainActivity.this, adapter.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void InitView()
    {
        textGioPhut = findViewById(R.id.textGioPhut);
        textNgayThang = findViewById(R.id.textNgayThang);
        btnGioPhut = findViewById(R.id.btnChonGio);
        btnNgayThanh = findViewById(R.id.btnChonNgay);
        listView = findViewById(R.id.listView);

        String[] st = getResources().getStringArray(R.array.technology);
        adapter = new ArrayAdapter<>(this, R.layout.item, st);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view)
    {
        if(view == btnGioPhut)
        {
            Calendar c = Calendar.getInstance();
            int ch = c.get(Calendar.HOUR);
            int cm = c.get(Calendar.MINUTE);
            TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int h, int m) {
                    textGioPhut.setText(h + ":" + m);
                }
            },ch, cm, false);
            dialog.show();
        }
        if(view == btnNgayThanh)
        {
            Calendar c = Calendar.getInstance();
            int cy = c.get(Calendar.YEAR);
            int cm = c.get(Calendar.MONTH);
            int cd = c.get(Calendar.DATE);

            DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    textNgayThang.setText(d + "/" + (m + 1) + "/" + y);
                }
            }, cy, cm, cd);
            dialog.show();
        }
}

//    public void InitView()
//    {
//        plainTextA = findViewById(R.id.plainTextA);
//        plainTextB = findViewById(R.id.plainTextB);
//        textKetQua = findViewById(R.id.textKetQua);
//        btnTinh = findViewById(R.id.btnTinh);
//        spnToanTu = findViewById(R.id.spnToanTu);
//
//        ArrayList<String> listItemSpinner = new ArrayList<>();
//        listItemSpinner.add("+");
//        listItemSpinner.add("-");
//        listItemSpinner.add("*");
//        listItemSpinner.add("/");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listItemSpinner);
//        spnToanTu.setAdapter(adapter);
//    }
//
//    public void Calculate(View view)
//    {
//        try
//        {
//            double a = Double.parseDouble(plainTextA.getText().toString());
//            double b = Double.parseDouble(plainTextB.getText().toString());
//            String toanTu = spnToanTu.getSelectedItem().toString();
//
//            textKetQua.setText(TinhToan(a, b, toanTu));
//        }
//        catch (NumberFormatException e)
//        {
//
//        }
//
//    }
//
//    private String TinhToan(double a, double b, String toanTu)
//    {
//        double ketQua;
//        switch (toanTu)
//        {
//            case "+" :
//                ketQua = a + b;
//                break;
//            case "-":
//                ketQua = a - b;
//                break;
//            case "*":
//                ketQua = a * b;
//                break;
//            case "/":
//                ketQua = a / b;
//                break;
//            default:
//                ketQua = 0;
//        }
//        return "" + ketQua;
//    }
}
package com.example.ex3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ex3.model.House;
import com.example.ex3.model.HouseAdapter;
import com.example.ex3.model.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HouseAdapter.HouseItemListener, SearchView.OnQueryTextListener {
    private EditText diaChi;
    private EditText dienTich;
    private EditText gia;
    private CheckBox wifi;
    private CheckBox dieuHoa;
    private CheckBox mayGiat;
    private Spinner sp;
    private int pcurr;
    private HouseAdapter adapter;
    private RecyclerView recyclerView;
    private Button btAdd;
    private Button btUpdate;
    private SearchView searchView;
    private int[] imgs = {
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        sp = findViewById(R.id.img);
        SpinnerAdapter adapter = new SpinnerAdapter(this);
        sp.setAdapter(adapter);

        diaChi = findViewById(R.id.diaChi);
        dienTich = findViewById(R.id.dienTich);
        gia = findViewById(R.id.gia);
        wifi = findViewById(R.id.wifi);
        dieuHoa = findViewById(R.id.dieuHoa);
        mayGiat = findViewById(R.id.mayGiat);
        recyclerView = findViewById(R.id.recycleView);
        searchView = findViewById(R.id.searchView);
        btAdd = findViewById(R.id.btAdd);
        btUpdate = findViewById(R.id.btUpdate);

        initHouseAdapter();

        mainActivity();

    }

    private void mainActivity() {
        add();
        update();
    }

    private void update() {
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                House house = new House();
                String i = sp.getSelectedItem().toString();
                String dc = diaChi.getText().toString();
                String dt = dienTich.getText().toString();
                String g = gia.getText().toString();
                int img = R.drawable.a1;
                double price = 0;
                double dienTich2 = 0;
                try {
                    img = imgs[Integer.parseInt(i)];
                    price = Double.parseDouble(g);
                    dienTich2 = Double.parseDouble(dt);

                    house.setImg(img);
                    house.setDiaChi(dc);
                    house.setGia(price);
                    house.setDienTich(dienTich2);

                    adapter.update(pcurr, house);
                    btAdd.setEnabled(true);
                    btUpdate.setEnabled(false);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "NHAP LAI", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void add() {
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                House house = new House();
                String i = sp.getSelectedItem().toString();
                String dc = diaChi.getText().toString();
                String dt = dienTich.getText().toString();
                String g = gia.getText().toString();
                int img = R.drawable.a1;
                double price = 0;
                double dienTich2 = 0;
                try {
                    img = imgs[Integer.parseInt(i)];
                    price = Double.parseDouble(g);
                    dienTich2 = Double.parseDouble(dt);

                    house.setImg(img);
                    house.setDiaChi(dc);
                    house.setGia(price);
                    house.setDienTich(dienTich2);

                    adapter.add(house);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "NHAP LAI", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void initHouseAdapter() {
        adapter = new HouseAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, recyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(this);
        adapter.setOnClickListener(this);
    }


    @Override
    public void onItemClick(View view, int position) {
        btAdd.setEnabled(false);
        btUpdate.setEnabled(true);

        pcurr = position;
        House house = adapter.getItem(position);
        int img = house.getImg();
        int p = 0;
        for (int i = 0; i < imgs.length; i++) {
            if(img == imgs[i]) {
                p = i;
                break;
            }
        }
        sp.setSelection(p);
        diaChi.setText(house.getDiaChi());
        dienTich.setText(house.getDienTich() + "m2");
        gia.setText(house.getGia() + "");
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        filter(s);
        return false;
    }

    private void filter(String s) {
        List<House> filterlist = new ArrayList<>();
        for(House i:adapter.getBackup()) {
            if(i.getDiaChi().toLowerCase().contains(s.toLowerCase())){
                filterlist.add(i);
            }
        }
        if(filterlist.isEmpty()) {
            Toast.makeText(this, "KHONG CO", Toast.LENGTH_SHORT).show();
        }
        else {
            adapter.filterList(filterlist);
        }
    }
}
package com.example.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listview.Model.Cat;
import com.example.listview.Model.CatAdaptor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CatAdaptor adaptor;
    private TextView tempText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);

        recyclerView = findViewById(R.id.rview);
        tempText = findViewById(R.id.tempText);
        registerForContextMenu(tempText);
        adaptor = new CatAdaptor(GetList());
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptor);
    }

    private List<Cat> GetList() {
        List<Cat> list = new ArrayList<>();
        list.add(new Cat(R.drawable.a1, "universal1"));
        list.add(new Cat(R.drawable.a2, "universal1"));
        list.add(new Cat(R.drawable.a3, "universal1"));
        list.add(new Cat(R.drawable.a4, "universal1"));
        list.add(new Cat(R.drawable.a5, "universal1"));
        list.add(new Cat(R.drawable.a6, "universal1"));
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mFile:
                Toast.makeText(this, "Selected File", Toast.LENGTH_LONG).show();
                break;
            case R.id.mExit:
                System.exit(0);
                break;
            case R.id.mPhone:
                Toast.makeText(this, "Selected Phone", Toast.LENGTH_LONG).show();
                break;
            case R.id.mEmail:
                Toast.makeText(this, "Selected Email", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_color, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mRed:
                tempText.setText("RED");
                tempText.setTextColor(Color.RED);
                break;
            case R.id.mYellow:
                tempText.setText("YELLOW");
                tempText.setTextColor(Color.YELLOW);
                break;
            case R.id.mBlue:
                tempText.setText("BLUE");
                tempText.setTextColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
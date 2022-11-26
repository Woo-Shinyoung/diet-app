package com.sggyu.diet_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EnterDiet extends AppCompatActivity {
    SearchView searchView;
//    Button btAdd, btReset;
    RecyclerView recyclerView;

    List<Food> dataList = new ArrayList<>();
    FoodDB database;
    FoodAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_diet);

        searchView = findViewById(R.id.searchView);
//        btAdd = findViewById(R.id.bt_add);
//        btReset = findViewById(R.id.bt_reset);
        recyclerView = findViewById(R.id.recycler_view);

        database = FoodDB.getInstance(this);

        dataList = database.foodDao().getAll();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new FoodAdapter(EnterDiet.this, dataList);

        recyclerView.setAdapter(adapter);

    }
}
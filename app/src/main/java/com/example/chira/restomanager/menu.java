package com.example.chira.restomanager;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class menu extends AppCompatActivity {
    DatabaseManager db;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        button = findViewById(R.id.billButton);
        ArrayList<String> myDataSet = new ArrayList<>();
        db = new DatabaseManager(this);
        Cursor cursor = db.getItems();
        if(cursor.getCount() != 0 && cursor.moveToFirst()){
            while (!cursor.isAfterLast()) {
                myDataSet.add(cursor.getString(0));
                cursor.moveToNext();
            }
        }
        mRecyclerView = findViewById(R.id.menuRecyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter(myDataSet);
        mRecyclerView.setAdapter(mAdapter);
        //mLayoutManager.findViewByPosition();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}

package com.example.chira.restomanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class billPage extends AppCompatActivity {
    DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_page);
        databaseManager = new DatabaseManager(this);
    }
}

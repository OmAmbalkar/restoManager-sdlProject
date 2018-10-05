package com.example.chira.restomanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class mainFunctionPage extends AppCompatActivity {

    private ImageButton toMenu;
    private ImageButton toReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_function_page);
        toMenu = findViewById(R.id.imageButton);
        toReport = findViewById(R.id.imageButton2);
        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),menu.class);
                startActivity(intent);
            }
        });
    }

}

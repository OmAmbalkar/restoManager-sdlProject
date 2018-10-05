package com.example.chira.restomanager;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView startTextView;
    private ImageView startImageView;
    private TextView continuet;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startTextView = findViewById(R.id.textView);
        startImageView = findViewById(R.id.imageView);
        continuet = findViewById(R.id.textView2);
        layout = findViewById(R.id.layout);
        nextPage();
    }
    public void nextPage()  {

        continuet.animate().alpha(1f).setDuration(1000);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),mainFunctionPage.class);
                startActivity(intent);
            }
        });
    }

}

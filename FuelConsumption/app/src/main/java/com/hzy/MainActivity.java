package com.hzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.hzy.View.AnalyzeActivity;
import com.hzy.View.InsertActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, InsertActivity.class);
            startActivity(intent);
        });
        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(v->{
            Intent intent1 = new Intent(MainActivity.this, AnalyzeActivity.class);
            startActivity(intent1);
        });
    }
}
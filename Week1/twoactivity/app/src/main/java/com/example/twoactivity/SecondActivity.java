package com.example.twoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtMsg = findViewById(R.id.txtMsg);
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.msg);
        txtMsg.setText(msg);
    }
}

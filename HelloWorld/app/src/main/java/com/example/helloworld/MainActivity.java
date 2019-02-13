package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCount = (TextView) findViewById(R.id.txtCount);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "Hello! This is a Toast Message", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void increaseCount(View view) {
        int countValue = 0;
        countValue = Integer.parseInt(txtCount.getText().toString());
        countValue++;
        txtCount.setText(String.valueOf(countValue));

    }
}

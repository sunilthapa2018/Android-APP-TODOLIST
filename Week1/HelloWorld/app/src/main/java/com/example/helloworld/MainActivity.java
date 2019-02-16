package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtCount;
    Button btnZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCount = (TextView) findViewById(R.id.txtCount);
        btnZero = (Button) findViewById(R.id.btnZero);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "Hello! This is a Toast Message", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void increaseCount(View view) {
        btnZero.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        int countValue = Integer.parseInt(txtCount.getText().toString());
        countValue++;
        txtCount.setText(String.valueOf(countValue));
    }

    public void putZero(View view) {
        txtCount.setText(""+0);
        btnZero.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
    }
}

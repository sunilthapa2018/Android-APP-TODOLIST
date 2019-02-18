package com.example.twoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String msg = "com.example.twoactivity";
    EditText txtMsg;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMsg = findViewById(R.id.editText);
        btnSend = findViewById(R.id.btnSend);
    }

    public void btnSendClicked(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = txtMsg.getText().toString();
        intent.putExtra(msg,message);
        startActivity(intent);

    }
}

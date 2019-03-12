package com.example.alternierendequersumme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView textview;
    private TextView textview2;
    private Button btn;
    private EditText editText;
    private String matrikelnummer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textView);
        textview2 = findViewById(R.id.textView2);
        btn = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        editText.setHint("Eingabe");

    }
}

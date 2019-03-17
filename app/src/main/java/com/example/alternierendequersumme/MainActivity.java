package com.example.alternierendequersumme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    protected TextView textview;
    protected TextView textview2;
    protected static TextView response;
    protected Button btn;
    protected Button btn2;
    protected EditText editText;
    protected String matrikelnummer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textView);
        textview.setText("Bitte gib deine Matrikelnummer ein");

        response = findViewById(R.id.response);

        btn = findViewById(R.id.button);
        btn.setText("Abschicken");

        btn2 = findViewById(R.id.button2);
        btn2.setText("Berechnen");

        editText = findViewById(R.id.editText);
        editText.setHint("Eingabe");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                matrikelnummer = editText.getText().toString();
                Connection connection = new Connection();
                connection.sendToServer(matrikelnummer);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                matrikelnummer = editText.getText().toString();
                Calculation.calculateAlternierendeQuersumme(matrikelnummer);
            }
        });
    }
}

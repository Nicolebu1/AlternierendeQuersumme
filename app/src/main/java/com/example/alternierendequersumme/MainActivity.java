package com.example.alternierendequersumme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textview;
    TextView textview2;
    static TextView response;
    Button btn;
    EditText editText;
    String matrikelnummer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textView);
        textview.setText("Bitte gib deine Matrikelnummer ein");

        textview2 = findViewById(R.id.textView2);
        textview2.setText("Antwort vom Server: \n");

        response = findViewById(R.id.response);

        btn = findViewById(R.id.button);
        btn.setText("Abschicken");

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
    }
}

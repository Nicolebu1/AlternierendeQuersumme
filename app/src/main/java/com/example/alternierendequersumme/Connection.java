package com.example.alternierendequersumme;

import android.os.Handler;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection {

    final Handler handler = new Handler();

    protected void sendToServer(final String matrikelnummer) {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                try {

                    Socket socket = new Socket("se2-isys.aau.at", 53212);
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                    dataOutputStream.writeBytes(matrikelnummer + '\n');

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    final String responseString = bufferedReader.readLine();

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            MainActivity.response.setText(responseString);
                        }

                    });

                    dataOutputStream.close();
                    socket.close();

                } catch (Exception e) {
                    MainActivity.response.setText("Error: " + e.getMessage());
                }
            }
        });

        thread.start();
    }
}

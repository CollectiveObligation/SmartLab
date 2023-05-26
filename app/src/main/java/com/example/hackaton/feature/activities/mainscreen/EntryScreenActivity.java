package com.example.hackaton.feature.activities.mainscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.hackaton.R;
import com.example.hackaton.feature.activities.login.LoginActivity;

import java.util.Timer;
import java.util.TimerTask;

public class EntryScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_screen);
        SharedPreferences sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean flag = sp.getBoolean("checker", false);
        String log;
        if(flag ==true) {
            log = "true";
        } else {
            log = "false";
        }
        Log.d("PICA", log);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Log.d("timerisworking", "timerisworking");

                if(!flag) {
                    Intent i = new Intent(EntryScreenActivity.this, TipsContainerActivity.class);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(EntryScreenActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            }
        }, 5000);
    }
}
package com.example.hackaton.feature.activities.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.example.hackaton.R;
import com.example.hackaton.api.emailcode.EmailCodeAPI;
import com.example.hackaton.feature.activities.mainscreen.MainPageActivity;
import com.example.hackaton.model.CodeResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.time.LocalTime;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmailCheckActivity extends AppCompatActivity {
    String email;
    String userCode;
    TextView textView;
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    AppCompatButton button;
    TextView resend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_check);
        email = getIntent().getStringExtra("emailStr");
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        button = findViewById(R.id.checkbtn);

        textView.setText(email);
        resend = findViewById(R.id.button);
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et1.getText().toString().length() == 1){
                    et2.requestFocus();
                    et1.setEnabled(false);
                    et1.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et2.getText().toString().length() == 1){
                    et3.requestFocus();
                    et2.setEnabled(false);
                    et2.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et3.getText().toString().length() == 1){
                    et4.requestFocus();
                    et3.setEnabled(false);
                    et3.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et4.getText().toString().length() == 1) {
                    et4.setTextColor(Color.BLACK);
                    button.setEnabled(true);
                    button.setBackgroundResource(R.drawable.btn);
                    button.setTextColor(Color.WHITE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userCode = et1.getText().toString()
                        + et2.getText().toString()
                        + et3.getText().toString()
                        + et4.getText().toString();

                Intent i = new Intent(EmailCheckActivity.this, MainPageActivity.class);
                startActivity(i);
            }
        });






        class TimeCounter implements Runnable {
            public void run() {
                for (int i = 0; i < 60; i++) {
                    LocalTime currentTime = LocalTime.now();
                    resend.setText("Отправить код повторно можно будет через: " + currentTime.getSecond());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                resend.setText("Нажмите, чтобы отправить код повторно");
                resend.setEnabled(true);
                resend.setTextColor(Color.parseColor("#57A9FF"));
            }
        }
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EmailCheckActivity.this, EmailCheckActivity.class);
                i.putExtra("emailStr", email);
                startActivity(i);
            }
        });
    }



}

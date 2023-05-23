package com.example.hackaton.feature.ui.viewpagerFragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hackaton.R;
import com.example.hackaton.feature.activities.login.LoginActivity;
import com.example.hackaton.feature.activities.mainscreen.MainPageActivity;


public class ThirdTipFragment extends Fragment {
    TextView skip;
    Boolean check = false; // Для проверки, посмотрел ли всё юзер. Если да, то больше не показывать при запуске

    public ThirdTipFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_tip, container, false);
        skip = view.findViewById(R.id.textView7);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), LoginActivity.class);
                check = true;
                SharedPreferences sharedPref = getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("checker", check);
                editor.apply();
                startActivity(i);
            }
        });
        return view;
    }
}

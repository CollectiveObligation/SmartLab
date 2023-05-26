package com.example.hackaton.feature.activities.mainscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.hackaton.R;
import com.example.hackaton.feature.ui.analizi.AnaliziFragment;
import com.example.hackaton.feature.ui.profile.ProfileFragment;
import com.example.hackaton.feature.ui.results.ResultsFragment;
import com.example.hackaton.feature.ui.support.SupportFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPageActivity extends AppCompatActivity {

    BottomNavigationView bNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        changeFragment(new AnaliziFragment());
        navView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.analizi:
                    changeFragment(new AnaliziFragment());
                    break;
                case R.id.profile:
                    changeFragment(new ProfileFragment());
                    break;
                case R.id.results:
                    changeFragment(new ResultsFragment());
                    break;
                case R.id.support:
                    changeFragment(new SupportFragment());
                    break;
            }





            return true;
        });


    }
    private void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment);
        fragmentTransaction.commit();
    }

}
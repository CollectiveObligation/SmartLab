package com.example.hackaton.feature.activities.mainscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.hackaton.R;
import com.example.hackaton.feature.ui.viewpagerFragments.FirstTipFragment;
import com.example.hackaton.feature.ui.viewpagerFragments.SecondTipFragment;
import com.example.hackaton.feature.ui.viewpagerFragments.ThirdTipFragment;

public class TipsContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_container);
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }
    public static class MyAdapter extends FragmentPagerAdapter {

        MyAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FirstTipFragment();
                case 1:
                    return new SecondTipFragment();
                case 2:
                    return new ThirdTipFragment();

                default:
                    return new FirstTipFragment();
            }
        }
    }
}
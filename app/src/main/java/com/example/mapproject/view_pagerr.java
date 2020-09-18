package com.example.mapproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mapproject.fragment.Fragment1;
import com.example.mapproject.fragment.Fragment2;
import com.example.mapproject.fragment.Fragment3;

import java.util.ArrayList;

public class view_pagerr extends AppCompatActivity {

    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pagerr);

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new Fragment1());
        fragmentArrayList.add(new Fragment2());
        fragmentArrayList.add(new Fragment3());

        viewPager = findViewById(R.id.viewpager);
        pagerAdapter = new Slide_Pager_Adapter(getSupportFragmentManager(), fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);
    }
}

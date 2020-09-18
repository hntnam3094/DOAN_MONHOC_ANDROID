package com.example.mapproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class Slide_Pager_Adapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragmentArrayList;
    public Slide_Pager_Adapter(FragmentManager fm, ArrayList<Fragment> listFagment){
        super(fm);
        this.fragmentArrayList = listFagment;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
}

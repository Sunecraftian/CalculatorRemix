package com.example.calculatorremix;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 3;

    public TabLayoutAdapter(Fragment fragment) { super(fragment); }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment = null;

        Bundle args = new Bundle();


        switch (position) {
            case 0:
                fragment = new TipCalulatorFragment();
                args.putInt(TipCalulatorFragment.ARG_ID, position + 1);
                break;
            case 1:
                fragment = new TemperatureConverterFragment();
                args.putInt(TemperatureConverterFragment.ARG_ID, position + 1);
                break;
            case 2:
                fragment = new DistanceConverterFragment();
                args.putInt(DistanceConverterFragment.ARG_ID, position + 1);
                break;
        }


        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getItemCount() { return NUM_TABS; }
}

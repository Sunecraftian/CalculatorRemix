package com.example.calculatorremix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.calculatorremix.databinding.DistConvFragMainBinding;

public class DistanceConverterFragment extends Fragment {

    public static final String ARG_ID = "id";

    EditText mile_edit;
    EditText kilometer_edit;

    float miles;
    float kilometers;

    private DistConvFragMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DistConvFragMainBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        String id = Integer.toString(args.getInt("id"));

        mile_edit = binding.mileEdit;
        kilometer_edit = binding.kilometerEdit;

        binding.convertBtn.setOnClickListener(v -> {
            convert_dist();
        });

    }
    public void convert_dist() {
        miles = 0.0F;
        kilometers = 0.0F;
        try {
            if (!mile_edit.getText().toString().isEmpty()) {
                miles = Float.parseFloat(mile_edit.getText().toString());

                kilometers = miles * 1.609F;
                kilometer_edit.setText(String.format("%.2f", kilometers));

            } else if (!kilometer_edit.getText().toString().isEmpty()) {
                kilometers = Float.parseFloat(kilometer_edit.getText().toString());

                miles = kilometers / 1.609F;
                mile_edit.setText(String.format("%.2f", miles));
            }
        } catch (Exception e) {}
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("miles", String.valueOf(miles));
        outState.putString("kilometers", String.valueOf(kilometers));
    }
}

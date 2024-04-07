package com.example.calculatorremix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.calculatorremix.databinding.TempConvFragMainBinding;

public class TemperatureConverterFragment extends Fragment {

    public static final String ARG_ID = "id";

    EditText fahrenheit_edit;
    EditText celsius_edit;

    float fahrenheit;
    float celsius;

    private TempConvFragMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TempConvFragMainBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        String id = Integer.toString(args.getInt("id"));

        fahrenheit_edit = binding.fahrenheitEdit;
        celsius_edit = binding.celsiusEdit;

        binding.convertBtn.setOnClickListener(v -> {
            convert_temp();
        });

    }
    public void convert_temp() {
        fahrenheit = 0.0F;
        celsius = 0.0F;
        try {
            if (!fahrenheit_edit.getText().toString().isEmpty()) {
                fahrenheit = Float.parseFloat(fahrenheit_edit.getText().toString());

                celsius = ((fahrenheit - 32) * 5) / 9;
                celsius_edit.setText(String.format("%.2f", celsius));

            } else if (!celsius_edit.getText().toString().isEmpty()) {
                celsius = Float.parseFloat(celsius_edit.getText().toString());

                fahrenheit = ((celsius * 9) / 5) + 32;
                fahrenheit_edit.setText(String.format("%.2f", fahrenheit));
            }
        } catch (Exception e) {}
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("fahrenheit", String.valueOf(fahrenheit));
        outState.putString("celsius", String.valueOf(celsius));
    }
}

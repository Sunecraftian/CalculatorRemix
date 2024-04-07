package com.example.calculatorremix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.calculatorremix.databinding.TipCalcFragMainBinding;

public class TipCalulatorFragment extends Fragment {

    public static final String ARG_ID = "id";

    TextView total_per_person_view;
    EditText total_bill_edit;
    EditText tip_percentage_edit;
    EditText num_of_people_edit;

    String total_per_person;

    private TipCalcFragMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TipCalcFragMainBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        String id = Integer.toString(args.getInt(ARG_ID));

        total_per_person_view = binding.totalPerPersonView;
        total_bill_edit = binding.totalBillEdit;
        tip_percentage_edit = binding.tipPercentageEdit;
        num_of_people_edit = binding.numOfPeopleEdit;

        binding.calculateButton.setOnClickListener(v -> {
            try {
                total_per_person = String.format("Total Per Person: $%.2f", calculate_tip());
                total_per_person_view.setText(total_per_person);
            } catch (Exception e) {
                total_per_person_view.setText("Invalid Fields!");
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("total_per_person", total_per_person);
    }


    public float calculate_tip() {
        float tip = 0.0F;
        float total_bill = Float.parseFloat(total_bill_edit.getText().toString());
        float tip_percentage = Float.parseFloat(tip_percentage_edit.getText().toString());
        int num_of_people = Integer.parseInt(num_of_people_edit.getText().toString());

        tip_percentage /= 100;

        tip = (total_bill + (total_bill * tip_percentage)) / num_of_people;


        return tip;
    }
}

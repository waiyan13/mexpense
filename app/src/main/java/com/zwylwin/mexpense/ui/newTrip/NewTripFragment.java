package com.zwylwin.mexpense.ui.newTrip;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.zwylwin.mexpense.databinding.FragmentNewTripBinding;
import com.zwylwin.mexpense.ui.datepicker.DatePickerFragment;

import java.util.Objects;

public class NewTripFragment extends Fragment {
    private FragmentNewTripBinding binding;
    private EditText newTripDestination;
    private EditText newTripName;
    private EditText newTripStartDate;
    private NewTripViewModel newTripViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newTripViewModel = new ViewModelProvider(requireActivity()).get(NewTripViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNewTripBinding.inflate(inflater, container, false);

        newTripDestination = Objects.requireNonNull(binding.newTripDestination.getEditText());
        newTripName = Objects.requireNonNull(binding.newTripName.getEditText());
        newTripStartDate = Objects.requireNonNull(binding.newTripStartDate.getEditText());

        newTripDestination.setOnFocusChangeListener((view, hasFocus) -> {
            newTripViewModel.setTripDestination(newTripDestination.getText().toString());
        });

        newTripName.setOnFocusChangeListener((view, hasFocus) -> {
            newTripViewModel.setTripName(newTripName.getText().toString());
        });

        newTripStartDate.setOnClickListener(view -> {
            DatePickerFragment datePickerFragment = new DatePickerFragment();
            datePickerFragment.show(requireActivity().getSupportFragmentManager(), "startDatePicker");
        });

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        newTripViewModel.getStartDate().observe(getViewLifecycleOwner(), date -> {
            newTripStartDate.setText(date.toString());
        });
        newTripViewModel.getTripName().observe(getViewLifecycleOwner(), name -> {
            newTripName.setText(name.toString());
        });
        newTripViewModel.getTripDestination().observe(getViewLifecycleOwner(), destination -> {
            newTripDestination.setText(destination.toString());
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.zwylwin.mexpense.ui.newTrip;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.zwylwin.mexpense.databinding.FragmentNewTripBinding;

import java.util.Objects;

public class NewTripFragment extends Fragment {
    private FragmentNewTripBinding binding;
    private EditText newTripDate;
    private EditText newTripDestination;
    private EditText newTripName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewTripViewModel newTripViewModel =
                new ViewModelProvider(this).get(NewTripViewModel.class);
        binding = FragmentNewTripBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        newTripName = binding.newTripName.getEditText();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
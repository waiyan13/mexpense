package com.zwylwin.mexpense.ui.datepicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;

import android.os.Bundle;
import android.widget.DatePicker;

import com.zwylwin.mexpense.ui.newTrip.NewTripViewModel;

import java.time.LocalDate;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {
    private NewTripViewModel viewModel;

    @NonNull
    @Override
    public DatePickerDialog onCreateDialog(Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(NewTripViewModel.class);
        return new DatePickerDialog(
                requireContext(), this,
                LocalDate.now().getYear(),
                LocalDate.now().getMonthValue(),
                LocalDate.now().getDayOfMonth()
        );
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        viewModel.getStartDate().setValue(LocalDate.of(year, month, day));
    }
}
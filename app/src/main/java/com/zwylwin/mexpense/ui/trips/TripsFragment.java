package com.zwylwin.mexpense.ui.trips;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zwylwin.mexpense.R;
import com.zwylwin.mexpense.databinding.FragmentTripsBinding;
import com.zwylwin.mexpense.ui.newTrip.NewTripViewModel;

public class TripsFragment extends Fragment {

    private FragmentTripsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TripsViewModel tripsViewModel =
                new ViewModelProvider(this).get(TripsViewModel.class);

        binding = FragmentTripsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final FloatingActionButton addNewTripBtn = binding.addNewTrip;
        addNewTripBtn.setOnClickListener(view -> {
            NavDirections action =
                    TripsFragmentDirections.actionNavigationTripsToNewTripFragment();
            Navigation.findNavController(view).navigate(action);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
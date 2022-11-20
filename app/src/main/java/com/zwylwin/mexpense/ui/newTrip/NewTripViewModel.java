package com.zwylwin.mexpense.ui.newTrip;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDate;

public class NewTripViewModel extends ViewModel {
    private final MutableLiveData<String> tripDestination = new MutableLiveData<String>();
    private final MutableLiveData<String> tripName = new MutableLiveData<String>();
    private final MutableLiveData<LocalDate> startDate = new MutableLiveData<>();

    public MutableLiveData<String> getTripDestination() { return tripDestination; }

    public void setTripDestination(String destination) { tripDestination.setValue(destination);}

    public MutableLiveData<String> getTripName() { return tripName; }

    public void setTripName(String name) { tripName.setValue(name); }

    public MutableLiveData<LocalDate> getStartDate() {
        return startDate;
    }

    public void setStartLocalDate(LocalDate date) {
        startDate.setValue(date);
    }
}
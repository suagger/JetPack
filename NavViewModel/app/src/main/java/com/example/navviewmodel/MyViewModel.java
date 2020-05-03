package com.example.navviewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {
        if(number == null){
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }


    public void add(int n){
        number.setValue(number.getValue() + n);
    }
}

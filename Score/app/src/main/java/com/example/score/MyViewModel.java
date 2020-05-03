package com.example.score;

import android.content.SharedPreferences;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> mutableLiveDataA;
    private MutableLiveData<Integer> mutableLiveDataB;
    private int backA;
    private int backB;

    public MutableLiveData<Integer> getLiveDataA() {
        if(mutableLiveDataA == null){
            mutableLiveDataA = new MutableLiveData<>();
            mutableLiveDataA.setValue(0);
        }
        return mutableLiveDataA;
    }

    public MutableLiveData<Integer> getLiveDataB() {
        if(mutableLiveDataB == null){
            mutableLiveDataB = new MutableLiveData<>();
            mutableLiveDataB.setValue(0);
        }
        return mutableLiveDataB;
    }

    public void addScoreA(int n){
        backA = mutableLiveDataA.getValue();
        backB = mutableLiveDataB.getValue();
        mutableLiveDataA.setValue(mutableLiveDataA.getValue() + n);
    }
    public void addScoreB(int n){
        backB = mutableLiveDataB.getValue();
        backA = mutableLiveDataA.getValue();
        mutableLiveDataB.setValue(mutableLiveDataB.getValue() + n);
    }

    public void clear() {
        mutableLiveDataA.setValue(0);
        mutableLiveDataB.setValue(0);
    }
    public void reback(){
        mutableLiveDataA.setValue(backA);
        mutableLiveDataB.setValue(backB);
    }
}

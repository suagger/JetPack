package com.example.androidviewmodelphs;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {
    private SavedStateHandle handle;
    private String key = getApplication().getResources().getString(R.string.key_data);
    public MyViewModel(@NonNull Application application,SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if(! handle.contains(key)){
            load();
        }
    }

    public LiveData<Integer> getNumber(){
        return handle.getLiveData(key);
    }

    private void load(){
        SharedPreferences preferences = getApplication().getSharedPreferences("info", Context.MODE_PRIVATE);
        int num = preferences.getInt(key,0);
        handle.set(key,num);
    }

    public void add(int n){
        handle.set(key,getNumber().getValue() + n);
    }

    public void save(){
        SharedPreferences preferences = getApplication().getSharedPreferences("info",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key,getNumber().getValue());
        editor.apply();
    }
}

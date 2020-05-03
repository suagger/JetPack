package com.example.score;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


//这里没有带参数，如果想要带参数的话，可以在MyViewModel的构造函数中使用参数

public class MyViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MyViewModel();
    }
}

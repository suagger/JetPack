package com.example.score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.score.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MyViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        binding.setData(viewModel);
        binding.setLifecycleOwner(this);
    }





}

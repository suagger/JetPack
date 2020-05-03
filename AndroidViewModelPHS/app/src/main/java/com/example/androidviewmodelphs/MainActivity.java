package com.example.androidviewmodelphs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.androidviewmodelphs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(MyViewModel.class);

        binding.setData(viewModel);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.save();
    }
}

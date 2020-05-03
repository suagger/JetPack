package com.example.livedatatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewModelWithLiveData viewModel;
    private ImageButton imageButtonUP,imageButtonDown;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(ViewModelWithLiveData.class);
        imageButtonDown = findViewById(R.id.ib_down);
        imageButtonUP = findViewById(R.id.ib_up);
        textView = findViewById(R.id.count_text);

        viewModel.getMutableLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });

        imageButtonUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.add(1);
            }
        });

        imageButtonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.add(-1);
            }
        });

    }
}

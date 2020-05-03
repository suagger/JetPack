package com.example.navviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        返回键 + 导航栏(在此处用返回键有点问题)
        NavController controller = Navigation.findNavController(MainActivity.this,R.id.fragment);
        NavigationUI.setupActionBarWithNavController(MainActivity.this,controller);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController controller = Navigation.findNavController(MainActivity.this,R.id.fragment);
        return controller.navigateUp();
    }
}

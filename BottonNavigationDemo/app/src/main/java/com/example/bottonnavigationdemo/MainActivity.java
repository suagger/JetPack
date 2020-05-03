package com.example.bottonnavigationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
        NavController controller = Navigation.findNavController(MainActivity.this,R.id.fragment);
//        底部导航条
        AppBarConfiguration configuration = new AppBarConfiguration.Builder(bottomNavigationView.getMenu()).build();

        NavigationUI.setupActionBarWithNavController(MainActivity.this,controller,configuration);
        NavigationUI.setupWithNavController(bottomNavigationView,controller);
    }
}

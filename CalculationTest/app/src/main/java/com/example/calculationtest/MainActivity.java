package com.example.calculationtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = Navigation.findNavController(this,R.id.fragment);

        NavigationUI.setupActionBarWithNavController(this,controller);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if(controller.getCurrentDestination().getId() == R.id.questionFragment){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Are you sure to quit?");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    controller.navigateUp();
                }
            });
            alertDialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog = alertDialog.create();
            dialog.show();
//            所在页面
        }else if(controller.getCurrentDestination().getId() == R.id.titleFragment){
            finish();
        }else{
            controller.navigateUp();
        }
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        onSupportNavigateUp();
    }
}


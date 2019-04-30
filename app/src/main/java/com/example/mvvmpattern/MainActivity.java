package com.example.mvvmpattern;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmpattern.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements CallbackLogin{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        activityMainBinding.setViewmodel(new LoginViewModel(this));
        activityMainBinding.executePendingBindings();
    }


    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

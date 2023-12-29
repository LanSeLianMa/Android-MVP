package com.example.androidmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidmvp.databinding.ActivityMainBinding;
import com.example.androidmvp.ui.activity.MVPActivity;
import com.example.androidmvp.ui.activity.NormalActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.normal.setOnClickListener(this);
        binding.mvp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == binding.normal) {
            Intent intent = new Intent(this, NormalActivity.class);
            startActivity(intent);
        } else if (v == binding.mvp) {
            Intent intent = new Intent(this, MVPActivity.class);
            startActivity(intent);
        }
    }
}
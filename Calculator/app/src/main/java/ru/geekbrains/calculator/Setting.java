package ru.geekbrains.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class Setting extends AppCompatActivity {

    SwitchCompat switchCompat;
    SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> openMain());

        switchCompat = findViewById(R.id.switchCompat);

        sharedPreferences = getSharedPreferences("night",0);
        boolean booleanValue = sharedPreferences.getBoolean("night_mode",true);
        if (booleanValue){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            switchCompat.setChecked(true);
        }

        switchCompat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                switchCompat.setChecked(true);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("night_mode",true);
                editor.apply();
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                switchCompat.setChecked(false);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("night_mode",false);
                editor.apply();

            }
        });
    }

    public void openMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
package ru.gendalf13666.moonshiner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class beer_alco extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    private Button button;
    private CheckBox convert;
    SharedPreferences mSettings;
    private EditText pKoef;
    private EditText pKon;
    private EditText pNach;
    private CheckBox refract;
    private TextView rezultat;

    @SuppressLint({"WrongConstant", "DefaultLocale", "ShowToast"})
    private void raschet() {
        double d;
        double d2;
        String string2 = this.pNach.getText().toString();
        String string3 = this.pKon.getText().toString();
        String string4 = this.pKoef.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u0430 \u043d\u0430\u0447\u0430\u043b\u044c\u043d\u0430\u044f \u043f\u043b\u043e\u0442\u043d\u043e\u0441\u0442\u044c", 0).show();
            this.pNach.requestFocus();
            return;
        }
        if (string3.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u0430 \u043a\u043e\u043d\u0435\u0447\u043d\u0430\u044f \u043f\u043b\u043e\u0442\u043d\u043e\u0441\u0442\u044c", 0).show();
            this.pKon.requestFocus();
            return;
        }
        if (this.refract.isChecked() && string4.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d \u043f\u043e\u043f\u0440\u0430\u0432\u043e\u0447\u043d\u044b\u0439 \u043a\u043e\u044d\u0444\u0444\u0438\u0446\u0438\u0435\u043d\u0442 \u0441\u0443\u0441\u043b\u0430", 0).show();
            this.pKoef.requestFocus();
            return;
        }
        Double d3 = Double.parseDouble(string2);
        Double d4 = Double.parseDouble(string3);
        if (string4.length() == 0) {
            string4 = "1.0";
        }
        Double d5 = Double.parseDouble(string4);
        if (d3 - d4 >= 1.0) {
            this.convert.setChecked(true);
        }
        if (d3 - d4 < 0.9999) {
            this.convert.setChecked(false);
        }
        if (this.convert.isChecked() && !this.refract.isChecked()) {
            d3 = 1.0 + d3 / (258.6 - 227.1 * (d3 / 258.2));
            d4 = 1.0 + d4 / (258.6 - 227.1 * (d4 / 258.2));
        }
        if (this.refract.isChecked()) {
            double d6 = 1.0 - 0.0044993 * (d3 / d5) + 0.0117741 * (d4 / d5) + 2.75806E-4 * Math.pow(d3 / d5, 2.0) - 0.00127169 * Math.pow(d4 / d5, 2.0) - 7.27999E-6 * Math.pow(d3 / d5, 3.0) + 6.32929E-5 * Math.pow(d4 / d5, 3.0);
            d = 100.0 * (0.01220703125 * (d3 / d5 - (0.1808 * (d3 / d5) + 0.8192 * (668.72 * d6 - 463.37 - 205.347 * Math.pow(d6, 2.0)))) / (2.0665 - 0.010665 * (d3 / d5)));
            Double.valueOf(0.01220703125 * (d3 / d5 - (0.1808 * (d3 / d5) + 0.8192 * (-463.37 - 205.347 * Math.pow(0.0, 2.0)))) / (2.0665 - 0.010665 * (d3 / d5)));
            d2 = 0.0;
        } else {
            double d7 = 131.25 * (d3 - d4);
            d2 = 76.8 * (d3 - d4) / (1.775 - d3) * (d4 / 0.794);
            d = d7;
        }
        TextView textView = this.rezultat;
        String stringBuilder = String.format("%.2f", d) +
                "%";
        textView.setText(stringBuilder);
        Context context = this.getApplicationContext();
        String stringBuilder2 = "\u0410\u043b\u044c\u0442\u0435\u0440\u043d\u0430\u0442\u0438\u0432\u043d\u044b\u0439 \u0440\u0430\u0441\u0447\u0435\u0442: " +
                String.format("%.2f", d2) +
                "%";
        Toast.makeText(context, stringBuilder2, 0).show();
        ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.button.getWindowToken(), 2);
    }

    void LoadData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        this.pNach.setText(sharedPreferences.getString("beeralco_1", ""));
        this.pKon.setText(this.mSettings.getString("beeralco_2", ""));
        this.pKoef.setText(this.mSettings.getString("beeralco_3", ""));
        this.refract.setChecked(this.mSettings.getBoolean("beeralco_4", false));
    }

    void SaveData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("beeralco_1", this.pNach.getText().toString());
        editor.putString("beeralco_2", this.pKon.getText().toString());
        editor.putString("beeralco_3", this.pKoef.getText().toString());
        editor.putBoolean("beeralco_4", this.refract.isChecked());
        editor.apply();
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        Button button;
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_beer_alco);
        ActionBar actionBar = this.getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.pNach = this.findViewById(R.id.pNach);
        this.pKon = this.findViewById(R.id.pKon);
        this.pKoef = this.findViewById(R.id.koefsuslo);
        this.rezultat = this.findViewById(R.id.rezultat);
        this.convert = this.findViewById(R.id.convert);
        this.refract = this.findViewById(R.id.refract);
        this.button = button = this.findViewById(R.id.button);
        button.setOnClickListener(view -> beer_alco.this.raschet());
    }

    @SuppressLint("ResourceType")
    public boolean onCreateOptionsMenu(Menu menu2) {
        this.getMenuInflater().inflate(R.menu.menu_saveload, menu2);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int n = menuItem.getItemId();
        if (n != R.id.home) {
            if (n != R.id.action_loaddata) {
                if (n != R.id.action_savedata) {
                    return super.onOptionsItemSelected(menuItem);
                }
                this.SaveData();
                Toast.makeText(this, (int)R.string.toast_savedata, (int)0).show();
                return true;
            }
            this.LoadData();
            beer_alco.super.onOptionsItemSelected(menuItem);
            Toast.makeText(this, (int)R.string.toast_loaddata, (int)0).show();
            return true;
        }
        this.finish();
        return true;
    }

}


package ru.gendalf13666.moonshiner;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class sem_headbody extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    private Button button;
    private Spinner heads_perc;
    SharedPreferences mSettings;
    private TextView spirt_all;
    private EditText spirt_full;
    private TextView spirt_heads;
    private TextView spirt_hvost;
    private TextView spirt_prod;
    private EditText spirt_strong;
    private EditText spirt_strongOut;

    private void clear_tree() {
        this.spirt_strongOut.setText(null);
        this.spirt_strongOut.requestFocus();
    }

    void LoadData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        this.spirt_full.setText(sharedPreferences.getString("headbody_1", ""));
        this.spirt_strong.setText(this.mSettings.getString("headbody_2", ""));
        this.spirt_strongOut.setText(this.mSettings.getString("headbody_3", ""));
        this.heads_perc.setSelection(this.mSettings.getInt("headbody_4", 0));
    }

    void SaveData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("headbody_1", this.spirt_full.getText().toString());
        editor.putString("headbody_2", this.spirt_strong.getText().toString());
        editor.putString("headbody_3", this.spirt_strongOut.getText().toString());
        editor.putInt("headbody_4", this.heads_perc.getSelectedItemPosition());
        editor.apply();
    }

    public void clear_one() {
        this.spirt_full.setText(null);
        this.spirt_full.requestFocus();
    }

    public void clear_two() {
        this.spirt_strong.setText(null);
        this.spirt_strong.requestFocus();
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        ImageButton imageButton;
        ImageButton imageButton2;
        ImageButton imageButton3;
        Spinner spinner;
        Button button;
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_sem_headbody);
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.button = button = this.findViewById(R.id.button);
        button.setOnClickListener(view -> sem_headbody.this.raschet_semdrobniy());
        ImageButton clear1 = imageButton = this.findViewById(R.id.clear1);
        imageButton.setOnClickListener(view -> sem_headbody.this.clear_one());
        ImageButton clear2 = imageButton2 = this.findViewById(R.id.clear2);
        imageButton2.setOnClickListener(view -> sem_headbody.this.clear_two());
        ImageButton clear3 = imageButton3 = this.findViewById(R.id.clear3);
        imageButton3.setOnClickListener(view -> sem_headbody.this.clear_tree());
        this.spirt_strong = this.findViewById(R.id.spirt_strong);
        this.spirt_full = this.findViewById(R.id.spirt_full);
        this.spirt_strongOut = this.findViewById(R.id.spirt_strongOut);
        this.spirt_all = this.findViewById(R.id.spirt_itog_full_rez);
        this.spirt_heads = this.findViewById(R.id.spirt_itog_heads_rez);
        this.spirt_prod = this.findViewById(R.id.spirt_itog_prod_rez);
        this.spirt_hvost = this.findViewById(R.id.spirt_itog_hvost_rez);
        this.heads_perc = spinner = this.findViewById(R.id.heads_perc);
        spinner.setSelection(4);
    }

    @SuppressLint("ResourceType")
    public boolean onCreateOptionsMenu(Menu menu2) {
        this.getMenuInflater().inflate(R.menu.menu_saveload, menu2);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int n = menuItem.getItemId();
        if (n !=  R.id.home) {
            if (n != R.id.action_loaddata) {
                if (n != R.id.action_savedata) {
                    return super.onOptionsItemSelected(menuItem);
                }
                this.SaveData();
                Toast.makeText(this, R.string.toast_savedata,(int)0).show();
                return true;
            }
            this.LoadData();
            this.raschet_semdrobniy();
            Toast.makeText(this, R.string.toast_loaddata, (int)0).show();
            return true;
        }
        this.finish();
        return true;
    }


    public void raschet_semdrobniy() {
        String string2 = this.spirt_full.getText().toString();
        String string3 = this.spirt_strong.getText().toString();
        String string4 = this.heads_perc.getSelectedItem().toString();
        String string5 = this.spirt_strongOut.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0441\u043f\u0438\u0440\u0442\u0430-\u0441\u044b\u0440\u0446\u0430", (int)0).show();
            this.spirt_full.requestFocus();
            return;
        }
        if (string3.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u0438 \u0441\u044b\u0440\u0446\u0430", (int)0).show();
            this.spirt_strong.requestFocus();
            return;
        }
        if (string5.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u0438 \u043d\u0430 \u0432\u044b\u0445\u043e\u0434\u0435", (int)0).show();
            this.spirt_strongOut.requestFocus();
            string5 = "0";
        }
        double d = Double.parseDouble(string2);
        double d2 = Double.parseDouble(string3);
        double d3 = Double.parseDouble(string4);
        double d4 = Double.parseDouble(string5);
        double d5 = d * (d2 / 100.0);
        double d6 = d5 * (d3 / 100.0);
        double d7 = 0.15 * d5;
        double d8 = d5 - d6 - d7;
        double d9 = 0.0;
        if (d4 != d9) {
            d9 = d8 + d8 * (100.0 / d4 - 1.0);
        }
        Object[] arrobject = new Object[]{d5};
        @SuppressLint("DefaultLocale") String string6 = String.format("%.3f", arrobject);
        Object[] arrobject2 = new Object[]{d6};
        @SuppressLint("DefaultLocale") String string7 = String.format("%.3f", arrobject2);
        Object[] arrobject3 = new Object[]{d7};
        @SuppressLint("DefaultLocale") String string8 = String.format("%.3f", arrobject3);
        Object[] arrobject4 = new Object[]{d9};
        @SuppressLint("DefaultLocale") String string9 = String.format("%.3f", arrobject4);
        this.spirt_all.setText(string6);
        this.spirt_heads.setText(string7);
        this.spirt_prod.setText(string9);
        this.spirt_hvost.setText(string8);
        //возможна ошибка
        ((InputMethodManager)this.getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(this.button.getWindowToken(), 2);

    }

}


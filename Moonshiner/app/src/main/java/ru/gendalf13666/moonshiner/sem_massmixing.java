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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class sem_massmixing extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    private Button button;
    SharedPreferences mSettings;
    private TextView sem_result;
    private EditText spirt_full;
    private EditText spirt_itog;
    private EditText start_mass;

    private void LoadData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        this.start_mass.setText(sharedPreferences.getString("massmixing_1", ""));
        this.spirt_full.setText(this.mSettings.getString("massmixing_2", ""));
        this.spirt_itog.setText(this.mSettings.getString("massmixing_3", ""));
    }

    private void SaveData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("massmixing_1", this.start_mass.getText().toString());
        editor.putString("massmixing_2", this.spirt_full.getText().toString());
        editor.putString("massmixing_3", this.spirt_itog.getText().toString());
        editor.apply();
    }

    private void clear_one() {
        this.start_mass.setText(null);
        this.start_mass.requestFocus();
    }

    private void clear_tree() {
        this.spirt_itog.setText(null);
        this.spirt_itog.requestFocus();
    }

    private void clear_two() {
        this.spirt_full.setText(null);
        this.spirt_full.requestFocus();
    }

    @SuppressLint({"WrongConstant", "DefaultLocale"})
    private void raschet() {
        String string2 = this.start_mass.getText().toString();
        String string3 = this.spirt_full.getText().toString();
        String string4 = this.spirt_itog.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "NO_DATA", 0).show();
            this.start_mass.requestFocus();
            return;
        }
        if (string3.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "NO_DATA", 0).show();
            this.spirt_full.requestFocus();
            return;
        }
        if (string4.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "NO_DATA", 0).show();
            this.spirt_itog.requestFocus();
            return;
        }
        int n = Integer.parseInt(string2);
        int n2 = Integer.parseInt(string3);
        if (n2 <= 100 && n2 >= 0) {
            int n3 = Integer.parseInt(string4);
            if (n3 >= 1 && n3 <= n2) {
                double[][] arrarrd = new double[][]{{0.9982}, {0.9967}, {0.9953}, {0.9938}, {0.9924}, {0.991}, {0.9897}, {0.9884}, {0.9872}, {0.9859}, {0.9847}, {0.9836}, {0.9824}, {0.9812}, {0.98}, {0.9789}, {0.9778}, {0.9768}, {0.9759}, {0.9746}, {0.9736}, {0.9725}, {0.9714}, {0.9703}, {0.9692}, {0.9681}, {0.967}, {0.9658}, {0.9646}, {0.9634}, {0.9622}, {0.961}, {0.9597}, {0.9584}, {0.957}, {0.9556}, {0.9542}, {0.9527}, {0.9512}, {0.9496}, {0.948}, {0.9464}, {0.9448}, {0.9431}, {0.9413}, {0.9395}, {0.9377}, {0.9359}, {0.934}, {0.9321}, {0.9302}, {0.9282}, {0.9262}, {0.9242}, {0.9221}, {0.92}, {0.9179}, {0.9157}, {0.9136}, {0.9114}, {0.9091}, {0.9069}, {0.9046}, {0.9023}, {0.9}, {0.8976}, {0.8952}, {0.8928}, {0.8904}, {0.888}, {0.8855}, {0.883}, {0.8805}, {0.8779}, {0.8754}, {0.8728}, {0.8701}, {0.8675}, {0.8648}, {0.862}, {0.8593}, {0.8565}, {0.8537}, {0.8508}, {0.8479}, {0.8449}, {0.8419}, {0.8389}, {0.8357}, {0.8325}, {0.8292}, {0.8259}, {0.8224}, {0.8189}, {0.8152}, {0.8114}, {0.8075}, {0.8033}, {0.799}, {0.7942}, {0.7892}};
                double d2 = arrarrd[n2][0];
                Double.isNaN(n);
                double d3 = (double) n / d2;
                double d4 = d3 / ((double) n3 / (double) n2) - d3;
                TextView textView = this.sem_result;
                Object[] arrobject = new Object[]{d4};
                textView.setText(String.format("%.0f", arrobject));
                ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.button.getWindowToken(), 2);
                return;
            }
            Toast.makeText(this.getApplicationContext(), "OUT_OF_RANGE", 0).show();
            this.spirt_itog.setText(null);
            this.spirt_itog.requestFocus();
            return;
        }
        Toast.makeText(this.getApplicationContext(), "OUT_OF_RANGE", 0).show();
        this.spirt_full.setText(null);
        this.spirt_full.requestFocus();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_sem_massmixing);
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.start_mass = this.findViewById(R.id.start_mass);
        this.spirt_full = this.findViewById(R.id.spirt_full);
        this.spirt_itog = this.findViewById(R.id.spirt_itog);
        this.sem_result = this.findViewById(R.id.sem_result);
        this.button = this.findViewById(R.id.button);
        ImageButton clear1 = this.findViewById(R.id.clear1);
        ImageButton clear2 = this.findViewById(R.id.clear2);
        ImageButton clear3 = this.findViewById(R.id.clear3);
        this.button.setOnClickListener(view -> sem_massmixing.this.raschet());
        clear1.setOnClickListener(view -> sem_massmixing.this.clear_one());
        clear2.setOnClickListener(view -> sem_massmixing.this.clear_two());
        clear3.setOnClickListener(view -> sem_massmixing.this.clear_tree());
    }

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
                sem_massmixing.this.SaveData();
                Toast.makeText(this, R.string.toast_savedata, (int)0).show();
                return true;
            }
            sem_massmixing.this.LoadData();
            sem_massmixing.this.raschet();
            Toast.makeText(this, R.string.toast_loaddata, (int)0).show();
            return true;
        }
        this.finish();
        return true;
    }

}


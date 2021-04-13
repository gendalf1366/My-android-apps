package ru.gendalf13666.moonshiner;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

public class sem_Napitok extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    private EditText litr_itog;
    SharedPreferences mSettings;
    private Button raschet;
    private TextView sem_result;
    private TextView sem_result2;
    private EditText spirt_full;
    private EditText spirt_itog;

    private void clear_one() {
        this.spirt_full.setText(null);
        this.spirt_full.requestFocus();
    }

    private void clear_tree() {
        this.litr_itog.setText(null);
        this.litr_itog.requestFocus();
    }

    private void clear_two() {
        this.spirt_itog.setText(null);
        this.spirt_itog.requestFocus();
    }

    void LoadData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        this.spirt_full.setText(sharedPreferences.getString("headbody_1", ""));
        this.spirt_itog.setText(this.mSettings.getString("headbody_2", ""));
        this.litr_itog.setText(this.mSettings.getString("headbody_3", ""));
    }

    void SaveData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("headbody_1", this.spirt_full.getText().toString());
        editor.putString("headbody_2", this.spirt_itog.getText().toString());
        editor.putString("headbody_3", this.litr_itog.getText().toString());
        editor.apply();
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        ImageButton imageButton;
        ImageButton imageButton2;
        ImageButton imageButton3;
        Button button;
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_sem__napitok);
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.raschet = button = this.findViewById(R.id.raschet);
        button.setOnClickListener(view -> sem_Napitok.this.raschet_napitok());
        ImageButton clear1 = imageButton = this.findViewById(R.id.clear1);
        imageButton.setOnClickListener(view -> sem_Napitok.this.clear_one());
        ImageButton clear2 = imageButton2 = this.findViewById(R.id.clear2);
        imageButton2.setOnClickListener(view -> sem_Napitok.this.clear_two());
        ImageButton clear3 = imageButton3 = this.findViewById(R.id.clear3);
        imageButton3.setOnClickListener(view -> sem_Napitok.this.clear_tree());
        this.spirt_full = this.findViewById(R.id.spirt_full);
        this.spirt_itog = this.findViewById(R.id.spirt_itog);
        this.litr_itog = this.findViewById(R.id.litr_itog);
        this.sem_result = this.findViewById(R.id.sem_result);
        this.sem_result2 = this.findViewById(R.id.sem_result2);
    }

    @SuppressLint("ResourceType")
    public boolean onCreateOptionsMenu(Menu menu2) {
        this.getMenuInflater().inflate(R.menu.menu_saveload, menu2);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int n = menuItem.getItemId();
        //возможно ошибка
        if (n !=  R.id.home) {
            if (n != R.id.action_loaddata) {
                if (n != R.id.action_savedata) {
                    return super.onOptionsItemSelected(menuItem);
                }
                this.SaveData();
                Toast.makeText(this, R.string.toast_savedata, (int)0).show();
                return true;
            }
            this.LoadData();
            this.raschet_napitok();
            Toast.makeText(this, R.string.toast_loaddata, (int)0).show();
            return true;
        }
        this.finish();
        return true;
    }

    @SuppressLint({"WrongConstant", "DefaultLocale"})
    public void raschet_napitok() {
        String string2 = this.spirt_full.getText().toString();
        String string3 = this.spirt_itog.getText().toString();
        String string4 = this.litr_itog.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u0430 \u043d\u0430\u0447\u0430\u043b\u044c\u043d\u0430\u044f \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u044c", 0).show();
            this.spirt_full.requestFocus();
            return;
        }
        if (string3.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u0430 \u043a\u043e\u043d\u0435\u0447\u043d\u0430\u044f \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u044c", 0).show();
            this.spirt_itog.requestFocus();
            return;
        }
        if (string4.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d \u0436\u0435\u043b\u0430\u0435\u043c\u044b\u0439 \u043e\u0431\u044a\u0435\u043c", 0).show();
            this.litr_itog.requestFocus();
            return;
        }
        double d = Double.parseDouble(string2);
        double d2 = Double.parseDouble(string3);
        double d3 = Double.parseDouble(string4);
        double[] arrd = new double[]{0.9982, 0.9967, 0.9953, 0.9938, 0.9924, 0.991, 0.9897, 0.9884, 0.9872, 0.9859, 0.9847, 0.9836, 0.9824, 0.9812, 0.98, 0.9789, 0.9778, 0.9768, 0.9759, 0.9746, 0.9736, 0.9725, 0.9714, 0.9703, 0.9692, 0.9681, 0.967, 0.9658, 0.9646, 0.9634, 0.9622, 0.961, 0.9597, 0.9584, 0.957, 0.9556, 0.9542, 0.9527, 0.9512, 0.9496, 0.948, 0.9464, 0.9448, 0.9431, 0.9413, 0.9395, 0.9377, 0.9359, 0.934, 0.9321, 0.9302, 0.9282, 0.9262, 0.9242, 0.9221, 0.92, 0.9179, 0.9157, 0.9136, 0.9114, 0.9091, 0.9069, 0.9046, 0.9023, 0.9, 0.8976, 0.8952, 0.8928, 0.8904, 0.888, 0.8855, 0.883, 0.8805, 0.8779, 0.8754, 0.8728, 0.8701, 0.8675, 0.8648, 0.862, 0.8593, 0.8565, 0.8537, 0.8508, 0.8479, 0.8449, 0.8419, 0.8389, 0.8357, 0.8325, 0.8292, 0.8259, 0.8224, 0.8189, 0.8152, 0.8114, 0.8075, 0.8033, 0.799, 0.7942, 0.7892};
        double d4 = d3 * (d2 / d);
        double d5 = d4 / 1.0;
        double d6 = d3 - d5;
        Object[] arrobject = new Object[]{d5};
        String.format("%.3f", arrobject);
        Object[] arrobject2 = new Object[]{d6};
        String.format("%.3f", arrobject2);
        int n = (int)d;
        if (n <= 100 && n >= 0) {
            int n2 = (int)d2;
            if (n2 <= 100 && n2 >= 0) {
                if (n2 > n) {
                    Toast.makeText(this.getApplicationContext(), "\u041a\u043e\u043d\u0435\u0447\u043d\u0430\u044f \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u044c \u043f\u0440\u0435\u0432\u044b\u0448\u0430\u0435\u0442 \u043d\u0430\u0447\u0430\u043b\u044c\u043d\u0443\u044e", 0).show();
                    this.spirt_itog.requestFocus();
                    this.spirt_itog.selectAll();
                    return;
                }
                double d7 = d5 * arrd[n];
                double d8 = d3 * arrd[n2] - d7;
                Object[] arrobject3 = new Object[]{d4};
                String string5 = String.format("%.3f", arrobject3);
                Object[] arrobject4 = new Object[]{d8};
                String string6 = String.format("%.3f", arrobject4);
                Log.d("xS", string5);
                Log.d("xV", string6);
                this.sem_result.setText(string5);
                this.sem_result2.setText(string6);
                ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.raschet.getWindowToken(), 2);
                return;
            }
            Toast.makeText(this.getApplicationContext(), "\u041f\u0440\u043e\u0432\u0435\u0440\u044c\u0442\u0435 \u043a\u043e\u043d\u0435\u0447\u043d\u0443\u044e \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u044c", 0).show();
            this.spirt_itog.requestFocus();
            this.spirt_itog.selectAll();
            return;
        }
        Toast.makeText(this.getApplicationContext(), "\u041f\u0440\u043e\u0432\u0435\u0440\u044c\u0442\u0435 \u043d\u0430\u0447\u0430\u043b\u044c\u043d\u0443\u044e \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u044c", 0).show();
        this.spirt_full.requestFocus();
        this.spirt_full.selectAll();
    }

}


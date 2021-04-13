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

public class sem_smeshivanie extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    private double DP1;
    private double DP2;
    private double Vol1;
    private double Vol2;
    private double dVol;
    private EditText full1;
    private EditText full2;
    SharedPreferences mSettings;
    private Button raschet;
    private TextView spirt_itog;
    private TextView spirt_itog2;
    private EditText strong1;
    private EditText strong2;

    private void clear_four() {
        this.strong2.setText(null);
        this.strong2.requestFocus();
    }

    private void clear_one() {
        this.full1.setText(null);
        this.full1.requestFocus();
    }

    private void clear_tree() {
        this.full2.setText(null);
        this.full2.requestFocus();
    }

    private void clear_two() {
        this.strong1.setText(null);
        this.strong1.requestFocus();
    }

    void LoadData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        this.full1.setText(sharedPreferences.getString("smeshivanie_1", ""));
        this.strong1.setText(this.mSettings.getString("smeshivanie_2", ""));
        this.full2.setText(this.mSettings.getString("smeshivanie_3", ""));
        this.strong2.setText(this.mSettings.getString("smeshivanie_4", ""));
    }

    void SaveData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("smeshivanie_1", this.full1.getText().toString());
        editor.putString("smeshivanie_2", this.strong1.getText().toString());
        editor.putString("smeshivanie_3", this.full2.getText().toString());
        editor.putString("smeshivanie_4", this.strong2.getText().toString());
        editor.apply();
    }

    protected void onCreate(Bundle bundle) {
        ImageButton imageButton;
        ImageButton imageButton2;
        ImageButton imageButton3;
        ImageButton imageButton4;
        Button button;
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_sem_smeshivanie);
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.raschet = button = this.findViewById(R.id.raschet);
        button.setOnClickListener(view -> sem_smeshivanie.this.raschet_smeshivanie());
        ImageButton clear1 = imageButton = this.findViewById(R.id.clear1);
        imageButton.setOnClickListener(view -> sem_smeshivanie.this.clear_one());
        ImageButton clear2 = imageButton2 = this.findViewById(R.id.clear2);
        imageButton2.setOnClickListener(view -> sem_smeshivanie.this.clear_two());
        ImageButton clear3 = imageButton3 = this.findViewById(R.id.clear3);
        imageButton3.setOnClickListener(view -> sem_smeshivanie.this.clear_tree());
        ImageButton clear4 = imageButton4 = this.findViewById(R.id.clear4);
        imageButton4.setOnClickListener(view -> sem_smeshivanie.this.clear_four());
        this.full1 = this.findViewById(R.id.full1);
        this.full2 = this.findViewById(R.id.full2);
        this.strong1 = this.findViewById(R.id.strong1);
        this.strong2 = this.findViewById(R.id.strong2);
        this.spirt_itog = this.findViewById(R.id.spirt_itog);
        this.spirt_itog2 = this.findViewById(R.id.spirt_itog2);
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
                this.SaveData();
                Toast.makeText(this, R.string.toast_savedata, (int)0).show();
                return true;
            }
            this.LoadData();
            this.raschet_smeshivanie();
            Toast.makeText(this, R.string.toast_loaddata, (int)0).show();
            return true;
        }
        this.finish();
        return true;
    }

    @SuppressLint({"DefaultLocale", "WrongConstant"})
    public void raschet_smeshivanie() {
        String string2 = this.full1.getText().toString();
        String string3 = this.full2.getText().toString();
        String string4 = this.strong1.getText().toString();
        String string5 = this.strong2.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d \u043e\u0431\u044a\u0435\u043c \u0436\u0438\u0434\u043a\u043e\u0441\u0442\u0438 1", 0).show();
            this.full1.requestFocus();
            return;
        }
        if (string3.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d \u043e\u0431\u044a\u0435\u043c \u0436\u0438\u0434\u043a\u043e\u0441\u0442\u0438 2", 0).show();
            this.full2.requestFocus();
            return;
        }
        if (string4.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u0430 \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u044c \u0436\u0438\u0434\u043a\u043e\u0441\u0442\u0438 1", 0).show();
            this.strong1.requestFocus();
            return;
        }
        if (string5.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u0430 \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u044c \u0436\u0438\u0434\u043a\u043e\u0441\u0442\u0438 2", 0).show();
            this.strong2.requestFocus();
            return;
        }
        double d = Double.parseDouble(string2);
        double d2 = Double.parseDouble(string3);
        double d3 = Double.parseDouble(string4);
        double d4 = Double.parseDouble(string5);
        double[] arrd = new double[]{0.9982, 0.9967, 0.9953, 0.9938, 0.9924, 0.991, 0.9897, 0.9884, 0.9872, 0.9859, 0.9847, 0.9836, 0.9824, 0.9812, 0.98, 0.9789, 0.9778, 0.9768, 0.9759, 0.9746, 0.9736, 0.9725, 0.9714, 0.9703, 0.9692, 0.9681, 0.967, 0.9658, 0.9646, 0.9634, 0.9622, 0.961, 0.9597, 0.9584, 0.957, 0.9556, 0.9542, 0.9527, 0.9512, 0.9496, 0.948, 0.9464, 0.9448, 0.9431, 0.9413, 0.9395, 0.9377, 0.9359, 0.934, 0.9321, 0.9302, 0.9282, 0.9262, 0.9242, 0.9221, 0.92, 0.9179, 0.9157, 0.9136, 0.9114, 0.9091, 0.9069, 0.9046, 0.9023, 0.9, 0.8976, 0.8952, 0.8928, 0.8904, 0.888, 0.8855, 0.883, 0.8805, 0.8779, 0.8754, 0.8728, 0.8701, 0.8675, 0.8648, 0.862, 0.8593, 0.8565, 0.8537, 0.8508, 0.8479, 0.8449, 0.8419, 0.8389, 0.8357, 0.8325, 0.8292, 0.8259, 0.8224, 0.8189, 0.8152, 0.8114, 0.8075, 0.8033, 0.799, 0.7942, 0.7892};
        double[] arrd2 = new double[]{0.0, 0.9967, 0.49765, 0.331266667, 0.2481, 0.1982, 0.16495, 0.1412, 0.1234, 0.109544444, 0.09847, 0.089418182, 0.081866667, 0.075476923, 0.07, 0.06526, 0.0611125, 0.057458824, 0.054216667, 0.051294737, 0.04868, 0.046309524, 0.044154545, 0.042186957, 0.040383333, 0.038724, 0.037192308, 0.03577037, 0.03445, 0.03322069, 0.032073333, 0.031, 0.029990625, 0.029042424, 0.028147059, 0.027302857, 0.026505556, 0.025748649, 0.025031579, 0.024348718, 0.0237, 0.023082927, 0.022495238, 0.021932558, 0.021393182, 0.020877778, 0.020384783, 0.019912766, 0.019458333, 0.019022449, 0.018604, 0.0182, 0.017811538, 0.017437736, 0.017075926, 0.016727273, 0.016391071, 0.016064912, 0.015751724, 0.015447458, 0.015151667, 0.014867213, 0.014590323, 0.014322222, 0.0140625, 0.013809231, 0.013563636, 0.013325373, 0.013094118, 0.012869565, 0.01265, 0.01243662, 0.012229167, 0.012026027, 0.01182973, 0.011637333, 0.011448684, 0.011266234, 0.011087179, 0.010911392, 0.01074125, 0.010574074, 0.010410976, 0.010250602, 0.010094048, 0.00994, 0.009789535, 0.009642529, 0.009496591, 0.009353933, 0.009213333, 0.009075824, 0.00893913, 0.008805376, 0.00867234, 0.008541053, 0.008411458, 0.008281443, 0.008153061, 0.008022222, 0.007892};
        double d5 = d * d3 + d2 * d4;
        double d6 = d + d2;
        double d7 = d5 / d6;
        Object[] arrobject = new Object[]{d7};
        String.format("%.2f", arrobject);
        Object[] arrobject2 = new Object[]{d6};
        String.format("%.3f", arrobject2);
        int n = (int)d3;
        int n2 = (int)d4;
        double d8 = arrd[n];
        double d9 = arrd[n2];
        double d10 = (d * d8 + d2 * d9) / d5;
        for (int i = 1; i < 100; ++i) {
            int n3;
            if (!(arrd2[i] > d10) || !(arrd2[n3 = i + 1] < d10)) continue;
            this.DP1 = arrd2[i];
            this.DP2 = arrd2[n3];
            this.Vol1 = i;
            this.Vol2 = n3;
        }
        double d11 = this.DP2;
        double d12 = this.DP1;
        double d13 = d11 - d12;
        double d14 = this.Vol2;
        double d15 = this.Vol1;
        double d16 = d15 + (d14 - d15) / d13 * (d10 - d12);
        double d17 = d5 / d16;
        Object[] arrobject3 = new Object[]{d16};
        String string6 = String.format("%.2f", arrobject3);
        Object[] arrobject4 = new Object[]{d17};
        String string7 = String.format("%.3f", arrobject4);
        TextView textView = this.spirt_itog;
        String stringBuilder = string6 +
                "%";
        textView.setText(stringBuilder);
        this.spirt_itog2.setText(string7);
        ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.raschet.getWindowToken(), 2);
    }

}


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

public class sem_razbavka extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    private Button button;
    private TextView info;
    SharedPreferences mSettings;
    private TextView sem_result;
    private TextView sem_result_full;
    private EditText spirt_full;
    private EditText spirt_strong1;
    private EditText spirt_strong2;

    private void clear_one() {
        this.spirt_full.setText(null);
        this.spirt_full.requestFocus();
    }

    private void clear_tree() {
        this.spirt_strong2.setText(null);
        this.spirt_strong2.requestFocus();
    }

    private void clear_two() {
        this.spirt_strong1.setText(null);
        this.spirt_strong1.requestFocus();
    }

    void LoadData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        this.spirt_full.setText(sharedPreferences.getString("razbavka_1", ""));
        this.spirt_strong1.setText(this.mSettings.getString("razbavka_2", ""));
        this.spirt_strong2.setText(this.mSettings.getString("razbavka_3", ""));
    }

    void SaveData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("razbavka_1", this.spirt_full.getText().toString());
        editor.putString("razbavka_2", this.spirt_strong1.getText().toString());
        editor.putString("razbavka_3", this.spirt_strong2.getText().toString());
        editor.apply();
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        ImageButton imageButton;
        ImageButton imageButton2;
        ImageButton imageButton3;
        Button button;
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_sem_razbavka);
        ActionBar actionBar = this.getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.button = button = this.findViewById(R.id.button);
        button.setOnClickListener(view -> sem_razbavka.this.raschet_razbavka());
        ImageButton clear1 = imageButton = this.findViewById(R.id.clear1);
        imageButton.setOnClickListener(view -> sem_razbavka.this.clear_one());
        ImageButton clear2 = imageButton2 = this.findViewById(R.id.clear2);
        imageButton2.setOnClickListener(view -> sem_razbavka.this.clear_two());
        ImageButton clear3 = imageButton3 = this.findViewById(R.id.clear3);
        imageButton3.setOnClickListener(view -> sem_razbavka.this.clear_tree());
        this.spirt_full = this.findViewById(R.id.spirt_full);
        this.spirt_strong1 = this.findViewById(R.id.spirt_strong1);
        this.spirt_strong2 = this.findViewById(R.id.spirt_strong2);
        this.sem_result = this.findViewById(R.id.sem_result);
        this.sem_result_full = this.findViewById(R.id.sem_result_full);
        this.info = this.findViewById(R.id.info);
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
                Toast.makeText(this, R.string.toast_savedata, (int)0).show();
                return true;
            }
            this.LoadData();
            this.raschet_razbavka();
            Toast.makeText(this, R.string.toast_loaddata, (int)0).show();
            return true;
        }
        this.finish();
        return true;
    }

    @SuppressLint({"ResourceType", "DefaultLocale"})
    public void raschet_razbavka() {
        String string2 = this.spirt_full.getText().toString();
        String string3 = this.spirt_strong1.getText().toString();
        String string4 = this.spirt_strong2.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d \u043e\u0431\u044a\u0435\u043c \u043f\u0440\u043e\u0434\u0443\u043a\u0442\u0430!", 0).show();
            this.spirt_full.requestFocus();
            return;
        }
        if (string3.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u043d\u0430\u0447\u0430\u043b\u044c\u043d\u043e\u0439 \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u0438", 0).show();
            this.spirt_strong1.requestFocus();
            return;
        }
        if (string4.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u043a\u043e\u043d\u0435\u0447\u043d\u043e\u0439 \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u0438", 0).show();
            this.spirt_strong2.requestFocus();
            return;
        }
        double d = Double.parseDouble(string2);
        double d2 = Double.parseDouble(string3);
        double d3 = Double.parseDouble(string4);
        double[] arrd = new double[]{0.9982, 0.9967, 0.9953, 0.9938, 0.9924, 0.991, 0.9897, 0.9884, 0.9872, 0.9859, 0.9847, 0.9836, 0.9824, 0.9812, 0.98, 0.9789, 0.9778, 0.9768, 0.9759, 0.9746, 0.9736, 0.9725, 0.9714, 0.9703, 0.9692, 0.9681, 0.967, 0.9658, 0.9646, 0.9634, 0.9622, 0.961, 0.9597, 0.9584, 0.957, 0.9556, 0.9542, 0.9527, 0.9512, 0.9496, 0.948, 0.9464, 0.9448, 0.9431, 0.9413, 0.9395, 0.9377, 0.9359, 0.934, 0.9321, 0.9302, 0.9282, 0.9262, 0.9242, 0.9221, 0.92, 0.9179, 0.9157, 0.9136, 0.9114, 0.9091, 0.9069, 0.9046, 0.9023, 0.9, 0.8976, 0.8952, 0.8928, 0.8904, 0.888, 0.8855, 0.883, 0.8805, 0.8779, 0.8754, 0.8728, 0.8701, 0.8675, 0.8648, 0.862, 0.8593, 0.8565, 0.8537, 0.8508, 0.8479, 0.8449, 0.8419, 0.8389, 0.8357, 0.8325, 0.8292, 0.8259, 0.8224, 0.8189, 0.8152, 0.8114, 0.8075, 0.8033, 0.799, 0.7942, 0.7892};
        double d4 = d2 / d3;
        double d5 = d4 * d - d;
        Object[] arrobject = new Object[]{d5};
        String.format("%.3f", arrobject);
        int n = (int) d2;
        int n2 = 100;
        if (n <= n2 && n >= 0) {
            int n3 = (int) d3;
            if (n3 <= n2 && n3 >= 0) {
                double d6;
                double d7;
                double d8;
                if (n3 > n) {
                    Toast.makeText(this.getApplicationContext(), "\u041a\u043e\u043d\u0435\u0447\u043d\u0430\u044f \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u044c \u043f\u0440\u0435\u0432\u044b\u0448\u0430\u0435\u0442 \u043d\u0430\u0447\u0430\u043b\u044c\u043d\u0443\u044e", 0).show();
                    this.spirt_strong2.requestFocus();
                    this.spirt_strong2.selectAll();
                    return;
                }
                double d9 = arrd[n];
                double d10 = arrd[n3];
                double d11 = d / 0.9982 * (d10 * d4 - d9);
                Object[] arrobject2 = new Object[]{d11};
                String string5 = String.format("%.3f", arrobject2);
                this.sem_result.setText(string5);
                double d12 = d11 + d;
                TextView textView = this.sem_result_full;
                Object[] arrobject3 = new Object[]{d12};
                String stringBuilder = "~" +
                        String.format("%.3f", arrobject3);
                textView.setText(stringBuilder);
                double[] arrd2 = new double[]{0.0, 0.9967, 0.49765, 0.331266667, 0.2481, 0.1982, 0.16495, 0.1412, 0.1234, 0.109544444, 0.09847, 0.089418182, 0.081866667, 0.075476923, 0.07, 0.06526, 0.0611125, 0.057458824, 0.054216667, 0.051294737, 0.04868, 0.046309524, 0.044154545, 0.042186957, 0.040383333, 0.038724, 0.037192308, 0.03577037, 0.03445, 0.03322069, 0.032073333, 0.031, 0.029990625, 0.029042424, 0.028147059, 0.027302857, 0.026505556, 0.025748649, 0.025031579, 0.024348718, 0.0237, 0.023082927, 0.022495238, 0.021932558, 0.021393182, 0.020877778, 0.020384783, 0.019912766, 0.019458333, 0.019022449, 0.018604, 0.0182, 0.017811538, 0.017437736, 0.017075926, 0.016727273, 0.016391071, 0.016064912, 0.015751724, 0.015447458, 0.015151667, 0.014867213, 0.014590323, 0.014322222, 0.0140625, 0.013809231, 0.013563636, 0.013325373, 0.013094118, 0.012869565, 0.01265, 0.01243662, 0.012229167, 0.012026027, 0.01182973, 0.011637333, 0.011448684, 0.011266234, 0.011087179, 0.010911392, 0.01074125, 0.010574074, 0.010410976, 0.010250602, 0.010094048, 0.00994, 0.009789535, 0.009642529, 0.009496591, 0.009353933, 0.009213333, 0.009075824, 0.00893913, 0.008805376, 0.00867234, 0.008541053, 0.008411458, 0.008281443, 0.008153061, 0.008022222, 0.007892};
                double d13 = arrd[n];
                double d14 = arrd[0];
                double d15 = d13 * d + d14 * d11;
                Double.isNaN((double) n);
                double d17 = d * (double) n;
                //хз
                double d18 = 0;
                Double.isNaN(d18);
                double d19 = d17 + d11 * d18;
                double d20 = d15 / d19;
                double d21 = d8 = (d6 = (d7 = 0.0));
                for (int i = 1; i < n2; ++i) {
                    int n4;
                    double[] arrd3;
                    if (arrd2[i] >= d20 && arrd2[n4 = i + 1] < d20) {
                        double d22 = arrd2[i];
                        double d23 = arrd2[n4];
                        arrd3 = arrd2;
                        d21 = i;
                        d8 = n4;
                        d7 = d23;
                        d6 = d22;
                    } else {
                        arrd3 = arrd2;
                    }
                    arrd2 = arrd3;
                    n2 = 100;
                }
                double d26 = d7 - d6;
                double d27 = d19 / (d21 + (d8 - d21) / d26 * (d20 - d6));
                TextView textView2 = this.sem_result_full;
                Object[] arrobject4 = new Object[]{d27};
                textView2.setText(String.format("%.3f", arrobject4));
                ((InputMethodManager) this.getSystemService("input_method")).hideSoftInputFromWindow(this.button.getWindowToken(), 2);
                this.info.setText(R.string.sem_infoRazbavka);
                return;
            }
            Toast.makeText(this.getApplicationContext(), "\u041f\u0440\u043e\u0432\u0435\u0440\u044c\u0442\u0435 \u043a\u043e\u043d\u0435\u0447\u043d\u0443\u044e \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u044c", 0).show();
            this.spirt_strong2.requestFocus();
            this.spirt_strong2.selectAll();
            return;
        }
        Toast.makeText(this.getApplicationContext(), "\u041f\u0440\u043e\u0432\u0435\u0440\u044c\u0442\u0435 \u043d\u0430\u0447\u0430\u043b\u044c\u043d\u0443\u044e \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u044c", 0).show();
        this.spirt_strong1.requestFocus();
        this.spirt_strong1.selectAll();
    }

}


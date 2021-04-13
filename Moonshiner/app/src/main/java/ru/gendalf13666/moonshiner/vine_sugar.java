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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class vine_sugar extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    private Button button;
    SharedPreferences mSettings;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch strongtosugar;
    private EditText vinestrong_finish;
    private TextView vinesugar_full;
    private TextView vinesugar_need;
    private EditText vinesugar_start;
    private EditText vinesus_full;

    @SuppressLint({"WrongConstant", "DefaultLocale"})
    private void vinesugar_raschet() {
        String string2 = this.vinesus_full.getText().toString();
        String string3 = this.vinesugar_start.getText().toString();
        String string4 = this.vinestrong_finish.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d \u043e\u0431\u044a\u0435\u043c \u043f\u0440\u043e\u0434\u0443\u043a\u0442\u0430!", (int) 0).show();
            this.vinesus_full.requestFocus();
            return;
        }
        if (string3.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u043d\u0430\u0447\u0430\u043b\u044c\u043d\u043e\u0439 \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u0438", (int) 0).show();
            this.vinesugar_start.requestFocus();
            return;
        }
        if (string4.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u043a\u043e\u043d\u0435\u0447\u043d\u043e\u0439 \u043a\u0440\u0435\u043f\u043e\u0441\u0442\u0438", (int) 0).show();
            this.vinestrong_finish.requestFocus();
            return;
        }
        double d = Double.parseDouble(string2);
        double d2 = Double.parseDouble(string3);
        double d3 = Double.parseDouble(string4);
        if (this.strongtosugar.isChecked()) {
            double d4 = (d3 * d - d * d2) / 100.0;
            TextView textView = this.vinesugar_need;
            Object[] arrobject = new Object[]{d4};
            textView.setText(String.format("%.3f", arrobject));
            this.vinesugar_full.setText("");
        } else {
            double d5 = d3 * 1.7;
            double d6 = d * (10.0 * (d5 - d2)) / 1000.0;
            TextView textView = this.vinesugar_need;
            Object[] arrobject = new Object[]{d6};
            textView.setText(String.format("%.3f", arrobject));
            TextView textView2 = this.vinesugar_full;
            Object[] arrobject2 = new Object[]{d5};
            textView2.setText(String.format("%.1f", arrobject2));
        }
        ((InputMethodManager) this.getSystemService("input_method")).hideSoftInputFromWindow(this.button.getWindowToken(), 2);
    }

    void LoadData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        this.vinesus_full.setText(sharedPreferences.getString("vinesugar_1", ""));
        this.vinesugar_start.setText(this.mSettings.getString("vinesugar_2", ""));
        this.vinestrong_finish.setText(this.mSettings.getString("vinesugar_3", ""));
        this.strongtosugar.setChecked(this.mSettings.getBoolean("vinesugar_4", false));
    }

    void SaveData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("vinesugar_1", this.vinesus_full.getText().toString());
        editor.putString("vinesugar_2", this.vinesugar_start.getText().toString());
        editor.putString("vinesugar_3", this.vinestrong_finish.getText().toString());
        editor.putBoolean("vinesugar_4", this.strongtosugar.isChecked());
        editor.apply();
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        ImageButton imageButton;
        ImageButton imageButton2;
        ImageButton imageButton3;
        Button button;
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_vine_sugar);
        ActionBar actionBar = this.getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.vinesus_full = this.findViewById(R.id.vinesus_full);
        this.vinesugar_start = this.findViewById(R.id.vinesugar_start);
        this.vinestrong_finish = this.findViewById(R.id.vinestrong_finish);
        this.vinesugar_need = this.findViewById(R.id.vinesugar_need);
        this.vinesugar_full = this.findViewById(R.id.vinesugar_full);
        this.strongtosugar = this.findViewById(R.id.strongtosugar);
        this.button = button = this.findViewById(R.id.button);
        button.setOnClickListener(view -> vine_sugar.this.vinesugar_raschet());
        ImageButton clear1 = imageButton = this.findViewById(R.id.clear1);
        imageButton.setOnClickListener(view -> {
            vine_sugar.this.vinesus_full.setText(null);
            vine_sugar.this.vinesus_full.requestFocus();
        });
        ImageButton clear2 = imageButton2 = this.findViewById(R.id.clear2);
        imageButton2.setOnClickListener(view -> {
            vine_sugar.this.vinesugar_start.setText(null);
            vine_sugar.this.vinesugar_start.requestFocus();
        });
        ImageButton clear3 = imageButton3 = this.findViewById(R.id.clear3);
        imageButton3.setOnClickListener(view -> {
            vine_sugar.this.vinestrong_finish.setText(null);
            vine_sugar.this.vinestrong_finish.requestFocus();
        });
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
                Toast.makeText(this, R.string.toast_savedata, (int) 0).show();
                return true;
            }
            this.LoadData();
            vine_sugar.this.vinesugar_raschet();
            Toast.makeText(this, R.string.toast_loaddata, (int) 0).show();
            return true;
        }
        this.finish();
        return true;
    }

}


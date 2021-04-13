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

public class sem_temperature extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    private EditText full1;
    private EditText full2;
    SharedPreferences mSettings;
    private TextView mix_itog;
    private Button raschet;
    private EditText temp1;
    private EditText temp2;

    private void clear1() {
        this.full1.setText(null);
        this.full1.requestFocus();
    }

    private void clear2() {
        this.temp2.setText(null);
        this.temp2.requestFocus();
    }

    private void clear3() {
        this.full2.setText(null);
        this.full2.requestFocus();
    }

    private void clear4() {
        this.temp2.setText(null);
        this.temp2.requestFocus();
    }

    @SuppressLint({"WrongConstant", "DefaultLocale"})
    private void raschet_mix() {
        String string2 = this.full1.getText().toString();
        String string3 = this.temp1.getText().toString();
        String string4 = this.full2.getText().toString();
        String string5 = this.temp2.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d \u043e\u0431\u044a\u0435\u043c \u0436\u0438\u0434\u043a\u043e\u0441\u0442\u0438 1", (int)0).show();
            this.full1.requestFocus();
            return;
        }
        if (string3.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0442\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u044b \u0436\u0438\u0434\u043a\u043e\u0441\u0442\u0438 1", (int)0).show();
            this.temp1.requestFocus();
            return;
        }
        if (string4.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d \u043e\u0431\u044a\u0435\u043c \u0436\u0438\u0434\u043a\u043e\u0441\u0442\u0438 2", (int)0).show();
            this.full2.requestFocus();
            return;
        }
        if (string5.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0442\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u044b \u0436\u0438\u0434\u043a\u043e\u0441\u0442\u0438 2", (int)0).show();
            this.temp2.requestFocus();
            return;
        }
        double d = Double.parseDouble(string3);
        double d2 = Double.parseDouble(string2);
        double d3 = Double.parseDouble(string5);
        double d4 = Double.parseDouble(string4);
        double d5 = (d * d2 + d3 * d4) / (d2 + d4);
        TextView textView = this.mix_itog;
        Object[] arrobject = new Object[]{d5};
        textView.setText(String.format("%.1f", arrobject));
        ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.raschet.getWindowToken(), 2);
    }

    void LoadData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        this.full1.setText(sharedPreferences.getString("temperature_1", ""));
        this.temp1.setText(this.mSettings.getString("temperature_2", ""));
        this.full2.setText(this.mSettings.getString("temperature_3", ""));
        this.temp2.setText(this.mSettings.getString("temperature_4", ""));
    }

    void SaveData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("temperature_1", this.full1.getText().toString());
        editor.putString("temperature_2", this.temp1.getText().toString());
        editor.putString("temperature_3", this.full2.getText().toString());
        editor.putString("temperature_4", this.temp2.getText().toString());
        editor.apply();
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_sem_temperature);
        ActionBar actionBar = this.getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.raschet = this.findViewById(R.id.raschet);
        ImageButton clear1 = this.findViewById(R.id.clear1);
        ImageButton clear2 = this.findViewById(R.id.clear2);
        ImageButton clear3 = this.findViewById(R.id.clear3);
        ImageButton clear4 = this.findViewById(R.id.clear4);
        this.full1 = this.findViewById(R.id.full1);
        this.full2 = this.findViewById(R.id.full2);
        this.temp1 = this.findViewById(R.id.temp1);
        this.temp2 = this.findViewById(R.id.temp2);
        this.mix_itog = this.findViewById(R.id.mix_itog);
        this.raschet.setOnClickListener(view -> sem_temperature.this.raschet_mix());
        clear1.setOnClickListener(view -> sem_temperature.this.clear1());
        clear2.setOnClickListener(view -> sem_temperature.this.clear2());
        clear3.setOnClickListener(view -> sem_temperature.this.clear3());
        clear4.setOnClickListener(view -> sem_temperature.this.clear4());
    }

    @SuppressLint("ResourceType")
    public boolean onCreateOptionsMenu(Menu menu2) {
        this.getMenuInflater().inflate(R.menu.menu_saveload, menu2);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int n = menuItem.getItemId();
        if (n != R.id.home) {
            if (n != R.id.action_loaddata ) {
                if (n != R.id.action_savedata) {
                    return super.onOptionsItemSelected(menuItem);
                }
                this.SaveData();
                Toast.makeText(this, R.string.toast_savedata, (int)0).show();
                return true;
            }
            this.LoadData();
            sem_temperature.this.raschet_mix();
            Toast.makeText(this, R.string.toast_loaddata, (int)0).show();
            return true;
        }
        this.finish();
        return true;
    }

}


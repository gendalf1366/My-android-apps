package ru.gendalf13666.moonshiner;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class sem_Speedotbor extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    private Chronometer chronometer;
    private long elapsedMillis;
    private EditText fullvolume;
    SharedPreferences mSettings;
    private TextView sem_info;
    private TextView sem_info2;
    private TextView sem_result;
    private TextView sem_result2;
    private Switch speed_conv;
    private Button start;
    private EditText volume;

    private void clearOne() {
        this.volume.setText(null);
        this.volume.requestFocus();
    }

    private void cleartwo() {
        this.fullvolume.setText(null);
        this.fullvolume.requestFocus();
    }

    @SuppressLint({"ResourceType", "DefaultLocale", "SetTextI18n"})
    protected void onCreate(Bundle bundle) {
        ImageButton imageButton;
        ImageButton imageButton2;
        Button button;
        Button button2;
        SharedPreferences sharedPreferences;
        Button button3;
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_sem__speedotbor);
        this.getWindow().addFlags(128);
        ActionBar actionBar = this.getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.chronometer = this.findViewById(R.id.chronometer);
        this.volume = this.findViewById(R.id.sem_volume);
        this.fullvolume = this.findViewById(R.id.sem_fullvolume);
        this.sem_result = this.findViewById(R.id.sem_result);
        this.sem_result2 = this.findViewById(R.id.sem_result2);
        this.sem_info = this.findViewById(R.id.sem_info);
        this.sem_info2 = this.findViewById(R.id.sem_info2);
        this.speed_conv = this.findViewById(R.id.speed_conv);
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        this.speed_conv.setChecked(sharedPreferences.getBoolean("speedotbor_conv", false));
        if (this.speed_conv.isChecked()) {
            this.sem_info.setText(R.string.final_speed_conv);
            this.sem_info2.setText(R.string.final_time_conv);
        }
        this.chronometer.setOnChronometerTickListener(chronometer -> sem_Speedotbor.this.elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase());
        this.start = button3 = this.findViewById(R.id.start);
        button3.setOnClickListener(view -> {
            if (sem_Speedotbor.this.volume.getText().toString().length() == 0) {
                Toast.makeText(sem_Speedotbor.this.getApplicationContext(), R.string.no_enter_volume, (int)0).show();
                sem_Speedotbor.this.volume.requestFocus();
                return;
            }
            sem_Speedotbor.this.chronometer.setTextColor(Color.parseColor("#00ff00"));
            sem_Speedotbor.this.chronometer.setBase(SystemClock.elapsedRealtime());
            sem_Speedotbor.this.chronometer.start();
            ((InputMethodManager)sem_Speedotbor.this.getSystemService("input_method")).hideSoftInputFromWindow(sem_Speedotbor.this.start.getWindowToken(), 2);
        });
        Button stop = button = this.findViewById(R.id.stop);
        button.setOnClickListener(view -> {
            sem_Speedotbor.this.chronometer.setTextColor(Color.parseColor((String)"#0000ff"));
            sem_Speedotbor.this.chronometer.stop();
            double d = Double.parseDouble(sem_Speedotbor.this.volume.getText().toString()) / 1000.0;
            double d2 = (int)sem_Speedotbor.this.elapsedMillis / 1000;
            Double.isNaN(d2);
            double d3 = d2 / 60.0;
            double d4 = (float)d;
            Double.isNaN(d4);
            double d5 = d4 / d3;
            if (sem_Speedotbor.this.speed_conv.isChecked()) {
                d5 *= 60.0;
            }
            TextView textView = sem_Speedotbor.this.sem_result;
            Object[] arrobject = new Object[]{d5};
            textView.setText(String.format("%.3f", arrobject));
            if (sem_Speedotbor.this.fullvolume.getText().toString().length() > 0) {
                double d6 = Double.parseDouble(sem_Speedotbor.this.sem_result.getText().toString().replace((CharSequence)",", (CharSequence)"."));
                double d7 = 60.0 * (Double.parseDouble(sem_Speedotbor.this.fullvolume.getText().toString()) / 1000.0 / d6);
                double d8 = (int)d7 / 60;
                double d9 = d7 % 60.0;
                String string2 = "" +
                        (int) d8;
                String string3 = "" +
                        (int) d9;
                if (string2.length() == 1) {
                    string2 = "0" +
                            string2;
                }
                if (string3.length() == 1) {
                    string3 = "0" +
                            string3;
                }
                TextView textView2 = sem_Speedotbor.this.sem_result2;
                String stringBuilder5 = string2 +
                        ":" +
                        string3;
                textView2.setText(stringBuilder5);
            }
            ((InputMethodManager)sem_Speedotbor.this.getSystemService("input_method")).hideSoftInputFromWindow(sem_Speedotbor.this.start.getWindowToken(), 2);
        });
        Button reset = button2 = this.findViewById(R.id.reset);
        button2.setOnClickListener(view -> {
            sem_Speedotbor.this.chronometer.setTextColor(Color.parseColor("#888888"));
            sem_Speedotbor.this.chronometer.setBase(SystemClock.elapsedRealtime());
            sem_Speedotbor.this.sem_result.setText("000");
            sem_Speedotbor.this.sem_result2.setText("00:00");
        });
        ImageButton clear1 = imageButton = this.findViewById(R.id.clear1);
        imageButton.setOnClickListener(view -> sem_Speedotbor.this.clearOne());
        ImageButton clear2 = imageButton2 = this.findViewById(R.id.clear2);
        imageButton2.setOnClickListener(view -> sem_Speedotbor.this.cleartwo());
        this.speed_conv.setOnCheckedChangeListener((compoundButton, bl) -> {
            if (bl) {
                sem_Speedotbor sem_Speedotbor2 = sem_Speedotbor.this;
                sem_Speedotbor2.mSettings = sem_Speedotbor2.getSharedPreferences(sem_Speedotbor.APP_PREFERENCES, 0);
                SharedPreferences.Editor editor = sem_Speedotbor.this.mSettings.edit();
                editor.putBoolean("speedotbor_conv", sem_Speedotbor.this.speed_conv.isChecked());
                editor.apply();
                sem_Speedotbor.this.sem_info.setText(R.string.final_speed_conv);
                sem_Speedotbor.this.sem_info2.setText(R.string.final_time_conv);
                return;
            }
            sem_Speedotbor sem_Speedotbor3 = sem_Speedotbor.this;
            sem_Speedotbor3.mSettings = sem_Speedotbor3.getSharedPreferences(sem_Speedotbor.APP_PREFERENCES, 0);
            SharedPreferences.Editor editor = sem_Speedotbor.this.mSettings.edit();
            editor.putBoolean("speedotbor_conv", sem_Speedotbor.this.speed_conv.isChecked());
            editor.apply();
            sem_Speedotbor.this.sem_info.setText(R.string.final_speed );
            sem_Speedotbor.this.sem_info2.setText(R.string.final_time);
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() !=  R.id.home) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.finish();
        return true;
    }

}


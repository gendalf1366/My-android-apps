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

public class sem_SugarBraga extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    public double alcostrong;
    public ImageButton clear1;
    public ImageButton clear2;
    public TextView info;
    SharedPreferences mSettings;
    public Button raschet;
    public EditText semMixVolume;
    public TextView semResult;
    public TextView semResult2;
    public EditText semSugar;
    public double sugar;
    public double watermix;
    public double waterneed;

    private void LoadData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        this.semSugar.setText(sharedPreferences.getString("sugarbraga_1", ""));
        this.semMixVolume.setText(this.mSettings.getString("sugarbraga_2", ""));
    }

    private void SaveData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("sugarbraga_1", this.semSugar.getText().toString());
        editor.putString("sugarbraga_2", this.semMixVolume.getText().toString());
        editor.apply();
    }

    @SuppressLint({"ResourceType", "DefaultLocale"})
    private void SugarBraga() {
        double d;
        double d2;
        this.info.setText(null);
        String string2 = this.semSugar.getText().toString();
        String string3 = this.semMixVolume.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u0430 \u043c\u0430\u0441\u0441\u0430 \u0441\u0430\u0445\u0430\u0440\u0430", (int)0).show();
            this.semSugar.requestFocus();
            return;
        }
        if (string3.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d \u043e\u0431\u044a\u0435\u043c \u0441\u043c\u0435\u0441\u0438", (int)0).show();
            this.semMixVolume.requestFocus();
            return;
        }
        this.sugar = Double.parseDouble(this.semSugar.getText().toString());
        this.watermix = d = Double.parseDouble(this.semMixVolume.getText().toString());
        double d3 = this.sugar;
        this.alcostrong = d2 = 0.91875 * (0.64 * d3 / (d / 100.0));
        this.waterneed = d - d3 * 0.615;
        TextView textView = this.semResult;
        Object[] arrobject = new Object[]{d2};
        textView.setText(String.format("%.1f", arrobject));
        TextView textView2 = this.semResult2;
        Object[] arrobject2 = new Object[]{this.waterneed};
        textView2.setText(String.format((String)"%.3f", arrobject2));
        double d4 = this.watermix / this.sugar;
        if (d4 < 3.0) {
            this.info.setText(R.string.semInfo_highHydromodule);
        }
        if (d4 > 5.0) {
            this.info.setText(R.string.semInfo_highWater);
        }
        ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.raschet.getWindowToken(), 2);
    }

    private void clear_one() {
        this.semSugar.setText(null);
        this.semSugar.requestFocus();
    }

    private void clear_two() {
        this.semMixVolume.setText(null);
        this.semMixVolume.requestFocus();
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        ImageButton imageButton;
        ImageButton imageButton2;
        Button button;
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_sem__sugar_braga);
        ActionBar actionBar = this.getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.semSugar = this.findViewById(R.id.sem_sugar);
        this.semMixVolume = this.findViewById(R.id.sem_mixvolume);
        this.semResult = this.findViewById(R.id.sem_result);
        this.semResult2 = this.findViewById(R.id.sem_result2);
        this.info = this.findViewById(R.id.sem_info);
        this.raschet = button = this.findViewById(R.id.raschet);
        button.setOnClickListener(view -> sem_SugarBraga.this.SugarBraga());
        this.clear1 = imageButton = this.findViewById(R.id.clear1);
        imageButton.setOnClickListener(view -> sem_SugarBraga.this.clear_one());
        this.clear2 = imageButton2 = this.findViewById(R.id.clear2);
        imageButton2.setOnClickListener(view -> sem_SugarBraga.this.clear_two());
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
                sem_SugarBraga.this.SaveData();
                Toast.makeText(this, R.string.toast_savedata, (int)0).show();
                return true;
            }
            sem_SugarBraga.this.LoadData();
            sem_SugarBraga.this.SugarBraga();
            Toast.makeText(this, R.string.toast_loaddata, (int)0).show();
            return true;
        }
        this.finish();
        return true;
    }

}


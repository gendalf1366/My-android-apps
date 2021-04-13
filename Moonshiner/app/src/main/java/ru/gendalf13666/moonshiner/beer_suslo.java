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

public class beer_suslo extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    public ImageButton clear1;
    public ImageButton clear2;
    public ImageButton clear3;
    public double extr;
    public EditText extract;
    SharedPreferences mSettings;
    public EditText nachplot;
    public double plot;
    public Button raschet;
    public double rez;
    public TextView rezult;
    public EditText suslovol;
    public double vol;

    private void LoadData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        this.suslovol.setText(sharedPreferences.getString("beersuslo_vol", ""));
        this.nachplot.setText(this.mSettings.getString("beersuslo_plot", ""));
        this.extract.setText(this.mSettings.getString("beersuslo_extr", ""));
    }

    private void SaveData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("beersuslo_vol", this.suslovol.getText().toString());
        editor.putString("beersuslo_plot", this.nachplot.getText().toString());
        editor.putString("beersuslo_extr", this.extract.getText().toString());
        editor.apply();
    }

    @SuppressLint({"WrongConstant", "DefaultLocale"})
    private void beerSuslo() {
        double d;
        double d2;
        if (this.suslovol.getText().toString().length() == 0) {
            Toast.makeText(this.getApplicationContext(), "ERROR DATA", (int)0).show();
            this.suslovol.requestFocus();
            return;
        }
        if (this.nachplot.getText().toString().length() == 0) {
            Toast.makeText(this.getApplicationContext(), "ERROR DATA", (int)0).show();
            this.nachplot.requestFocus();
            return;
        }
        if (this.extract.getText().toString().length() == 0) {
            Toast.makeText(this.getApplicationContext(), "ERROR DATA", (int)0).show();
            this.extract.requestFocus();
            return;
        }
        this.vol = Double.parseDouble(this.suslovol.getText().toString().replace(",", "."));
        this.plot = Double.parseDouble(this.nachplot.getText().toString().replace(",", "."));
        this.extr = d = Double.parseDouble(this.extract.getText().toString().replace(",", "."));
        this.rez = d2 = this.vol * (this.plot / 100.0) / (d / 100.0);
        TextView textView = this.rezult;
        Object[] arrobject = new Object[]{d2};
        textView.setText(String.format("%.3f", arrobject));
        ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.raschet.getWindowToken(), 2);
    }

    private void clearone() {
        this.suslovol.setText(null);
        this.suslovol.requestFocus();
    }

    private void cleartree() {
        this.extract.setText(null);
        this.extract.requestFocus();
    }

    private void cleartwo() {
        this.nachplot.setText(null);
        this.nachplot.requestFocus();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_beer_suslo);
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.suslovol = this.findViewById(R.id.suslovol);
        this.nachplot = this.findViewById(R.id.nachplot);
        this.extract = this.findViewById(R.id.extract);
        this.clear1 = this.findViewById(R.id.clear1);
        this.clear2 = this.findViewById(R.id.clear2);
        this.clear3 = this.findViewById(R.id.clear3);
        this.raschet = this.findViewById(R.id.raschet);
        this.rezult = this.findViewById(R.id.rezult);
        this.clear1.setOnClickListener(view -> beer_suslo.this.clearone());
        this.clear2.setOnClickListener(view -> beer_suslo.this.cleartwo());
        this.clear3.setOnClickListener(view -> beer_suslo.this.cleartree());
        this.raschet.setOnClickListener(view -> beer_suslo.this.beerSuslo());
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
                beer_suslo.this.SaveData();
                Toast.makeText(this, R.string.toast_savedata, (int)0).show();
                return true;
            }
            beer_suslo.this.LoadData();
            beer_suslo.this.beerSuslo();
            Toast.makeText(this, R.string.toast_loaddata, (int)0).show();
            return true;
        }
        this.finish();
        return true;
    }

}


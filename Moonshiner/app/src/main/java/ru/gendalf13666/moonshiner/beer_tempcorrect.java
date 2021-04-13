package ru.gendalf13666.moonshiner;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class beer_tempcorrect extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    private EditText areom;
    private Button button;
    private EditText calibr;
    private CheckBox checkbox;
    SharedPreferences mSettings;
    private TextView rezultat;
    private EditText temp;

    private void clear_one() {
        this.areom.setText(null);
        this.areom.requestFocus();
    }

    private void clear_tree() {
        this.calibr.setText(null);
        this.calibr.requestFocus();
    }

    private void clear_two() {
        this.temp.setText(null);
        this.temp.requestFocus();
    }

    void LoadData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        this.areom.setText(sharedPreferences.getString("tempcorrect_1", ""));
        this.temp.setText(this.mSettings.getString("tempcorrect_2", ""));
        this.calibr.setText(this.mSettings.getString("tempcorrect_3", ""));
    }

    void SaveData() {
        SharedPreferences sharedPreferences;
        this.mSettings = sharedPreferences = this.getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("tempcorrect_1", this.areom.getText().toString());
        editor.putString("tempcorrect_2", this.temp.getText().toString());
        editor.putString("tempcorrect_3", this.calibr.getText().toString());
        editor.apply();
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        ImageButton imageButton;
        ImageButton imageButton2;
        ImageButton imageButton3;
        Button button;
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_beer_tempcorrect);
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.areom = this.findViewById(R.id.areom);
        this.temp = this.findViewById(R.id.temp);
        this.calibr = this.findViewById(R.id.calibr);
        this.rezultat = this.findViewById(R.id.rezultat);
        this.checkbox = this.findViewById(R.id.checkbox);
        ImageButton clear1 = imageButton3 = this.findViewById(R.id.clear1);
        imageButton3.setOnClickListener(view -> beer_tempcorrect.this.clear_one());
        ImageButton clear2 = imageButton = this.findViewById(R.id.clear2);
        imageButton.setOnClickListener(view -> beer_tempcorrect.this.clear_two());
        ImageButton clear3 = imageButton2 = this.findViewById(R.id.clear3);
        imageButton2.setOnClickListener(view -> beer_tempcorrect.this.clear_tree());
        this.button = button = this.findViewById(R.id.button);
        button.setOnClickListener(view -> beer_tempcorrect.this.raschettempcorrect());
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
            this.raschettempcorrect();
            Toast.makeText(this, R.string.toast_loaddata, (int)0).show();
            return true;
        }
        this.finish();
        return true;
    }

    @SuppressLint({"WrongConstant", "DefaultLocale"})
    public void raschettempcorrect() {
        String string2 = this.temp.getText().toString();
        String string3 = this.areom.getText().toString();
        String string4 = this.calibr.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u044b \u043f\u043e\u043a\u0430\u0437\u0430\u043d\u0438\u044f \u0430\u0440\u0435\u043e\u043c\u0435\u0442\u0440\u0430", (int)0).show();
            this.temp.requestFocus();
            return;
        }
        if (string3.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u0430 \u0442\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0430", (int)0).show();
            this.areom.requestFocus();
            return;
        }
        if (string4.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u0430 \u043a\u0430\u043b\u0438\u0431\u0440\u043e\u0432\u043e\u0447\u043d\u0430\u044f \u0442\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0430", (int)0).show();
            this.calibr.requestFocus();
            return;
        }
        double d = Double.parseDouble(string2);
        double d2 = Double.parseDouble(string3);
        double d3 = Double.parseDouble(string4);
        this.checkbox.setChecked(d2 >= 2.0);
        if (!(d < 0.0) && !(d > 70.0)) {
            if (!(d3 < 10.0) && !(d3 > 24.0)) {
                String string5;
                double[] arrd = new double[72];
                double[] arrd2 = new double[81];
                for (int i = 0; i <= 71; ++i) {
                    arrd[i] = i;
                }
                double d4 = 15L - Math.round(d3);
                arrd2[0] = -9.0E-4;
                arrd2[1] = -9.0E-4;
                arrd2[2] = -9.0E-4;
                arrd2[3] = -9.0E-4;
                arrd2[4] = -9.0E-4;
                arrd2[5] = -9.0E-4;
                arrd2[6] = -8.0E-4;
                arrd2[7] = -8.0E-4;
                arrd2[8] = -7.0E-4;
                arrd2[9] = -7.0E-4;
                arrd2[10] = -6.0E-4;
                arrd2[11] = -5.0E-4;
                arrd2[12] = -4.0E-4;
                arrd2[13] = -3.0E-4;
                arrd2[14] = -1.0E-4;
                arrd2[15] = 0.0;
                arrd2[16] = 2.0E-4;
                arrd2[17] = 3.0E-4;
                arrd2[18] = 5.0E-4;
                arrd2[19] = 7.0E-4;
                arrd2[20] = 9.0E-4;
                arrd2[21] = 0.0011;
                arrd2[22] = 0.0013;
                arrd2[23] = 0.0016;
                arrd2[24] = 0.0018;
                arrd2[25] = 0.0021;
                arrd2[26] = 0.0023;
                arrd2[27] = 0.0026;
                arrd2[28] = 0.0029;
                arrd2[29] = 0.0032;
                arrd2[30] = 0.0035;
                arrd2[31] = 0.0038;
                arrd2[32] = 0.0041;
                arrd2[33] = 0.0044;
                arrd2[34] = 0.0047;
                arrd2[35] = 0.0051;
                arrd2[36] = 0.0054;
                arrd2[37] = 0.0058;
                arrd2[38] = 0.0061;
                arrd2[39] = 0.0065;
                arrd2[40] = 0.0069;
                arrd2[41] = 0.0073;
                arrd2[42] = 0.0077;
                arrd2[43] = 0.0081;
                arrd2[44] = 0.0085;
                arrd2[45] = 0.0089;
                arrd2[46] = 0.0093;
                arrd2[47] = 0.0097;
                arrd2[48] = 0.0102;
                arrd2[49] = 0.0106;
                arrd2[50] = 0.011;
                arrd2[51] = 0.0114;
                arrd2[52] = 0.0118;
                arrd2[53] = 0.0122;
                arrd2[54] = 0.0126;
                arrd2[55] = 0.013;
                arrd2[56] = 0.0135;
                arrd2[57] = 0.014;
                arrd2[58] = 0.0145;
                arrd2[59] = 0.015;
                arrd2[60] = 0.0155;
                arrd2[61] = 0.016;
                arrd2[62] = 0.0165;
                arrd2[63] = 0.0171;
                arrd2[64] = 0.0177;
                arrd2[65] = 0.0183;
                arrd2[66] = 0.0189;
                arrd2[67] = 0.0195;
                arrd2[68] = 0.0201;
                arrd2[69] = 0.0207;
                arrd2[70] = 0.0213;
                arrd2[71] = 0.0219;
                arrd2[72] = 0.0225;
                arrd2[73] = 0.0231;
                arrd2[74] = 0.0237;
                arrd2[75] = 0.0243;
                arrd2[76] = 0.0249;
                arrd2[77] = 0.0255;
                arrd2[78] = 0.0261;
                arrd2[79] = 0.0267;
                arrd2[80] = 0.0273;
                double d5 = 0.0;
                for (int i = 0; i < 72; ++i) {
                    if (arrd[i] == d) {
                        int n = (int)d4;
                        if (i + n < 0) {
                            n = 0;
                        }
                        d5 = arrd2[n + i];
                    }
                    if (!(d >= arrd[i]) || !(d < arrd[i + 1])) continue;
                    Double.isNaN(i);
                    Double.isNaN(d4);
                    double d7 = (double) i + d4 < 0.0 ? 0.0 : d4;
                    int n = i + (int)d7;
                    d5 = (arrd2[n] + arrd2[n + 1]) / 2.0;
                }
                if (this.checkbox.isChecked()) {
                    double d8 = 1.0 + d2 / (258.6 - 227.1 * (d2 / 258.2));
                    Object[] arrobject = new Object[]{d8};
                    String.format("%.4f", arrobject);
                    double d9 = d8 + d5;
                    double d10 = d9 * (1262.7794 + d9 * (182.4601 * d9 - 775.6821)) - 669.5622;
                    Object[] arrobject2 = new Object[]{d10};
                    string5 = String.format("%.2f", arrobject2);
                } else {
                    Object[] arrobject = new Object[]{d2};
                    String.format("%.4f", arrobject);
                    double d11 = d2 + d5;
                    Object[] arrobject3 = new Object[]{d11};
                    string5 = String.format("%.4f", arrobject3);
                }
                this.rezultat.setText(string5);
                ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.button.getWindowToken(), 2);
                return;
            }
            Toast toast = Toast.makeText(this, "\u0422\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0430 \u043a\u0430\u043b\u0438\u0431\u0440\u043e\u0432\u043a\u0438 \u043d\u0435 \u0432 \u043f\u0440\u043e\u043c\u0435\u0436\u0443\u0442\u043a\u0435 10-24", (int)1);
            toast.setGravity(17, 0, 0);
            toast.show();
            return;
        }
        Toast toast = Toast.makeText(this, "\u0422\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0430 \u0441\u0443\u0441\u043b\u0430 \u043d\u0435 \u0432 \u043f\u0440\u043e\u043c\u0435\u0436\u0443\u0442\u043a\u0435 0-70", (int)1);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

}


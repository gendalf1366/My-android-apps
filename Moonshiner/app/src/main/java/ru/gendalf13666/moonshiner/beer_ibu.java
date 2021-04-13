package ru.gendalf13666.moonshiner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class beer_ibu extends AppCompatActivity {
    private EditText alpha1;
    private EditText alpha2;
    private EditText alpha3;
    private EditText alpha4;
    private EditText alpha5;
    private Button button;
    private EditText density;
    private TextView rezultat;
    private Spinner timer1;
    private Spinner timer2;
    private Spinner timer3;
    private Spinner timer4;
    private Spinner timer5;
    private EditText volume;
    private EditText weight1;
    private EditText weight2;
    private EditText weight3;
    private EditText weight4;
    private EditText weight5;

    private void clear_five() {
        this.weight3.setText(null);
        this.alpha3.setText(null);
        this.timer3.setSelection(0);
        this.weight3.requestFocus();
    }

    private void clear_four() {
        this.weight2.setText(null);
        this.alpha2.setText(null);
        this.timer2.setSelection(0);
        this.weight2.requestFocus();
    }

    private void clear_one() {
        this.density.setText(null);
        this.density.requestFocus();
    }

    private void clear_seven() {
        this.weight5.setText(null);
        this.alpha5.setText(null);
        this.timer5.setSelection(0);
        this.weight5.requestFocus();
    }

    private void clear_six() {
        this.weight4.setText(null);
        this.alpha4.setText(null);
        this.timer4.setSelection(0);
        this.weight4.requestFocus();
    }

    private void clear_tree() {
        this.weight1.setText(null);
        this.alpha1.setText(null);
        this.timer1.setSelection(0);
        this.weight1.requestFocus();
    }

    private void clear_two() {
        this.volume.setText(null);
        this.volume.requestFocus();
    }

    @SuppressLint({"WrongConstant", "DefaultLocale", "ShowToast"})
    private void raschet_ibu() {
        double d;
        Double d2 = 0.0;
        Double.valueOf(0.0);
        String string2 = this.density.getText().toString();
        String string3 = this.volume.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "D - null", 0).show();
            this.density.requestFocus();
            return;
        }
        if (string3.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "V - null", 0).show();
            this.volume.requestFocus();
            return;
        }
        double d3 = Double.parseDouble(string2);
        double d4 = Double.parseDouble(string3);
        if (d3 > 1.1) {
            d3 = 1.0 + d3 / (258.6 - 227.1 * (d3 / 258.2));
        }
        if (d3 < 1.03 || d3 > 1.07) {
            Toast.makeText(this.getApplicationContext(), R.string.beer_ibu_unreal, 0).show();
        }
        Double[][] arrdouble = (Double[][])Array.newInstance(Double.class, new int[]{10, 5});
        arrdouble[0][0] = 0.055;
        arrdouble[0][1] = 0.05;
        arrdouble[0][2] = 0.046;
        arrdouble[0][3] = 0.042;
        arrdouble[0][4] = 0.038;
        arrdouble[1][0] = 0.1;
        arrdouble[1][1] = 0.091;
        arrdouble[1][2] = 0.084;
        arrdouble[1][3] = 0.076;
        arrdouble[1][4] = 0.07;
        arrdouble[2][0] = 0.137;
        arrdouble[2][1] = 0.125;
        arrdouble[2][2] = 0.114;
        arrdouble[2][3] = 0.105;
        arrdouble[2][4] = 0.096;
        arrdouble[3][0] = 0.167;
        arrdouble[3][1] = 0.153;
        arrdouble[3][2] = 0.14;
        arrdouble[3][3] = 0.128;
        arrdouble[3][4] = 0.117;
        arrdouble[4][0] = 0.212;
        arrdouble[4][1] = 0.194;
        arrdouble[4][2] = 0.177;
        arrdouble[4][3] = 0.162;
        arrdouble[4][4] = 0.148;
        arrdouble[5][0] = 0.242;
        arrdouble[5][1] = 0.221;
        arrdouble[5][2] = 0.202;
        arrdouble[5][3] = 0.185;
        arrdouble[5][4] = 0.169;
        arrdouble[6][0] = 0.276;
        arrdouble[6][1] = 0.252;
        arrdouble[6][2] = 0.231;
        arrdouble[6][3] = 0.211;
        arrdouble[6][4] = 0.193;
        arrdouble[7][0] = 0.291;
        arrdouble[7][1] = 0.266;
        arrdouble[7][2] = 0.243;
        arrdouble[7][3] = 0.222;
        arrdouble[7][4] = 0.203;
        arrdouble[8][0] = 0.295;
        arrdouble[8][1] = 0.27;
        arrdouble[8][2] = 0.247;
        arrdouble[8][3] = 0.226;
        arrdouble[8][4] = 0.206;
        arrdouble[9][0] = 0.301;
        arrdouble[9][1] = 0.275;
        arrdouble[9][2] = 0.252;
        arrdouble[9][3] = 0.23;
        arrdouble[9][4] = 0.21;
        if (this.weight1.length() != 0) {
            Double d5 = Double.parseDouble(this.weight1.getText().toString());
            Double d6 = Double.parseDouble(this.alpha1.getText().toString());
            Double.valueOf(Double.parseDouble(this.timer1.getSelectedItem().toString()));
            int n = this.timer1.getSelectedItemPosition();
            Double d7 = d3 == 1.03 ? arrdouble[n][0] : d2;
            if (d3 > 1.03 && d3 < 1.04) {
                d7 = arrdouble[n][0] + (d3 - 1.03) / 0.01 * ((arrdouble[n][1] - arrdouble[n][0]) / 1.0);
            }
            if (d3 == 1.04) {
                d7 = arrdouble[n][1];
            }
            if (d3 > 1.04 && d3 < 1.05) {
                d7 = arrdouble[n][1] + (d3 - 1.04) / 0.01 * ((arrdouble[n][1] - arrdouble[n][1]) / 1.0);
            }
            if (d3 == 1.05) {
                d7 = arrdouble[n][2];
            }
            if (d3 > 1.05 && d3 < 1.06) {
                d7 = arrdouble[n][2] + (d3 - 1.04) / 0.01 * ((arrdouble[n][2] - arrdouble[n][2]) / 1.0);
            }
            if (d3 == 1.06) {
                d7 = arrdouble[n][3];
            }
            if (d3 > 1.06 && d3 < 1.07) {
                d7 = arrdouble[n][3] + (d3 - 1.04) / 0.01 * ((arrdouble[n][3] - arrdouble[n][3]) / 1.0);
            }
            if (d3 == 1.07) {
                d7 = arrdouble[n][4];
            }
            if (d3 > 1.07) {
                d7 = 999.0;
            }
            Double d8 = d7 * (d5 * d6 / (0.1 * d4));
            d = d2 + d8;
            d2 = d7;
        } else {
            d = d2;
        }
        if (this.weight2.length() != 0) {
            Double d9 = Double.parseDouble(this.weight2.getText().toString());
            Double d10 = Double.parseDouble(this.alpha2.getText().toString());
            Double.valueOf(Double.parseDouble(this.timer2.getSelectedItem().toString()));
            int n = this.timer2.getSelectedItemPosition();
            if (d3 == 1.03) {
                d2 = arrdouble[n][0];
            }
            if (d3 > 1.03 && d3 < 1.04) {
                d2 = arrdouble[n][0] + (d3 - 1.03) / 0.01 * ((arrdouble[n][1] - arrdouble[n][0]) / 1.0);
            }
            if (d3 == 1.04) {
                d2 = arrdouble[n][1];
            }
            if (d3 > 1.04 && d3 < 1.05) {
                d2 = arrdouble[n][1] + (d3 - 1.04) / 0.01 * ((arrdouble[n][1] - arrdouble[n][1]) / 1.0);
            }
            if (d3 == 1.05) {
                d2 = arrdouble[n][2];
            }
            if (d3 > 1.05 && d3 < 1.06) {
                d2 = arrdouble[n][2] + (d3 - 1.04) / 0.01 * ((arrdouble[n][2] - arrdouble[n][2]) / 1.0);
            }
            if (d3 == 1.06) {
                d2 = arrdouble[n][3];
            }
            if (d3 > 1.06 && d3 < 1.07) {
                d2 = arrdouble[n][3] + (d3 - 1.04) / 0.01 * ((arrdouble[n][3] - arrdouble[n][3]) / 1.0);
            }
            if (d3 == 1.07) {
                d2 = arrdouble[n][4];
            }
            if (d3 > 1.07) {
                d2 = 999.0;
            }
            double d11 = d2 * (d9 * d10 / (0.1 * d4));
            d = d + d11;
        }
        if (this.weight3.length() != 0) {
            Double d12 = Double.parseDouble(this.weight3.getText().toString());
            Double d13 = Double.parseDouble(this.alpha3.getText().toString());
            Double.valueOf(Double.parseDouble(this.timer3.getSelectedItem().toString()));
            int n = this.timer3.getSelectedItemPosition();
            if (d3 == 1.03) {
                d2 = arrdouble[n][0];
            }
            if (d3 > 1.03 && d3 < 1.04) {
                d2 = arrdouble[n][0] + (d3 - 1.03) / 0.01 * ((arrdouble[n][1] - arrdouble[n][0]) / 1.0);
            }
            if (d3 == 1.04) {
                d2 = arrdouble[n][1];
            }
            if (d3 > 1.04 && d3 < 1.05) {
                d2 = arrdouble[n][1] + (d3 - 1.04) / 0.01 * ((arrdouble[n][1] - arrdouble[n][1]) / 1.0);
            }
            if (d3 == 1.05) {
                d2 = arrdouble[n][2];
            }
            if (d3 > 1.05 && d3 < 1.06) {
                d2 = arrdouble[n][2] + (d3 - 1.04) / 0.01 * ((arrdouble[n][2] - arrdouble[n][2]) / 1.0);
            }
            if (d3 == 1.06) {
                d2 = arrdouble[n][3];
            }
            if (d3 > 1.06 && d3 < 1.07) {
                d2 = arrdouble[n][3] + (d3 - 1.04) / 0.01 * ((arrdouble[n][3] - arrdouble[n][3]) / 1.0);
            }
            if (d3 == 1.07) {
                d2 = arrdouble[n][4];
            }
            if (d3 > 1.07) {
                d2 = 999.0;
            }
            double d14 = d2 * (d12 * d13 / (0.1 * d4));
            d = d + d14;
        }
        if (this.weight4.length() != 0) {
            Double d15 = Double.parseDouble(this.weight4.getText().toString());
            Double d16 = Double.parseDouble(this.alpha4.getText().toString());
            Double.valueOf(Double.parseDouble(this.timer4.getSelectedItem().toString()));
            int n = this.timer4.getSelectedItemPosition();
            if (d3 == 1.03) {
                d2 = arrdouble[n][0];
            }
            if (d3 > 1.03 && d3 < 1.04) {
                d2 = arrdouble[n][0] + (d3 - 1.03) / 0.01 * ((arrdouble[n][1] - arrdouble[n][0]) / 1.0);
            }
            if (d3 == 1.04) {
                d2 = arrdouble[n][1];
            }
            if (d3 > 1.04 && d3 < 1.05) {
                d2 = arrdouble[n][1] + (d3 - 1.04) / 0.01 * ((arrdouble[n][1] - arrdouble[n][1]) / 1.0);
            }
            if (d3 == 1.05) {
                d2 = arrdouble[n][2];
            }
            if (d3 > 1.05 && d3 < 1.06) {
                d2 = arrdouble[n][2] + (d3 - 1.04) / 0.01 * ((arrdouble[n][2] - arrdouble[n][2]) / 1.0);
            }
            if (d3 == 1.06) {
                d2 = arrdouble[n][3];
            }
            if (d3 > 1.06 && d3 < 1.07) {
                d2 = arrdouble[n][3] + (d3 - 1.04) / 0.01 * ((arrdouble[n][3] - arrdouble[n][3]) / 1.0);
            }
            if (d3 == 1.07) {
                d2 = arrdouble[n][4];
            }
            if (d3 > 1.07) {
                d2 = 999.0;
            }
            double d17 = d2 * (d15 * d16 / (0.1 * d4));
            d = d + d17;
        }
        if (this.weight5.length() != 0) {
            Double d18 = Double.parseDouble(this.weight5.getText().toString());
            Double d19 = Double.parseDouble(this.alpha5.getText().toString());
            Double.valueOf(Double.parseDouble(this.timer5.getSelectedItem().toString()));
            int n = this.timer5.getSelectedItemPosition();
            if (d3 == 1.03) {
                d2 = arrdouble[n][0];
            }
            if (d3 > 1.03 && d3 < 1.04) {
                d2 = arrdouble[n][0] + (d3 - 1.03) / 0.01 * ((arrdouble[n][1] - arrdouble[n][0]) / 1.0);
            }
            if (d3 == 1.04) {
                d2 = arrdouble[n][1];
            }
            if (d3 > 1.04 && d3 < 1.05) {
                d2 = arrdouble[n][1] + (d3 - 1.04) / 0.01 * ((arrdouble[n][1] - arrdouble[n][1]) / 1.0);
            }
            if (d3 == 1.05) {
                d2 = arrdouble[n][2];
            }
            if (d3 > 1.05 && d3 < 1.06) {
                d2 = arrdouble[n][2] + (d3 - 1.04) / 0.01 * ((arrdouble[n][2] - arrdouble[n][2]) / 1.0);
            }
            if (d3 == 1.06) {
                d2 = arrdouble[n][3];
            }
            if (d3 > 1.06 && d3 < 1.07) {
                d2 = arrdouble[n][3] + (d3 - 1.04) / 0.01 * ((arrdouble[n][3] - arrdouble[n][3]) / 1.0);
            }
            if (d3 == 1.07) {
                d2 = arrdouble[n][4];
            }
            if (d3 > 1.07) {
                d2 = 999.0;
            }
            double d20 = d2 * (d18 * d19 / (0.1 * d4));
            d = d + d20;
        }
        this.rezultat.setText(String.format("%.1f", d));
        ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.button.getWindowToken(), 2);
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        ImageButton imageButton;
        ImageButton imageButton2;
        Button button;
        ImageButton imageButton3;
        ImageButton imageButton4;
        ImageButton imageButton5;
        ImageButton imageButton6;
        ImageButton imageButton7;
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_beer_ibu );
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.density = this.findViewById(R.id.density);
        this.volume = this.findViewById(R.id.volume);
        this.weight1 = this.findViewById(R.id.weight1);
        this.weight2 = this.findViewById(R.id.weight2);
        this.weight3 = this.findViewById(R.id.weight3);
        this.weight4 = this.findViewById(R.id.weight4);
        this.weight5 = this.findViewById(R.id.weight5);
        this.alpha1 = this.findViewById(R.id.alpha1);
        this.alpha2 = this.findViewById(R.id.alpha2);
        this.alpha3 = this.findViewById(R.id.alpha3);
        this.alpha4 = this.findViewById(R.id.alpha4);
        this.alpha5 = this.findViewById(R.id.alpha5);
        this.timer1 = this.findViewById(R.id.timer1);
        this.timer2 = this.findViewById(R.id.timer2);
        this.timer3 = this.findViewById(R.id.timer3);
        this.timer4 = this.findViewById(R.id.timer4);
        this.timer5 = this.findViewById(R.id.timer5);
        this.rezultat = this.findViewById(R.id.rezultat);
        this.button = button = this.findViewById(R.id.button);
        button.setOnClickListener(view -> beer_ibu.this.raschet_ibu());
        ImageButton clear1 = imageButton = this.findViewById(R.id.clear1);
        imageButton.setOnClickListener(view -> beer_ibu.this.clear_one());
        ImageButton clear2 = imageButton3 = this.findViewById(R.id.clear2);
        imageButton3.setOnClickListener(view -> beer_ibu.this.clear_two());
        ImageButton clear3 = imageButton4 = this.findViewById(R.id.clear3);
        imageButton4.setOnClickListener(view -> beer_ibu.this.clear_tree());
        ImageButton clear4 = imageButton5 = this.findViewById(R.id.clear4);
        imageButton5.setOnClickListener(view -> beer_ibu.this.clear_four());
        ImageButton clear5 = imageButton7 = this.findViewById(R.id.clear5);
        imageButton7.setOnClickListener(view -> beer_ibu.this.clear_five());
        ImageButton clear6 = imageButton2 = this.findViewById(R.id.clear6);
        imageButton2.setOnClickListener(view -> beer_ibu.this.clear_six());
        ImageButton clear7 = imageButton6 = this.findViewById(R.id.clear7);
        imageButton6.setOnClickListener(view -> beer_ibu.this.clear_seven());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.home) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.finish();
        return true;
    }

}


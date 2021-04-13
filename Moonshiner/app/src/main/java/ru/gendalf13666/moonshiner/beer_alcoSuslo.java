package ru.gendalf13666.moonshiner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class beer_alcoSuslo extends AppCompatActivity {
    private CheckBox convert;
    private EditText koefsuslo;
    private EditText plotnost1;
    private EditText plotnost2;
    private Button raschet;
    private CheckBox refract;
    private TextView spirtItog;

    @SuppressLint("WrongConstant")
    private void raschet() {
        double d;
        double d2 = Double.parseDouble(this.plotnost1.getText().toString());
        double d3 = Double.parseDouble(this.plotnost2.getText().toString());
        double d4 = Double.parseDouble(this.koefsuslo.getText().toString());
        this.convert.setChecked(d2 >= 2.0);
        if (this.convert.isChecked()) {
            d2 = 1.0 + d2 / (258.6 - 227.1 * (d2 / 258.2));
            d3 = 1.0 + d3 / (258.6 - 227.1 * (d3 / 258.2));
        }
        if (this.refract.isChecked()) {
            double d5 = d2 / d4;
            double d6 = 1.0 - 0.0044993 * d5;
            double d7 = d3 / d4;
            d = d6 + 0.0117741 * d7 + 2.75806E-4 * Math.pow(d5, 3.0) - 0.00127169 * Math.pow(d7, 2.0) - 7.27999E-6 * Math.pow(d5, 3.0) + 6.32929E-5 * Math.pow(d7, 3.0);
        } else {
            d = 76.8 * (d2 - d3) / (1.775 - d2) * (d3 / 0.794);
        }
        Object[] arrobject = new Object[]{d};
        @SuppressLint("DefaultLocale") String string2 = String.format("%.4f", arrobject);
        TextView textView = this.spirtItog;
        String stringBuilder = "\u0420\u0435\u0437\u0443\u043b\u044c\u0442\u0430\u0442\u044b:\n\u0420\u0430\u0441\u0447\u0435\u0442\u043d\u043e\u0435 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u043e\u0431\u044a\u0435\u043c\u043d\u043e\u0433\u043e \u0441\u043f\u0438\u0440\u0442\u0430 \u0432 \u0441\u0443\u0441\u043b\u0435 \u0441\u043e\u0441\u0442\u0430\u0432\u0438\u0442: " +
                string2 +
                "%";
        textView.setText(stringBuilder);
        ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.raschet.getWindowToken(), 2);
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        Button button;
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_beer_alco_suslo);
        ActionBar actionBar = this.getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.convert = this.findViewById(R.id.convert);
        this.refract = this.findViewById(R.id.refract);
        this.plotnost1 = this.findViewById(R.id.plotnost1);
        this.plotnost2 = this.findViewById(R.id.plotnost2);
        this.koefsuslo = this.findViewById(R.id.koefsuslo);
        this.spirtItog = this.findViewById(R.id.spirt_itog);
        this.raschet = button = this.findViewById(R.id.raschet);
        button.setOnClickListener(view -> beer_alcoSuslo.this.raschet());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.home) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.finish();
        return true;
    }

}


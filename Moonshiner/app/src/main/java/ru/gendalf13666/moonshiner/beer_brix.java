package ru.gendalf13666.moonshiner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class beer_brix extends AppCompatActivity {
    private EditText brix;
    private TextView brix_rez1;
    private TextView brix_rez2;
    private ImageButton rash_brix;
    private ImageButton rash_udves;
    private EditText udves;

    @SuppressLint({"WrongConstant", "ShowToast"})
    private void raschet_brix() {
        String string2 = this.brix.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0411\u0420\u0418\u041a\u0421", 0).show();
            this.brix.requestFocus();
            return;
        }
        double d = Double.parseDouble(string2);
        double d2 = 1.0 + d / (258.6 - 227.1 * (d / 258.2));
        Object[] arrobject = new Object[]{d2};
        @SuppressLint("DefaultLocale") String string3 = String.format("%.4f", arrobject);
        TextView textView = this.brix_rez1;
        String stringBuilder = d +
                "";
        textView.setText(stringBuilder);
        this.brix_rez2.setText(string3);
        ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.rash_brix.getWindowToken(), 2);
    }

    @SuppressLint({"WrongConstant", "ShowToast"})
    private void raschet_udves() {
        String string2 = this.udves.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0443\u0434\u0435\u043b\u044c\u043d\u043e\u0433\u043e \u0432\u0435\u0441\u0430", 0).show();
            this.udves.requestFocus();
            return;
        }
        double d = Double.parseDouble(string2);
        double d2 = d * (1262.7794 + d * (182.4601 * d - 775.6821)) - 669.5622;
        Object[] arrobject = new Object[]{d2};
        @SuppressLint("DefaultLocale") String string3 = String.format("%.1f", arrobject);
        TextView textView = this.brix_rez1;
        String stringBuilder = d +
                "";
        textView.setText(stringBuilder);
        this.brix_rez2.setText(string3);
        ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.rash_udves.getWindowToken(), 2);
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        ImageButton imageButton;
        ImageButton imageButton4;
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_beer_brix);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
        }
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        this.brix = this.findViewById(R.id.brix);
        this.udves = this.findViewById(R.id.udves);
        this.brix_rez1 = this.findViewById(R.id.brix_rez1);
        this.brix_rez2 = this.findViewById(R.id.brix_rez2);
        this.rash_brix = imageButton4 = this.findViewById(R.id.rash_brix);
        imageButton4.setOnClickListener(view -> beer_brix.this.raschet_brix());
        this.rash_udves = imageButton = this.findViewById(R.id.rash_udves);
        imageButton.setOnClickListener(view -> beer_brix.this.raschet_udves());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.home) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.finish();
        return true;
    }

}


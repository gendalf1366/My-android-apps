package ru.gendalf13666.moonshiner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class sem_Tempcorrect extends AppCompatActivity {
    private Button raschet;
    private EditText sem_areom;
    private TextView sem_result;
    private EditText sem_temp;

    private void clear_one() {
        this.sem_temp.setText(null);
        this.sem_temp.requestFocus();
    }

    private void clear_two() {
        this.sem_areom.setText(null);
        this.sem_areom.requestFocus();
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_sem__tempcorrect);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
        }
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        this.raschet = this.findViewById(R.id.raschet);
        ImageButton clear1 = this.findViewById(R.id.clear1);
        ImageButton clear2 = this.findViewById(R.id.clear2);
        this.sem_temp = this.findViewById(R.id.sem_temp);
        this.sem_areom = this.findViewById(R.id.sem_areom);
        this.sem_result = this.findViewById(R.id.sem_result);
        this.raschet.setOnClickListener(view -> sem_Tempcorrect.this.raschet_correct());
        clear1.setOnClickListener(view -> sem_Tempcorrect.this.clear_one());
        clear2.setOnClickListener(view -> sem_Tempcorrect.this.clear_two());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() !=  R.id.home) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.finish();
        return true;
    }

    @SuppressLint("WrongConstant")
    public void raschet_correct() {
        String string2 = this.sem_temp.getText().toString();
        String string3 = this.sem_areom.getText().toString();
        if (string2.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0442\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u044b \u043f\u0440\u043e\u0434\u0443\u043a\u0442\u0430", (int)0).show();
            this.sem_temp.requestFocus();
            return;
        }
        if (string3.length() == 0) {
            Toast.makeText(this.getApplicationContext(), "\u041d\u0435 \u0432\u0432\u0435\u0434\u0435\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0430\u0440\u0435\u043e\u043c\u0435\u0442\u0440\u0430", (int)0).show();
            this.sem_areom.requestFocus();
            return;
        }
        double d = Double.parseDouble(string2);
        double d2 = Double.parseDouble(string3) + 0.3 * (20.0 - d);
        TextView textView = this.sem_result;
        Object[] arrobject = new Object[]{d2};
        @SuppressLint("DefaultLocale") String stringBuilder = String.format("%.2f", arrobject) +
                "%";
        textView.setText(stringBuilder);
        ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.raschet.getWindowToken(), 2);
    }

}


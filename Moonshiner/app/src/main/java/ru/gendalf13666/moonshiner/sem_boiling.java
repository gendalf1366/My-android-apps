package ru.gendalf13666.moonshiner;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class sem_boiling extends AppCompatActivity {
    private TextView cubespirtview;
    private TextView cubetempview;
    private TextView jetspirtview;

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_sem_boiling);
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        SeekBar cubetemp = this.findViewById(R.id.cubetemp);
        this.cubetempview = this.findViewById(R.id.cubetempview);
        this.cubespirtview = this.findViewById(R.id.cubespirtview);
        this.jetspirtview = this.findViewById(R.id.jetspirtview);
        cubetemp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            public void onProgressChanged(SeekBar seekBar, int n, boolean bl) {
                int n2 = n + 88;
                sem_boiling.this.cubetempview.setText(String.valueOf(n2));
                int n3 = n * 21;
                int n4 = 255 - n3;
                sem_boiling.this.cubetempview.setTextColor(Color.rgb(n3, n4, 0));
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @SuppressLint("SetTextI18n")
            public void onStopTrackingTouch(SeekBar seekBar) {
                switch (Integer.parseInt(sem_boiling.this.cubetempview.getText().toString())) {
                    default: {
                        return;
                    }
                    case 100: {
                        sem_boiling.this.cubespirtview.setText("0.0");
                        sem_boiling.this.jetspirtview.setText("0.0");
                        return;
                    }
                    case 99: {
                        sem_boiling.this.cubespirtview.setText("1.2");
                        sem_boiling.this.jetspirtview.setText("10.8");
                        return;
                    }
                    case 98: {
                        sem_boiling.this.cubespirtview.setText("2.5");
                        sem_boiling.this.jetspirtview.setText("20.7");
                        return;
                    }
                    case 97: {
                        sem_boiling.this.cubespirtview.setText("3.9");
                        sem_boiling.this.jetspirtview.setText("29.5");
                        return;
                    }
                    case 96: {
                        sem_boiling.this.cubespirtview.setText("5.3");
                        sem_boiling.this.jetspirtview.setText("36.8");
                        return;
                    }
                    case 95: {
                        sem_boiling.this.cubespirtview.setText("6.9");
                        sem_boiling.this.jetspirtview.setText("43.6");
                        return;
                    }
                    case 94: {
                        sem_boiling.this.cubespirtview.setText("8.5");
                        sem_boiling.this.jetspirtview.setText("49.0");
                        return;
                    }
                    case 93: {
                        sem_boiling.this.cubespirtview.setText("10.2");
                        sem_boiling.this.jetspirtview.setText("53.6");
                        return;
                    }
                    case 92: {
                        sem_boiling.this.cubespirtview.setText("12.2");
                        sem_boiling.this.jetspirtview.setText("57.9");
                        return;
                    }
                    case 91: {
                        sem_boiling.this.cubespirtview.setText("14.3");
                        sem_boiling.this.jetspirtview.setText("61.3");
                        return;
                    }
                    case 90: {
                        sem_boiling.this.cubespirtview.setText("16.5");
                        sem_boiling.this.jetspirtview.setText("64.1");
                        return;
                    }
                    case 89: {
                        sem_boiling.this.cubespirtview.setText("19.1");
                        sem_boiling.this.jetspirtview.setText("66.7");
                        return;
                    }
                    case 88: 
                }
                sem_boiling.this.cubespirtview.setText("21.9");
                sem_boiling.this.jetspirtview.setText("68.9");
            }
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


package ru.geekbrains.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.setting);
        button.setOnClickListener(view -> openTwoActivity());

        int[] numberId = new int[]{
                R.id.zero,
                R.id.one,
                R.id.two,
                R.id.three,
                R.id.four,
                R.id.five,
                R.id.six,
                R.id.seven,
                R.id.eight,
                R.id.nine
        };

        int[] actionId = new int[]{
                R.id.split,
                R.id.multiply,
                R.id.plus,
                R.id.min,
                R.id.rav
        };

        textView = findViewById(R.id.textView);

        calculator = new Calculator();

        View.OnClickListener numberButtonClickListener = view -> {
            calculator.onNumPressed(view.getId());
            textView.setText(calculator.getText());
        };

        View.OnClickListener actionButtonOnclickListener = view -> {
            calculator.onActionPressed(view.getId());
            textView.setText(calculator.getText());
        };

        for (int value : numberId) {
            findViewById(value).setOnClickListener(numberButtonClickListener);
        }

        for (int value : actionId) {
            findViewById(value).setOnClickListener(actionButtonOnclickListener);
        }

        findViewById(R.id.c).setOnClickListener(view -> {
            calculator.reset();
            textView.setText(calculator.getText());
        });
    }

    public void openTwoActivity(){
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }

}
package com.example.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    TextView numberWarning, fromBaseWarning, toBaseWarning, result;
    Button calculate;
    EditText number, fromBase, toBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        allFilled();

        calculate.setOnClickListener(view -> {
            if (allFilled()) {
                String num = number.getText().toString();
                int fBase = Integer.parseInt(fromBase.getText().toString());
                int tBase = Integer.parseInt(toBase.getText().toString());
                numberWarning.setText("");
                fromBaseWarning.setText("");
                toBaseWarning.setText("");
                number.setText("");
                fromBase.setText("");
                toBase.setText("");
                result.setText(convertFromBaseToBase(num, fBase, tBase));
            }
        });
    }

    private void initialize() {
        numberWarning = findViewById(R.id.numberWarning);
        fromBaseWarning = findViewById(R.id.fromBaseWarning);
        toBaseWarning = findViewById(R.id.toBaseWarning);
        result = findViewById(R.id.numResult);
        calculate = findViewById(R.id.calculateButton);
        number = findViewById(R.id.number);
        fromBase = findViewById(R.id.fromBase);
        toBase = findViewById(R.id.toBase);
    }

    @SuppressLint("SetTextI18n")
    protected boolean allFilled() {
        boolean result = true;

        numberWarning.setText("");
        fromBaseWarning.setText("");
        toBaseWarning.setText("");

        if (number.getText().toString().equals("")) {
            result = false;
            numberWarning.setText("Enter The Number To Convert.");
        }
        if (fromBase.getText().toString().equals("")) {
            result = false;
            fromBaseWarning.setText("Enter The Base Of The Number Above.");
        }
        if (toBase.getText().toString().equals("")) {
            result = false;
            toBaseWarning.setText("Enter The Base To Be Converted To.");
        }

        return result;
    }

    public String convertFromBaseToBase(String str, int fromBase, int toBase) {

        String result;

        try {
            result = Integer.toString(Integer.parseInt(str, fromBase), toBase);
        } catch (NumberFormatException nFE) {
            result = str + " Cannot Be In The Base " + fromBase + ".";
        }

        return result;


    }
}
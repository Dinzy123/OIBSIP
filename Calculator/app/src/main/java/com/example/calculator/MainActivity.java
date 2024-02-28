package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String op = "+";
    boolean isNewOp = true;
    private EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editText);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            ed1.setText("");
        isNewOp = false;
        String number = ed1.getText().toString();
        int viewId = view.getId();

        if (viewId == R.id.bu7) {
            number += "7";
        }
        else if (viewId == R.id.bu8) {
            number += "8";
        }
        else if (viewId == R.id.bu9) {
            number += "9";
        } else if (viewId == R.id.bu6) {
            number += "6";
        } else if (viewId == R.id.bu5) {
            number += "5";
        }
        else if (viewId == R.id.bu4) {
            number += "4";
        }
        else if (viewId == R.id.bu3) {
            number += "3";
        }
        else if (viewId == R.id.bu2) {
            number += "2";
        }
        else if (viewId == R.id.bu1) {
            number += "1";
        }
        else if (viewId == R.id.bu0) {
            number += "0";
        }
        else if (viewId == R.id.buDot) {
            number += ".";
        }
        else if (viewId == R.id.buPlusMinus) {
            number = "-" + number;
        }


        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        String number = ed1.getText().toString();
        int viewId = view.getId();
        oldNumber = ed1.getText().toString();

        if(viewId == R.id.buDivide) {
            op = "/";
        }
        if(viewId == R.id.buMultiply) {
            op = "*";
        }
        if(viewId == R.id.buPlus) {
            op = "+";
        }
        if(viewId == R.id.buMinus) {
            op = "-";
        }

    }

    public void equalEvent(View view) {
        String newNumber = ed1.getText().toString();
        double result = 0.0;
        switch (op) {
            case "+" :
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-" :
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*" :
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/" :
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        ed1.setText(result + "");
    }

    public void cancelEvent(View view) {
        ed1.setText("0");
        isNewOp = true;
    }
    public void percentEvent(View view) {
        double no = Double.parseDouble(ed1.getText().toString()) / 100;
        ed1.setText(no + "");
        isNewOp = true;
    }
}

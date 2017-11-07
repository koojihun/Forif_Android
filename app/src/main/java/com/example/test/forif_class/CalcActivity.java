package com.example.test.forif_class;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    String op1;
    boolean is_op1_finished;
    String operator;
    String op2;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        /* 변수 초기화 */
        op1 = op2 = null;
        is_op1_finished = false;

        tv = (TextView) findViewById(R.id.text_view);
    }

    public void onClick(View v) {

        Button pressed = (Button) v;

        switch (v.getId()) {
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
            case R.id.zero:
            case R.id.point:
                if (op1 == null && !is_op1_finished) {
                    tv.setText(pressed.getText().toString());
                    op1 = pressed.getText().toString();
                } else if (op1 != null && !is_op1_finished) {
                    tv.setText(tv.getText().toString() + pressed.getText().toString());
                    op1 = tv.getText().toString() + pressed.getText().toString();
                } else if (is_op1_finished && op2 == null) {
                    tv.setText(pressed.getText().toString());
                    op2 = pressed.getText().toString();
                } else if (is_op1_finished && op2 != null){
                    tv.setText(tv.getText().toString() + pressed.getText().toString());
                    op2 = tv.getText().toString() + pressed.getText().toString();
                }
                break;
            case R.id.AC:
                op1 = op2 = null;
                is_op1_finished = false;
                tv.setText("0");
                break;
            case R.id.plus:
                is_op1_finished = true;
                operator = pressed.getText().toString();
                break;
            case R.id.minus:
                is_op1_finished = true;
                operator = pressed.getText().toString();
                break;
            case R.id.percent:
                is_op1_finished = true;
                operator = pressed.getText().toString();
                break;
            case R.id.divide:
                is_op1_finished = true;
                operator = pressed.getText().toString();
                break;
            case R.id.multiply:
                is_op1_finished = true;
                operator = pressed.getText().toString();
                break;
            case R.id.equal:
                String re = equalize(op1, op2, operator);
                tv.setText(re);
                op1 = re;
                op2 = null;
                break;
            case R.id.plus_minus:
                break;
        }
    }
    String equalize(String op1, String op2, String operator) {
        float a = Float.parseFloat(op1);
        float b = Float.parseFloat(op2);
        double result = 0;
        if (operator.equals("+")) {
            result = a + b;
        } else if (operator.equals("ㅡ")) {
            result = a - b;
        } else if (operator.equals("X")) {
            result = a * b;
        } else if (operator.equals("/")) {
            result = a / b;
        }
        if (result - (int) result == 0) {
            return String.valueOf((int)result);
        } else {
            return String.valueOf(result);
        }

    }
}

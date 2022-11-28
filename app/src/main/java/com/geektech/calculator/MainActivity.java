package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Double first, second;
    private Boolean isOperationClick;
    private String operation;
    private  Double result;
    private Double doubleNum;
    private Integer resultInt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }


    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.btn_one:
                examination("1");
                break;
            case R.id.btn_two:
                examination("2");
                break;
            case R.id.btn_three:
                examination("3");
                break;
            case R.id.btn_four:
                examination("4");
                break;
            case R.id.btn_five:
                examination("5");
                break;
            case R.id.btn_six:
                examination("6");
                break;
            case R.id.btn_seven:
                examination("7");
                break;
            case R.id.btn_eight:
                examination("8");
                break;
            case R.id.btn_nine:
                examination("9");
                break;
            case R.id.btn_zero:
                examination("0");
                break;

            case R.id.btn_point:
                doubleNum = Double.valueOf(textView.getText().toString());
                if (textView.getText().toString().equals("0") || isOperationClick){
                    textView.setText(".");
                }
                else{
                    textView.setText(textView.getText().toString()+".");
                }

            case R.id.btn_clear:
                textView.setText("0");
                first = (double) 0;
                second = (double) 0;
                break;

        }
        isOperationClick  =false;

    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onOperationClick(View view) {
        switch (view.getId()){
            case R.id.btn_plus:
                operation = "+";
                first = Double.valueOf(textView.getText().toString());
                break;

            case R.id.btn_minus:
            operation = "-";
            first = Double.valueOf(textView.getText().toString());
            break;

            case R.id.btn_multiplication:
            operation = "×";
            first = Double.valueOf(textView.getText().toString());
            break;

            case R.id.btn_division:
                operation = "÷";
                first = Double.valueOf(textView.getText().toString());
                break;

            case R.id.btn_equal:
                second = Double.valueOf(textView.getText().toString());
                switch (operation){
                    case "+":
                        result= first+second;

                        if(result==(result.intValue())){
                            resultInt = result.intValue();
                            textView.setText(resultInt.toString());
                        }
                        else textView.setText(result.toString());
                        break;

                    case "-":
                        result = first-second;
                        if(result==(result.intValue())){
                            resultInt = result.intValue();
                            textView.setText(resultInt.toString());
                        }
                        else textView.setText(result.toString());
                        break;

                    case "×":
                        result = first*second;
                        if(result==(result.intValue())){
                            resultInt = result.intValue();
                            textView.setText(resultInt.toString());
                        }
                        else textView.setText(result.toString());
                        break;

                    case "÷":
                        result = first/second;
                        if(result==(result.intValue())){
                            resultInt = result.intValue();
                            textView.setText(resultInt.toString());
                        }
                        else textView.setText(result.toString());
                        break;
                    }
                break;
        }
        isOperationClick = true;
    }

    public void examination(String num){
        if (textView.getText().toString().equals("0") || isOperationClick){
            textView.setText(num);
        }
        else{
            textView.append(num);
        }
    }
}
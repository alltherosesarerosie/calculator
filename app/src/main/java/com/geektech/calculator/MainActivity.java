package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Double first, second;
    private Boolean isOperationClick;
    private String operation;
    private  Double result;
    private Integer resultInt;
    private AppCompatButton top_btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        top_btn = findViewById(R.id.top_btn);
        top_btn.animate().alpha(0);
        Log.d("shamal","onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("shamal","onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("shamal","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("shamal","onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("shamal","onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("shamal","onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("shamal","onDestroy");
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onNumberClick(View view) {
        top_btn.animate().alpha(0);
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
            case R.id.btn_negNum:
                if (textView.getText().toString().equals("0") || isOperationClick){
                    textView.setText("-0");}
                else if  (textView.getText().toString().equals("-0") || isOperationClick){
                    textView.setText("0");}
                else {
                    Integer num_i = Integer.parseInt(textView.getText().toString());
                    Integer num_i_res = num_i*(-1);
                    if(num_i < 0){
                        textView.setText(num_i_res.toString());
                    }
                    else {textView.setText(num_i_res.toString());}
                }
                break;

            case R.id.btn_point:
                if (textView.getText().toString().equals("0") || isOperationClick){
                    textView.setText("0.");
                }
                else{
                    String str_num = textView.getText().toString();
                    textView.setText(str_num+".");
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
        top_btn.animate().alpha(0);
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

            case R.id.btn_percent:
                operation = "%";
                first = Double.parseDouble(textView.getText().toString())/100;
                textView.setText(first.toString());
                break;

            case R.id.btn_equal:
                top_btn.animate().alpha(1).start();
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


                    case "%":

                        Double resultt = first*second;
                        if(resultt==(resultt.intValue())){
                            resultInt = resultt.intValue();
                            textView.setText(resultInt.toString());
                        }
                        else textView.setText(resultt.toString());
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

    public void onClickOpen(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}
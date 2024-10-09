package com.example.lab1_ehe79041;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        display = findViewById(R.id.txtCalOut);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.txtCalDisplay).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String stringToAdd){
        String oldString = display.getText().toString();
        int cursorPosition = display.getSelectionStart();
        String leftString = oldString.substring(0, cursorPosition);

        String rightString = oldString.substring(cursorPosition);
        if(getString(R.string.txtCalDisplay).equals(display.getText().toString())){
            display.setText(stringToAdd);
            display.setSelection(cursorPosition + 1);
        }
        else{
            display.setText(String.format("%s%s%s", leftString, stringToAdd, rightString));
            display.setSelection(cursorPosition + 1);
        }

    }

    public void zeroButton(View view) {
        updateText("0");
    }

    public void oneButton(View view) {
        updateText("1");
    }

    public void twoButton(View view) {
        updateText("2");
    }

    public void threeButton(View view) {
        updateText("3");
    }

    public void fourButton(View view) {
        updateText("4");
    }

    public void fiveButton(View view) {
        updateText("5");
    }

    public void sixButton(View view) {
        updateText("6");
    }

    public void sevenButton(View view) {
        updateText("7");
    }

    public void eightButton(View view) {
        updateText("8");
    }

    public void nineButton(View view) {
        updateText("9");
    }

    public void clearButton(View view) {
        display.setText("");
    }

    public void parenthesisButton(View view) {
        int cursorPosition = display.getSelectionStart();
        int openParen = 0;
        int closeParen = 0;
        int textLength = display.getText().length();

        for(int i = 0 ; i < cursorPosition ; i++){
            if(display.getText().toString().substring(i, i+1).equals("(")){
                openParen += 1;
            }
            if(display.getText().toString().substring(i, i+1).equals(")")){
                closeParen += 1;
            }
        }

        if(openParen == closeParen || display.getText().toString().substring(textLength - 1, textLength).equals("(")){
            updateText("(");
        }
        else if(closeParen < openParen && !display.getText().toString().substring(textLength - 1, textLength).equals("(")){
            updateText(")");
        }

        display.setSelection(cursorPosition + 1);

    }

    public void exponentButton(View view) {
        updateText("^");
    }

    public void divideButton(View view) {
        updateText("÷");
    }

    public void multiplyButton(View view) {
        updateText("x");
    }

    public void subtractButton(View view) {
        updateText("-");
    }

    public void addButton(View view) {
        updateText("+");
    }

    public void equalsButton(View view) {
        String userExpression = display.getText().toString();

        userExpression = userExpression.replaceAll("÷", "/");
        userExpression = userExpression.replaceAll("x", "*");

        Expression ex = new Expression(userExpression);
        String result = String.valueOf(ex.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void pointButton(View view) {
        updateText(".");
    }

    public void backSpaceButton(View view){
        int cursorPosition = display.getSelectionStart();
        int textLength  = display.getText().length();

        if(cursorPosition != 0 && textLength != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPosition - 1, cursorPosition, "");
            display.setText(selection);
            display.setSelection(cursorPosition - 1);
        }

    }


}
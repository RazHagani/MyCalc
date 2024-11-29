package com.example.mycalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    double firstNumber;
    double secondNumber;
    char ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result = findViewById(R.id.TextViewResult);
    }

    public void numFunction(View view) {

        Button button = (Button) view;

        result.append(button.getText().toString());

    }

    public void operFunction(View view) {
        ch = ((Button) view).getText().toString().charAt(0);
        firstNumber = Double.parseDouble(result.getText().toString());
        result.setText("");
    }

    public void resultFunction(View view) {
        secondNumber = Double.parseDouble(result.getText().toString());

        switch (ch){
            case '+':
                result.setText(String.valueOf(firstNumber + secondNumber));
                break;
            case '-':
                result.setText(String.valueOf(firstNumber - secondNumber));
                break;
            case 'x':
                result.setText(String.valueOf(firstNumber * secondNumber));
                break;
            case '/':
                if (secondNumber != 0) {
                    result.setText(String.valueOf(firstNumber / secondNumber));
                } else {
                    result.setText("Error: Division by Zero");
                }
                break;
            default:
                result.setText("Invalid Operation");
        }

    }

}
package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.Math;

public class MainActivity extends AppCompatActivity {
    private Button allClearButton;
    private Button deleteButton;
    private Button percentageButton;
    private Button divisionButton;
    private Button multiplicationButton;
    private Button subtractionButton;
    private Button additionButton;
    private Button pointButton;
    private Button equalButton;
    private Button nineButton;
    private Button eightButton;
    private Button sevenButton;
    private Button sixButton;
    private Button fiveButton;
    private Button fourButton;
    private Button threeButton;
    private Button twoButton;
    private Button oneButton;
    private Button zeroButton;

    private TextView textViewResult;

    private double previousButtonNumber = 0;

    private double arithmeticResult = 0;

    private boolean taskRunning = true;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);

        allClearButton = findViewById(R.id.allClearButton);
        deleteButton = findViewById(R.id.deleteButton);
        percentageButton = findViewById(R.id.percentageButton);
        divisionButton = findViewById(R.id.divisionButton);
        multiplicationButton = findViewById(R.id.multiplicationButton);
        subtractionButton = findViewById(R.id.subtractionButton);
        additionButton = findViewById(R.id.additionButton);
        pointButton = findViewById(R.id.pointButton);
        equalButton = findViewById(R.id.equalButton);
        nineButton = findViewById(R.id.nineButton);
        eightButton = findViewById(R.id.eightButton);
        sevenButton = findViewById(R.id.sevenButton);
        sixButton = findViewById(R.id.sixButton);
        fiveButton = findViewById(R.id.fiveButton);
        fourButton = findViewById(R.id.fourButton);
        threeButton = findViewById(R.id.threeButton);
        twoButton = findViewById(R.id.twoButton);
        oneButton = findViewById(R.id.oneButton);
        zeroButton = findViewById(R.id.zeroButton);

        textViewResult.setText("0");

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinNumbers("9");
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinNumbers("8");
            }
        });
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinNumbers("7");
            }
        });
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinNumbers("6");
            }
        });
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinNumbers("5");;
            }
        });
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinNumbers("4");
            }
        });
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinNumbers("3");
            }
        });
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinNumbers("2");
            }
        });
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinNumbers("1");
            }
        });
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinNumbers("0");
            }
        });
        allClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearView();
            }
        });

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewResult.setText(String.valueOf(arithmeticResult));
            }
        });

        additionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumbers(textViewResult.getText().toString());
            }
        });



        subtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtractNumbers(textViewResult.getText().toString());
            }
        });

        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplyNumbers(textViewResult.getText().toString());
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLastCharacter(textViewResult.getText().toString());
            }
        });

        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        percentageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    @SuppressLint("SetTextI18n")
    public void joinNumbers(String buttonInputString) {
        int buttonInputNumber = Integer.parseInt(buttonInputString);
        // Add the digit to the end of the current number being entered
        previousButtonNumber = (previousButtonNumber * 10) + buttonInputNumber;
        textViewResult.setText(Integer.toString((int) previousButtonNumber));
    }

    public void clearView(){
        textViewResult.setText("0");
        previousButtonNumber = arithmeticResult = 0;
    }

    public void addNumbers(String buttonInputString) {
        double buttonInputNumber = Double.parseDouble(buttonInputString);
        arithmeticResult += buttonInputNumber;
        textViewResult.setText(String.valueOf(arithmeticResult));
        previousButtonNumber = 0;
    }

    public void subtractNumbers(String buttonInputString) {
        double buttonInputNumber = Double.parseDouble(buttonInputString);
        // If arithmeticResult is 0, set it to the button input number
        // Otherwise, subtract the button input number from arithmeticResult
        arithmeticResult = (arithmeticResult == 0) ? buttonInputNumber : arithmeticResult - buttonInputNumber;
        textViewResult.setText(String.valueOf(arithmeticResult));
        previousButtonNumber = 0;
    }



    public void deleteLastCharacter(@NonNull String screenText) {
        // Check if screenText is not empty, remove the last character from the string
        if (!TextUtils.isEmpty(screenText)) {
            String newText = screenText.substring(0, screenText.length() - 1);
            textViewResult.setText(newText);
        } else {
            // If the string is empty, clear the TextView
            clearView();
        }
        previousButtonNumber = Double.parseDouble(textViewResult.getText().toString());
    }

    public void multiplyNumbers(String buttonInputString) {
        double buttonInputNumber = Double.parseDouble(buttonInputString);
        // If arithmeticResult is 0, set it to the button input number
        // Otherwise, multiply the button input number from arithmeticResult
        arithmeticResult = (arithmeticResult == 0) ? buttonInputNumber : arithmeticResult * buttonInputNumber;
        textViewResult.setText(String.valueOf(arithmeticResult));
        previousButtonNumber = 0;
    }

}
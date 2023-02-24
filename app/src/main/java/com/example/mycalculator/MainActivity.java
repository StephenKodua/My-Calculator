package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    private double previousArithmeticResult = 0;

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
                appendInputButtonToPreviousNumber("9");
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInputButtonToPreviousNumber("8");
            }
        });
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInputButtonToPreviousNumber("7");
            }
        });
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInputButtonToPreviousNumber("6");
            }
        });
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInputButtonToPreviousNumber("5");;
            }
        });
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInputButtonToPreviousNumber("4");
            }
        });
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInputButtonToPreviousNumber("3");
            }
        });
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInputButtonToPreviousNumber("2");
            }
        });
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInputButtonToPreviousNumber("1");
            }
        });
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInputButtonToPreviousNumber("0");
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
                updateAdditionResult(textViewResult.getText().toString());
            }
        });



        subtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtractFromArithmeticResult(textViewResult.getText().toString());
            }
        });

        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplyArithmeticResult(textViewResult.getText().toString());
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

    /**
     * Appends the given input digit to the end of the current number being entered and
     * displays the updated result in the text view.
     * @param inputNumberString The input digit as a String.
     */
    @SuppressLint("SetTextI18n")
    public void appendInputButtonToPreviousNumber(String inputNumberString) {
        int inputNumber = Integer.parseInt(inputNumberString);
        // Add the digit to the end of the current number being entered
        int currentNumber = (int) ((previousArithmeticResult * 10) + inputNumber);
        textViewResult.setText(Integer.toString((int) currentNumber));
        previousArithmeticResult = currentNumber;
    }

    /**
     * Clears the current view by resetting the displayed value and arithmetic result values to 0.
     */
    public void clearView() {
        // Reset the displayed value to 0
        textViewResult.setText("0");

        // Reset the arithmetic result values to 0
        previousArithmeticResult = 0;
        arithmeticResult = 0;
    }

    /**
     Updates the current arithmetic result by adding the input number to it
     displays the updated result in the text view.
     Also sets the previous arithmetic result to 0.
     @param inputNumberString The input number as a String.
     */
    public void updateAdditionResult(String inputNumberString) {
        double inputNumber = Double.parseDouble(inputNumberString);
        arithmeticResult += inputNumber;
        textViewResult.setText(String.valueOf(arithmeticResult));
        previousArithmeticResult = 0;
    }

    /**
     * Subtracts the input number from the current arithmetic result.
     * Updates and displays the updated arithmetic result in the text view.
     * Also sets the previous arithmetic result to 0.
     * @param inputNumberString The input number as a String.
     */
    public void subtractFromArithmeticResult(String inputNumberString) {
        double inputNumber = Double.parseDouble(inputNumberString);
        // If the current arithmetic result is 0, set it to the input number
        // Otherwise, subtract the input number from the current arithmetic result
        arithmeticResult = (arithmeticResult == 0) ? inputNumber : arithmeticResult - inputNumber;
        textViewResult.setText(String.valueOf(arithmeticResult));
        previousArithmeticResult = 0;
    }


    /**
     * Deletes the last character from the current number being entered.
     * Displays the updated result in the text view.
     */
    public void deleteLastCharacter(@NonNull String screenText) {
        // Check if screenText is not empty, remove the last character from the string
        if (!TextUtils.isEmpty(screenText)) {
            String newText = screenText.substring(0, screenText.length() - 1);
            textViewResult.setText(newText);
        } else {
            // If the string is empty, clear the TextView
            clearView();
        }
        previousArithmeticResult = Double.parseDouble(textViewResult.getText().toString());
    }

    /**
     * Multiplies the current arithmetic result by the input number.
     * Updates and displays the updated arithmetic result in the text view.
     * Also sets the previous arithmetic result to 0.
     * @param inputNumberString The input number as a String.
     */
    public void multiplyArithmeticResult(String inputNumberString) {
        double inputNumber = Double.parseDouble(inputNumberString);
        // If arithmeticResult is 0, set it to the button input number
        // Otherwise, multiply the button input number from arithmeticResult
        arithmeticResult = (arithmeticResult == 0) ? inputNumber : arithmeticResult * inputNumber;
        textViewResult.setText(String.valueOf(arithmeticResult));
        previousArithmeticResult = 0;
    }


}
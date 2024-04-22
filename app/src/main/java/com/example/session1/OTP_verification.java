package com.example.session1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;

public class OTP_verification extends AppCompatActivity {
    int number1 = 1;
    int number2 = 2;
    int number3 = 3;
    int number4 = 4;
    int number5 = 5;
    int number6 = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otp_verification);

        // Определение и настройка EditText и кнопки
        EditText editTextNumber1 = findViewById(R.id.editTextNumber1);
        EditText editTextNumber2 = findViewById(R.id.editTextNumber2);
        EditText editTextNumber3 = findViewById(R.id.editTextNumber3);
        EditText editTextNumber4 = findViewById(R.id.editTextNumber4);
        EditText editTextNumber5 = findViewById(R.id.editTextNumber5);
        EditText editTextNumber6 = findViewById(R.id.editTextNumber6);
        Button sendNew = findViewById(R.id.sendNew);

        editTextNumber1.setTag(number1);
        editTextNumber2.setTag(number2);
        editTextNumber3.setTag(number3);
        editTextNumber4.setTag(number4);
        editTextNumber5.setTag(number5);
        editTextNumber6.setTag(number6);


// и так далее для остальных EditText


        // Добавление слушателей для каждого EditText
        addTextWatcher(editTextNumber1, editTextNumber2, editTextNumber3, editTextNumber4, editTextNumber5, editTextNumber6, sendNew);

        // Форматирование строки с числами
        String otpMessage = String.format("Ваш OTP: %d%d%d%d%d%d", number1, number2, number3, number4, number5, number6);

        // Вывод сообщения с числами
        Toast.makeText(this, otpMessage, Toast.LENGTH_LONG).show();

        TextView time = findViewById(R.id.timer);
        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                time.setText("resend after: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                time.setText("resend");
                time.setTextColor(Color.BLUE);
            }
        }.start();

        sendNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButtonState(editTextNumber1, editTextNumber2, editTextNumber3, editTextNumber4, editTextNumber5, editTextNumber6, sendNew);
                Intent intent = new Intent(OTP_verification.this, New_Passvord.class);
                startActivity(intent);
            }
        });
    }

    private void addTextWatcher(EditText editTextNumber1, EditText editTextNumber2, EditText editTextNumber3, EditText editTextNumber4, EditText editTextNumber5, EditText editTextNumber6, Button sendNew) {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateButtonState(editTextNumber1, editTextNumber2, editTextNumber3, editTextNumber4, editTextNumber5, editTextNumber6, sendNew);
            }
        };


        editTextNumber1.addTextChangedListener(textWatcher);
        editTextNumber2.addTextChangedListener(textWatcher);
        editTextNumber3.addTextChangedListener(textWatcher);
        editTextNumber4.addTextChangedListener(textWatcher);
        editTextNumber5.addTextChangedListener(textWatcher);
        editTextNumber6.addTextChangedListener(textWatcher);
    }

    private void updateButtonState(EditText editTextNumber1, EditText editTextNumber2, EditText editTextNumber3, EditText editTextNumber4, EditText editTextNumber5, EditText editTextNumber6, Button sendNew) {
        boolean allFilled = true;
        boolean allCorrect = true;
        for (EditText editText : new EditText[]{editTextNumber1, editTextNumber2, editTextNumber3, editTextNumber4, editTextNumber5, editTextNumber6}) {
            if (editText.getText().toString().trim().isEmpty()) {
                allFilled = false;
                break;
            }
            // Проверяем, соответствует ли введенное значение заранее заданному числу
            int enteredNumber = Integer.parseInt(editText.getText().toString().trim());
            int expectedNumber = Integer.parseInt(editText.getTag().toString()); // Предполагается, что каждому EditText установлен тег с ожидаемым числом
            if (enteredNumber != expectedNumber) {
                allCorrect = false;
                break;
            }
        }

        if (allFilled && allCorrect) {
            // Изменение цвета контура EditText на зеленый
            for (EditText editText : new EditText[]{editTextNumber1, editTextNumber2, editTextNumber3, editTextNumber4, editTextNumber5, editTextNumber6}) {
                GradientDrawable gd = new GradientDrawable();
                gd.setColor(Color.WHITE); // Белый фон
                gd.setCornerRadius(10); // Радиус скругления
                gd.setStroke(2, Color.GREEN); // Зеленый контур
                editText.setBackground(gd);
            }

            // Делаем кнопку активной и меняем ее цвет на синий
            sendNew.setEnabled(true);
            sendNew.setBackgroundColor(Color.BLUE); // Установите цвет кнопки на синий
        } else {
            // Если поля заполнены неправильно, делаем кнопку неактивной и возвращаем ее цвет на серый
            // Изменение цвета контура EditText на красный
            for (EditText editText : new EditText[]{editTextNumber1, editTextNumber2, editTextNumber3, editTextNumber4, editTextNumber5, editTextNumber6}) {
                GradientDrawable gd = new GradientDrawable();
                gd.setColor(Color.WHITE); // Белый фон
                gd.setCornerRadius(10); // Радиус скругления
                gd.setStroke(2, Color.RED); // Красный контур
                editText.setBackground(gd);
            }

            sendNew.setEnabled(false);
            sendNew.setBackgroundColor(Color.GRAY); // Установите цвет кнопки на серый
        }
    }
}


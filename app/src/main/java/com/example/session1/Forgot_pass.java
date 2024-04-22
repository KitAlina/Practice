package com.example.session1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Forgot_pass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_pass);

        EditText editTextEmail = findViewById(R.id.email);
        Button sendOTP = findViewById(R.id.sendOtp);
        Button signIn = findViewById(R.id.signIn4);
        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateButtonState(editTextEmail, sendOTP);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Forgot_pass.this, Login_in.class);
                startActivity(intent);
            }
        });
        sendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Forgot_pass.this, OTP_verification.class);
                startActivity(intent);
            }
        });
    }

    // Метод для обновления состояния кнопки
    private void updateButtonState(EditText editTextEmail, Button sendOTP) {
        boolean isEmailFilled = !editTextEmail.getText().toString().trim().isEmpty();

        if (isEmailFilled) {
            sendOTP.setEnabled(true);
            sendOTP.setBackgroundColor(Color.BLUE); // Установите цвет кнопки на синий
        } else {
            sendOTP.setEnabled(false);
            sendOTP.setBackgroundColor(Color.GRAY); // Установите цвет кнопки на серый
        }
    }
    }

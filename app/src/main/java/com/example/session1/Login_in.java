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

public class Login_in extends AppCompatActivity {
    String a = Sign_up.name;
    String b = Sign_up.phone;
    String c = Sign_up.email;
    String d = Sign_up.pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_in);
        Button forgotPass = findViewById(R.id.forgotPass);
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_in.this, Forgot_pass.class);
                startActivity(intent);
            }
        });
        EditText editTextEmail = findViewById(R.id.editTextTextEmailAddress2);
        EditText editPass = findViewById(R.id.editTextTextPassword3);
        Button signUp2 = findViewById(R.id.signUp2);
        Button logIn = findViewById(R.id.logIn); // Добавляем кнопку logIn

        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateButtonState(editTextEmail, editPass, logIn);
            }
        });

        editPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateButtonState(editTextEmail, editPass, logIn);
            }
        });

        signUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_in.this, Sign_up.class);
                startActivity(intent);
            }
        });

        // Добавляем обработчик нажатия на кнопку logIn
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredEmail = editTextEmail.getText().toString().trim();
                String enteredPassword = editPass.getText().toString().trim();

                // Проверяем, совпадают ли введенные данные с сохраненными
                if (enteredEmail.equals(c) && enteredPassword.equals(d) ) {
                    // Данные совпадают, переходим на следующий экран
                    updateButtonState(editTextEmail, editPass, logIn);
                    Intent intent = new Intent(Login_in.this, Home.class);
                    startActivity(intent);
                } else {
                    // Данные не совпадают, показываем сообщение об ошибке

                }
            }
        });
    }

    private void updateButtonState(EditText editTextEmail, EditText editText1, Button login) {
        boolean isEmailFilled = !editTextEmail.getText().toString().trim().isEmpty();
        boolean isPassFilled = !editText1.getText().toString().trim().isEmpty();

        String isEmail = editTextEmail.getText().toString().trim();
        String isPass = editText1.getText().toString().trim();
        if (isEmailFilled && isPassFilled && (isEmail.equals(c)) && (isPass.equals(d))) {
            login.setEnabled(true);
            login.setBackgroundColor(Color.BLUE); // Установите цвет кнопки на синий
        } else {
            login.setEnabled(false);
            login.setBackgroundColor(Color.GRAY); // Установите цвет кнопки на серый
        }


    }
}

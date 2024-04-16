package com.example.session1;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText editTextName = findViewById(R.id.editTextText2);
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        EditText editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        Button signUpButton = findViewById(R.id.signup1);

        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateButtonState(editTextName, editTextPhone, editTextEmail, signUpButton);
            }
        });

        editTextPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateButtonState(editTextName, editTextPhone, editTextEmail, signUpButton);
            }
        });

        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateButtonState(editTextName, editTextPhone, editTextEmail, signUpButton);
            }
        });
    }

    // Метод для обновления состояния кнопки
    private void updateButtonState(EditText editTextName, EditText editTextPhone, EditText editTextEmail, Button signUpButton) {
        boolean isNameFilled = !editTextName.getText().toString().trim().isEmpty();
        boolean isPhoneFilled = !editTextPhone.getText().toString().trim().isEmpty();
        boolean isEmailFilled = !editTextEmail.getText().toString().trim().isEmpty();

        if (isNameFilled && isPhoneFilled && isEmailFilled) {
            signUpButton.setEnabled(true);
            signUpButton.setBackgroundColor(Color.BLUE); // Установите цвет кнопки на синий
        } else {
            signUpButton.setEnabled(false);
            signUpButton.setBackgroundColor(Color.GRAY); // Установите цвет кнопки на серый
        }
    }
}
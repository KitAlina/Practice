package com.example.session1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sign_up extends AppCompatActivity {
    public static String name;
    public static String phone;
    public static String email;
    public static String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText editTextName = findViewById(R.id.editTextText2);
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        EditText editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        CheckBox checkBoxAgreement = findViewById(R.id.checkBox2);
        Button signUpButton = findViewById(R.id.signup1);

        EditText editText1 = findViewById(R.id.editTextTextPassword);
        EditText editText2 = findViewById(R.id.editTextTextPassword2);



        editText1.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                editText1.setTransformationMethod(new SingleLineTransformationMethod());
            } else {
                editText1.setTransformationMethod(new PasswordTransformationMethod());
            }
            // Перемещаем курсор в конец текста
            editText1.setSelection(editText1.getText().length());
        });
        // Добавление обработчиков изменения текста для обеих полей EditText
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateButtonState(editTextName, editTextPhone, editTextEmail, editText1, editText2, checkBoxAgreement, signUpButton);
            }
        });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateButtonState(editTextName, editTextPhone, editTextEmail, editText1, editText2, checkBoxAgreement, signUpButton);
            }
        });


        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateButtonState(editTextName, editTextPhone, editTextEmail, editText1, editText2, checkBoxAgreement, signUpButton);
            }
        });

        editTextPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateButtonState(editTextName, editTextPhone, editTextEmail, editText1, editText2, checkBoxAgreement, signUpButton);
            }
        });

        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateButtonState(editTextName, editTextPhone, editTextEmail, editText1, editText2, checkBoxAgreement, signUpButton);
            }
        });
        // Добавление обработчика изменения состояния CheckBox
        checkBoxAgreement.setOnCheckedChangeListener((buttonView, isChecked) -> {
            updateButtonState(editTextName, editTextPhone, editTextEmail, editText1, editText2, checkBoxAgreement, signUpButton);
        });
        Button signIn3 = findViewById(R.id.signIn3);
        signIn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_up.this, Login_in.class);
                startActivity(intent);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_up.this, Login_in.class);
                startActivity(intent);
            }
        });

    }


    // Метод для обновления состояния кнопки
    private void updateButtonState( EditText editTextName, EditText editTextPhone, EditText editTextEmail, EditText editText1, EditText editText2, CheckBox checkBoxAgreement, Button signUpButton) {
        name = editTextName.getText().toString().trim();
        phone = editTextPhone.getText().toString().trim();
        email = editTextEmail.getText().toString().trim();
        pass = editText1.getText().toString().trim();

        boolean isNameFilled = !editTextName.getText().toString().trim().isEmpty();
        boolean isPhoneFilled = !editTextPhone.getText().toString().trim().isEmpty();
        boolean isEmailFilled = !editTextEmail.getText().toString().trim().isEmpty();
        boolean isPassFilled = !editText1.getText().toString().trim().isEmpty();
        boolean isPassConFilled = !editText2.getText().toString().trim().isEmpty();
        boolean isPassMatch = editText1.getText().toString().trim().equals(editText2.getText().toString().trim());
        boolean isAgreementChecked = checkBoxAgreement.isChecked();

        if (isNameFilled && isPhoneFilled && isEmailFilled && isPassFilled && isPassConFilled && isPassMatch && isAgreementChecked) {
            signUpButton.setEnabled(true);
            signUpButton.setBackgroundColor(Color.BLUE); // Установите цвет кнопки на синий
        } else {
            signUpButton.setEnabled(false);
            signUpButton.setBackgroundColor(Color.GRAY); // Установите цвет кнопки на серый
        }
    }
}
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
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class New_Passvord extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_new_passvord);

            EditText editText1 = findViewById(R.id.editTextTextPassword4);
            EditText editText2 = findViewById(R.id.editTextTextPassword5);
            Button sendNew = findViewById(R.id.sendNew);


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
                    updateButtonState(editText1, editText2, sendNew);
                }
            });

            editText2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {}

                @Override
                public void afterTextChanged(Editable s) {
                    updateButtonState(editText1, editText2, sendNew);
                }
            });

            sendNew.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(New_Passvord.this, Login_in.class);
                    startActivity(intent);
                }
            });
        }

        private void updateButtonState(EditText editText1, EditText editText2, Button sendNew) {
            boolean isPassFilled = !editText1.getText().toString().trim().isEmpty();
            boolean isPassConFilled = !editText2.getText().toString().trim().isEmpty();
            boolean isPassMatch = editText1.getText().toString().trim().equals(editText2.getText().toString().trim());

            if (isPassFilled && isPassConFilled && isPassMatch) {
                sendNew.setEnabled(true);
                sendNew.setBackgroundColor(Color.BLUE); // Установите цвет кнопки на синий
            } else {
                sendNew.setEnabled(false);
                sendNew.setBackgroundColor(Color.GRAY); // Установите цвет кнопки на серый
            }
        }
}

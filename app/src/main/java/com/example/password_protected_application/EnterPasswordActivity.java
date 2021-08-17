package com.example.password_protected_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    String password, password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        // load the password
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        password1 = settings.getString("password1","");
        password =  settings.getString("password","");

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                if (text.equals(password)){
                    // enter the app
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if (text.equals(password1)){
                    // error
                    Intent intent = new Intent(getApplicationContext(), error.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(EnterPasswordActivity.this, "entered password is wrong" , Toast.LENGTH_SHORT).show();;
                }
            }
        });
    }
}
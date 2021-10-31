package com.example.temadam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Client client;
    private EditText emailEdit, usernameEdit, passwordEdit;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        client=new Client();
        emailEdit=findViewById(R.id.editEmail);
        usernameEdit=findViewById(R.id.editUsername2);
        passwordEdit=findViewById(R.id.editPassword2);
        btnRegister=findViewById(R.id.btnCreate);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid()){
                    client.setEmailAdress(emailEdit.getText().toString());
                    client.setPassword(passwordEdit.getText().toString());
                    client.setUsername(usernameEdit.getText().toString());

                    Bundle bundle=new Bundle();
                    bundle.putParcelable("ClientParcel",client);
                    Intent intent=new Intent();
                    intent.putExtra("ClientBundle", bundle);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });


    }

    private boolean isValid() {
        if (!Patterns.EMAIL_ADDRESS.matcher(emailEdit.getText()).matches()) {
            Toast.makeText(RegisterActivity.this, "Email-ul nu este valid", Toast.LENGTH_LONG).show();
            return false;
        }
        if (usernameEdit.getText().toString().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Utilizatorul nu este completat", Toast.LENGTH_LONG).show();
            return false;
        }
        if (passwordEdit.getText().toString().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Parola nu este completat", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
package com.example.temadam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private final int ACTIVITY_REQUEST_CODE=100;
    private EditText usernameEdit, passwordEdit;
    private Button btnLog, btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEdit=findViewById(R.id.editUsername);
        passwordEdit=findViewById(R.id.editPassword);

        btnLog=findViewById(R.id.btnLogin2);
        btnJoin=findViewById(R.id.btnJoin);


        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                //                if(usernameEdit.getText()!=null || passwordEdit.getText()!=null)
//                {
//                    startActivityForResult(intent, ACTIVITY_REQUEST_CODE);
//                }
                startActivityForResult(intent, ACTIVITY_REQUEST_CODE);
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, ListaAntrenamente.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ACTIVITY_REQUEST_CODE){
            if(resultCode==RESULT_OK){
                if(data!=null){
                    Bundle bundle=data.getBundleExtra("ClientBundle");
                    Client client=bundle.getParcelable("ClientParcel");
                    usernameEdit.setText(client.getUsername());
                    passwordEdit.setText(client.getPassword());
                }
            }
        }
    }
}
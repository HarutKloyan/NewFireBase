package com.example.firebasestart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private TextView txtName, txtEmail, txtPassword;
    private EditText edName, edEmail, edPassword;
    private DatabaseReference users;
    private String User_Key = "User";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private  void init(){
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        users = FirebaseDatabase.getInstance().getReference(User_Key);
    }
    public void onClickSave(View view){
        String id = users.getKey();
        String name = edName.getText().toString();
        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();
        txtName.setText(name);
        txtEmail.setText(email);
        txtPassword.setText(password);
        User newUser = new User(id, name, email, password);
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password))
        {
            users.push().setValue(newUser);
            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Есть пустое поле", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickRead(View view){


    }
}
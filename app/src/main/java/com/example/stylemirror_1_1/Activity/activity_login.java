package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stylemirror_1_1.Dbmodels.DatabaseHelper;
import com.example.stylemirror_1_1.databinding.ActivityLoginBinding;

public class activity_login extends AppCompatActivity {
    public static boolean logged = false;
    private ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        binding.logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();

                if(username.equals("")||password.equals(""))
                    Toast.makeText(activity_login.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    if (password.length() >= 6 || password.length() <= 12){
                    Boolean checkCredentials = databaseHelper.checkEmailPassword(username, password);
                    if(checkCredentials == true){
                        Toast.makeText(activity_login.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(activity_login.this, MainActivity.class);
                        intent.putExtra("username",username);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(activity_login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(activity_login.this, "Invalid Password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.nuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_login.this, activity_register.class);
                startActivity(intent);
            }
        });
    }
}

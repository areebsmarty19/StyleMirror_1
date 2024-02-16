package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stylemirror_1_1.Dbmodels.DatabaseHelper;
import com.example.stylemirror_1_1.Dbmodels.UserModel;
import com.example.stylemirror_1_1.databinding.ActivityRegisterBinding;

public class activity_register extends AppCompatActivity {

    ActivityRegisterBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.SignUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = binding.username.getText().toString();
                String email = binding.email.getText().toString();
                String password = binding.password.getText().toString();

                if (username.equals("") || email.equals("") || password.equals(""))
                    Toast.makeText(activity_register.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else {
                    if (password.length() >= 6 || password.length() <= 12) {
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);

                        if (checkUserEmail == false) {
                            Boolean insert = databaseHelper.insertdata(username,email, password);

                            if (insert == true) {
                                Toast.makeText(activity_register.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(activity_register.this, activity_login.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(activity_register.this, "Signup Failed!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(activity_register.this, "User already exists! Please login", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(activity_register.this, "Invalid Password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.existingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_register.this, activity_login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

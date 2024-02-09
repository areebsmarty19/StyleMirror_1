package com.example.stylemirror_1_1.Activity;

//import android.annotation.SuppressLint;
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.util.List;
//import java.util.Objects;
//
//public class activity_register extends AppCompatActivity {
//
//    private FirebaseAuth firebaseAuth;
//    private DatabaseReference databaseReference;
//    private ProgressDialog progressDialog;
//
//    private com.example.stylemirror_1_1.databinding.ActivityRegisterBinding binding;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = com.example.stylemirror_1_1.databinding.ActivityRegisterBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        initProgressDialog();
//
//        firebaseAuth = FirebaseAuth.getInstance();
//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference("Users");
//
//        binding.SignUpbtn.setOnClickListener(v -> {
//            String musername = Objects.requireNonNull(binding.Username.getText()).toString().trim();
//            String memail = Objects.requireNonNull(binding.Email.getText()).toString().trim();
//            String mpassword = Objects.requireNonNull(binding.Password.getText()).toString().trim();
//
//            if(musername.length() >= 5 && !memail.equals("") && mpassword.length()>6)
//            {
//                //Login
//                fetchUserFromEmail(musername, memail, mpassword);
//            }
//            else
//            {
//                Toast.makeText(activity_register.this,"Please enter proper values", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        binding.existingUser.setOnClickListener(v -> {
//            Intent intent = new Intent(activity_register.this,activity_login.class);
//            startActivity(intent);
//            finish();
//        });
//    }
//
//    private void initProgressDialog() {
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Registering user...");
//        progressDialog.setCanceledOnTouchOutside(false);
//    }
//    private void fetchUserFromEmail(String username, String email, String password) {
//        progressDialog.show();
//        firebaseAuth.fetchSignInMethodsForEmail(email)
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        List<String> users = task.getResult().getSignInMethods();
//                        if (users != null) {
//                            if (!users.isEmpty()) {
//                                hideProgress();
//                                Toast.makeText(activity_register.this, "User Already exist", Toast.LENGTH_SHORT).show();
//                            } else {
//                                registerNewUser(username, email, password);
//                            }
//                        }
//                    }
//                }).addOnFailureListener(e -> {
//                    hideProgress();
//                });
//    }
//
//    private void registerNewUser(String username, String email, String password) {
//        firebaseAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        String userId = Objects.requireNonNull(task.getResult().getUser()).getUid();
//                        User user= new User(email,userId,username);
//                        addUserToDB(user);
//                        //Insert to db
//                    } else {
//                        Toast.makeText(activity_register.this, "Register failed", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        hideProgress();
//                    }
//                });
//    }
//    private void addUserToDB(User user) {
//        databaseReference.child(user.getUserId()).setValue(user)
//                .addOnCompleteListener(task -> {
//                    hideProgress();
//                    Intent intent = new Intent(activity_register.this, activity_login.class);
//                    startActivity(intent);
//                    finish();
//                }).addOnFailureListener(e -> {
//                    hideProgress();
//                    Toast.makeText(activity_register.this, "Database failed", Toast.LENGTH_SHORT).show();
//                });
//    }
//    private void hideProgress() {
//        progressDialog.dismiss();
//    }
//}

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
            }
        });
    }
}
//        binding.backIv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });

//        binding.existingUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(activity_register.this, activity_login.class));
//                finish();
//            }
//        });
//
//        binding.SignUpbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                DatabaseHelper db = new DatabaseHelper(activity_register.this);
//                UserModel userModel = new UserModel(binding.username.getText().toString(),binding.email.getText().toString(),binding.password.getText().toString());
//                boolean success = db.registerUser(userModel);
//                if(success){
//                    Toast.makeText(activity_register.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(activity_register.this, activity_login.class));
//                    finish();
//                }
//
//
//            }
//        });
//    }
//}
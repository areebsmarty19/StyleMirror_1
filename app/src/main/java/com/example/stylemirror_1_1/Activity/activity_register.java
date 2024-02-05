package com.example.stylemirror_1_1.Activity;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stylemirror_1_1.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.stylemirror_1_1.databinding.ActivityRegisterBinding;
import java.util.List;
import java.util.Objects;

public class activity_register extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;

    private ActivityRegisterBinding binding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.stylemirror_1_1.databinding.ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initProgressDialog();

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");

        binding.SignUpbtn.setOnClickListener(v -> {
            String musername = Objects.requireNonNull(binding.Username.getText()).toString().trim();
            String memail = Objects.requireNonNull(binding.Email.getText()).toString().trim();
            String mpassword = Objects.requireNonNull(binding.Password.getText()).toString().trim();

            if(musername.length() >= 5 && !memail.equals("") && mpassword.length()>6)
            {

                //Login
                fetchUserFromEmail(musername, memail, mpassword);

            }

            else
            {
                Toast.makeText(activity_register.this,"Please enter proper values", Toast.LENGTH_SHORT).show();
            }
        });


        binding.existingUser.setOnClickListener(v -> {
            Intent intent = new Intent(activity_register.this, activity_login.class);
            startActivity(intent);
            finish();
        });


    }


    private void initProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering user...");
        progressDialog.setCanceledOnTouchOutside(false);
    }


    private void fetchUserFromEmail(String username, String email, String password) {
        progressDialog.show();
        firebaseAuth.fetchSignInMethodsForEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<String> users = task.getResult().getSignInMethods();
                        if (users != null) {
                            if (!users.isEmpty()) {
                                hideProgress();
                                Toast.makeText(activity_register.this, "User Already exist", Toast.LENGTH_SHORT).show();
                            } else {
                                registerNewUser(username, email, password);
                            }
                        }
                    }
                }).addOnFailureListener(e -> {
                    hideProgress();
                });
    }


    private void registerNewUser(String username, String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        String userId = Objects.requireNonNull(task.getResult().getUser()).getUid();

                        String sanitizedEmail = sanitizeEmail(email);
                        User user = new User(email, userId, username);
                        addUserToDB(user,sanitizedEmail);
                        //Insert to db
                    } else {
                        Toast.makeText(activity_register.this, "Register failed", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        hideProgress();
                    }
                });
    }

//    private void addUserToDB(User user) {
//        databaseReference.child(user.getUserId()).setValue(user)
//                .addOnCompleteListener(task -> {
//                    hideProgress();
//                    Intent intent = new Intent(activity_register.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }).addOnFailureListener(e -> {
//                    hideProgress();
//                    Toast.makeText(activity_register.this, "Database failed", Toast.LENGTH_SHORT).show();
//                });
//    }

    private void addUserToDB(User user, String sanitizedEmail) {
        databaseReference.child(sanitizedEmail).setValue(user)
                .addOnCompleteListener(task -> {
                    hideProgress();
                    Intent intent = new Intent(activity_register.this, activity_login.class);
                    startActivity(intent);
                    finish();
                }).addOnFailureListener(e -> {
                    hideProgress();
                    Toast.makeText(activity_register.this, "Database failed", Toast.LENGTH_SHORT).show();
                });
    }

    private String sanitizeEmail(String email) {
        // Replace invalid characters with underscores or any character that suits your needs
        return email.replace(".", "_dot_")
                .replace("#", "_hash_")
                .replace("$", "_dollar_")
                .replace("[", "_leftBracket_")
                .replace("]", "_rightBracket_")
                .replace("@", "_at_");
    }

    private void hideProgress() {
        progressDialog.dismiss();
    }
}
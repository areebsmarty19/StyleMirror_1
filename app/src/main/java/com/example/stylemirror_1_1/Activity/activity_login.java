package com.example.stylemirror_1_1.Activity;

//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.stylemirror_1_1.databinding.ActivityLoginBinding;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
//import java.util.Objects;
//
//public class activity_login extends AppCompatActivity {
//    FirebaseAuth auth;
//
//    private ActivityLoginBinding binding;
//    private ProgressDialog progressDialog;
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = auth.getCurrentUser();
//        if (currentUser != null) {
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//            finish();
//        }
//    }
//
//    private void initProgressDialog() {
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Logging in...");
//        progressDialog.setCanceledOnTouchOutside(false);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityLoginBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        initProgressDialog();
//        auth = FirebaseAuth.getInstance();
//        checkEmptyField();
//        binding.nuser.setOnClickListener(v -> {
//            Intent intent = new Intent(activity_login.this, activity_register.class);
//            startActivity(intent);
//            finish();
//        });
//    }
//
//    public void checkEmptyField() {
//        binding.logbtn.setOnClickListener(view -> {
//            String email, pass;
//            email = Objects.requireNonNull(binding.email.getText()).toString();
//            pass = Objects.requireNonNull(binding.password.getText()).toString();
//            if (TextUtils.isEmpty(email)) {
//                Toast.makeText(activity_login.this, "Enter Email", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            if (TextUtils.isEmpty(pass) && (pass.length() < 6 || pass.length() > 16)) {
//                Toast.makeText(activity_login.this, "Enter valid password", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            userLogin(email, pass);
//
//        });
//    }
//
//    public void userLogin(String email, String pass) {
//        progressDialog.show();
//        auth.signInWithEmailAndPassword(email, pass)
//                .addOnCompleteListener(task -> {
//                    progressDialog.dismiss();
//                    if (task.isSuccessful()) {
//                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(activity_login.this, MainActivity.class);
//                        startActivity(intent);
//                        finish();
//                    } else {
//
//                        Toast.makeText(activity_login.this, "Authentication failed.",
//                                Toast.LENGTH_SHORT).show();
//
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        progressDialog.dismiss();
//                    }
//                });
//
//    }
//}

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
                String email = binding.email.getText().toString();
                String password = binding.password.getText().toString();

                if(email.equals("")||password.equals(""))
                    Toast.makeText(activity_login.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    if (password.length() >= 6 || password.length() <= 12){
                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);
                    if(checkCredentials == true){
                        Toast.makeText(activity_login.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(activity_login.this, MainActivity.class);
                        startActivity(intent);
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
//        register();
//        onClickLogin();
//    }
//
//    private void onClickLogin() {
//        binding.logbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(validateAuth()){
//                    DatabaseHelper db = new DatabaseHelper(activity_login.this);
//                    boolean found = db.validatelogin(binding.username.getText().toString().trim(),binding.password.getText().toString().trim());
//                    if (found == true) {
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        intent.putExtra("name",binding.username.getText().toString().trim());
//                        Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
//                        logged=true;
//                        startActivity(intent);
//                        finish();
//                    }
//                    else {
//                        Toast.makeText(getApplicationContext(),"User not found!",Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),"Enter data in proper format!",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//    private void register() {
//        binding.nuser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(activity_login.this,activity_register.class));
//            }
//        });
//    }
//    public boolean validateAuth(){
//        if((binding.email.getText().toString().isEmpty())||(binding.password.getText().toString().isEmpty())){
//            return false;
//        }
//        else{
//            return true;
//        }
//    }
//}

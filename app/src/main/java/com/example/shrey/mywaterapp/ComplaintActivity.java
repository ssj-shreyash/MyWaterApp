package com.example.shrey.mywaterapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ComplaintActivity extends AppCompatActivity {

    public FirebaseUser currunt_user;
    public FirebaseAuth mAuth;
    public FirebaseDatabase database;
    public DatabaseReference myRef;
    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        Intent intent = getIntent();
        user_id = intent.getStringExtra("user_id");

        currunt_user =FirebaseAuth.getInstance().getCurrentUser();


        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
    }
    
    public void complaint_submit(View view) {

            String complaint_string;
            EditText complaint_box;
            Intent intent = getIntent();
            user_id = intent.getStringExtra("user_id");
            complaint_box = findViewById(R.id.complaint_box);

            complaint_string = complaint_box.getText().toString().trim();

            if (TextUtils.isEmpty(complaint_string))
                Toast.makeText(ComplaintActivity.this, "Please enter the complaint", Toast.LENGTH_SHORT).show();
            else {

                myRef = database.getReference("Users").child(currunt_user.getUid());
                myRef.child("complaint").setValue(complaint_box.getText().toString().trim());
                Toast.makeText(ComplaintActivity.this, "Complaint Register success", Toast.LENGTH_SHORT).show();
            }
            complaint_box.setText("");
        }
    }

package com.example.shrey.mywaterapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class HistoryActivity extends AppCompatActivity {

    String user_id, pay_Name,month1,month2,month3;
    Integer pay1,pay2,pay3,reading1,reading2,reading3;
    DatabaseReference mDatabase, mDatabase2;
    FirebaseUser currunt_user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        currunt_user = FirebaseAuth.getInstance().getCurrentUser();

        final TextView history1,history2,history3,h4,h5,h6,h7,h8,h9;
        history1 = findViewById(R.id.history1);
        history2 = findViewById(R.id.history12);
        history3 = findViewById(R.id.history13);
        h4 = findViewById(R.id.history21);
        h5 = findViewById(R.id.history22);
        h6 = findViewById(R.id.history23);
        h7 = findViewById(R.id.history31);
        h8 = findViewById(R.id.history32);
        h9 = findViewById(R.id.history33);



        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase2 =mDatabase.child("Users").child(currunt_user.getUid()).child("History").child("March");

        mDatabase2.child("Month").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                month1 = dataSnapshot.getValue(String.class);
                history1.setText("\n\t\tMonth\t\t\t\t"+month1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        mDatabase2.child("Reading").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                reading1 = dataSnapshot.getValue(Integer.class);
                history2.setText("\n\t\tReading\t\t\t\t"+reading1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        mDatabase2.child("Rs").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pay1 = dataSnapshot.getValue(Integer.class);
                history3.setText("\n\t\tRs.\t\t\t\t"+pay1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        mDatabase2 =mDatabase.child("Users").child(currunt_user.getUid()).child("History").child("April");

        mDatabase2.child("Month").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                month1 = dataSnapshot.getValue(String.class);
                h4.setText("\n\t\tMonth\t\t\t\t"+month1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        mDatabase2.child("Reading").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                reading1 = dataSnapshot.getValue(Integer.class);
                h5.setText("\n\t\tReading\t\t\t\t"+reading1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        mDatabase2.child("Rs").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pay1 = dataSnapshot.getValue(Integer.class);
                h6.setText("\n\t\tRs.\t\t\t\t"+pay1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        mDatabase2 =mDatabase.child("Users").child(currunt_user.getUid()).child("History").child("May");

        mDatabase2.child("Month").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                month1 = dataSnapshot.getValue(String.class);
                h7.setText("\n\t\tMonth\t\t\t\t"+month1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        mDatabase2.child("Reading").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                reading1 = dataSnapshot.getValue(Integer.class);
                h8.setText("\n\t\tReading\t\t\t\t"+reading1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        mDatabase2.child("Rs").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pay1 = dataSnapshot.getValue(Integer.class);
                h9.setText("\n\t\tRs.\t\t\t\t"+pay1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }

}

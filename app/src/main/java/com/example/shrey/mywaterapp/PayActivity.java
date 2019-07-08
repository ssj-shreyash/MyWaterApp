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


public class PayActivity extends AppCompatActivity {

    String user_id,pay_Name,pay_Month;
    Integer pay_Reading,pay_Rs;
    DatabaseReference mDatabase,mDatabase2;
    FirebaseUser currunt_user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        final TextView pay_name,pay_reading,pay_month,pay_rs;

        Intent intent = new Intent();
        user_id=intent.getStringExtra("user_id");


        pay_name = findViewById(R.id.pay_name);
        pay_reading= findViewById(R.id.pay_reading);
        pay_month= findViewById(R.id.pay_month);
        pay_rs = findViewById(R.id.pay_rs);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        currunt_user = FirebaseAuth.getInstance().getCurrentUser();

        mDatabase2 =mDatabase.child("Users").child(currunt_user.getUid());

        mDatabase2.child("Name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pay_Name=dataSnapshot.getValue(String.class);
                pay_name.setText("Name\t\t\t"+pay_Name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


        mDatabase2.child("Month").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pay_Month=dataSnapshot.getValue(String.class);
                pay_month.setText("Month\t\t\t"+pay_Month);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


        mDatabase2.child("Reading").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pay_Reading=dataSnapshot.getValue(Integer.class);
                pay_reading.setText("Reading\t\t\t"+pay_Reading);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        mDatabase2.child("Pay").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pay_Rs= dataSnapshot.getValue(Integer.class);
                pay_rs.setText("Rs\t\t\t"+pay_Rs);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}

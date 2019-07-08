package com.example.shrey.mywaterapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView header = findViewById(R.id.header);
        TextView version = findViewById(R.id.version);
        TextView content = findViewById(R.id.content);

        header.setText("Water Monitoring App");

        version.setText("Application Version - 1.2 ");

        content.setText("This app is for those people who have the water sensor module install in thier home.");


    }
}

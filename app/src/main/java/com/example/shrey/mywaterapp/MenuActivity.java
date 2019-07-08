package com.example.shrey.mywaterapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuActivity extends AppCompatActivity {

   // String user_id;
    FirebaseUser CurrentUser;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        TextView user_home = findViewById(R.id.home_user);
        Intent intent = getIntent();
        String info = intent.getStringExtra("user_info");
        CurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        user_home.setText(info);
    }

    public  void pay(View view)
    {
        Intent intent = new Intent(MenuActivity.this,PayActivity.class);
        //intent.putExtra("user_id",user_id);
        startActivity(intent);
    }

    public void tips(View view)
    {

            Intent intent = new Intent(MenuActivity.this, TipsActivity.class);
            startActivity(intent);
        }

    public void complaint(View view)
    {

            Intent intent = new Intent(MenuActivity.this, ComplaintActivity.class);

           // intent.putExtra("user_id", user_id);

            startActivity(intent);
        }


    public void history(View view)
    {
                Intent intent = new Intent(MenuActivity.this,HistoryActivity.class);
                startActivity(intent);
    }

    public void setting(View view) {

            Intent intent = new Intent(MenuActivity.this, SettingActivity.class);
           // intent.putExtra("user_id", user_id);
            startActivity(intent);
        }
        public void about(View view)
        {
                Intent intent = new Intent (MenuActivity.this,AboutActivity.class);
            startActivity(intent);
        }



    public void logout_button(View view) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        Intent intent = new Intent(MenuActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}

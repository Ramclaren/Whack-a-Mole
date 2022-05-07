package com.example.wackamole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Boolean win = extras.getBoolean("win");
            if(win) {
                Toast.makeText(this, "You Win!",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
    public void onClick (View view) {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
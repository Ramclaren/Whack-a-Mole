package com.example.wackamole;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    final int min = 0;
    final int max = 8;
    int random = new Random().nextInt((max - min) + 1) + min;
    int combo = 1;
    Boolean mole0 = false;
    Boolean mole1 = false;
    Boolean mole2 = false;
    Boolean mole3 = false;
    Boolean mole4 = false;
    Boolean mole5 = false;
    Boolean mole6 = false;
    Boolean mole7 = false;
    Boolean mole8 = false;
    Boolean paused = false;
    List<Boolean> moles = new ArrayList<Boolean>(Arrays.asList(mole0,mole1,mole2,mole3,mole4,mole5,mole6,mole7,mole8));
    Snackbar comboCounter,miss,time, pause, resume;
    Timer timer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comboCounter = Snackbar.make(findViewById(R.id.tapTheMole), "You've hit " + combo + " moles in a row!", 1000);
        miss = Snackbar.make(findViewById(R.id.tapTheMole), "That's not a mole!", 1000);
        pause = Snackbar.make(findViewById(R.id.tapTheMole), "Paused!" , 500);
        resume = Snackbar.make(findViewById(R.id.tapTheMole), "Resumed!" , 500);
        timer = new Timer();
        timer.schedule(new task(), 0,5000);
        setMole();
    }

    public void onClick (View view) {
        comboCounter = Snackbar.make(findViewById(R.id.tapTheMole), "You've hit " + combo + " moles in a row!", 1000);
        if(combo >= 10) {
            Intent intent = new Intent(this, SplashActivity.class);
            intent.putExtra("win", true);
            startActivity(intent);
        }

        if (view == findViewById(R.id.toSplashButton)) {
            Intent intent = new Intent(this, SplashActivity.class);
            intent.putExtra("win", false);
            startActivity(intent);
        }

        if(paused == false) {
            timer.cancel();
            timer.purge();
            timer = new Timer();
            timer.schedule(new task(), 0,5000);
        switch (view.getId()) {
                case R.id.button0:
                    if (mole0) {
                        combo++;
                        ImageButton btn = (ImageButton) view;
                        btn.setImageResource(R.drawable.hole);
                        mole0 = false;
                        setMole();
                        comboCounter.show();

                    } else {
                        combo = 1;
                        miss.show();
                    }
                    break;
                case R.id.button1:
                    if (mole1) {
                        combo++;
                        ImageButton btn = (ImageButton) view;
                        btn.setImageResource(R.drawable.hole);
                        mole1 = false;
                        setMole();
                        comboCounter.show();
                    } else {
                        combo = 1;
                        miss.show();
                    }
                    break;
                case R.id.button2:
                    if (mole2) {
                        combo++;
                        ImageButton btn = (ImageButton) view;
                        btn.setImageResource(R.drawable.hole);
                        mole2 = false;
                        setMole();
                        comboCounter.show();
                    } else {
                        combo = 1;
                        miss.show();
                    }
                    break;
                case R.id.button3:
                    if (mole3) {
                        combo++;
                        ImageButton btn = (ImageButton) view;
                        btn.setImageResource(R.drawable.hole);
                        mole3 = false;
                        setMole();
                        comboCounter.show();
                    } else {
                        combo = 1;
                        miss.show();
                    }
                    break;
                case R.id.button4:
                    if (mole4) {
                        combo++;
                        ImageButton btn = (ImageButton) view;
                        btn.setImageResource(R.drawable.hole);
                        mole4 = false;
                        setMole();
                        comboCounter.show();
                    } else {
                        combo = 1;
                        miss.show();
                    }
                    break;
                case R.id.button5:
                    if (mole5) {
                        combo++;
                        ImageButton btn = (ImageButton) view;
                        btn.setImageResource(R.drawable.hole);
                        mole5 = false;
                        setMole();
                        comboCounter.show();
                    } else {
                        combo = 1;
                        miss.show();
                    }
                    break;
                case R.id.button6:
                    if (mole6) {
                        combo++;
                        ImageButton btn = (ImageButton) view;
                        btn.setImageResource(R.drawable.hole);
                        mole6 = false;
                        setMole();
                        comboCounter.show();
                    } else {
                        combo = 1;
                        miss.show();
                    }
                    break;
                case R.id.button7:
                    if (mole7) {
                        combo++;
                        ImageButton btn = (ImageButton) view;
                        btn.setImageResource(R.drawable.hole);
                        mole7 = false;
                        setMole();
                        comboCounter.show();
                    } else {
                        combo = 1;
                        miss.show();
                    }
                    break;
                case R.id.button8:
                    if (mole8) {
                        combo++;
                        ImageButton btn = (ImageButton) view;
                        btn.setImageResource(R.drawable.hole);
                        mole8 = false;
                        setMole();
                        comboCounter.show();
                    } else {
                        combo = 1;
                        miss.show();
                    }
                    break;
            case R.id.pauseButton:
                    timer.cancel();
                    timer.purge();
                    paused = true;
                    pause.show();
                break;
            }
        } else if (view == findViewById(R.id.pauseButton)) {
            paused = false;
            timer = new Timer();
            timer.scheduleAtFixedRate(new task(), 0, 5000);
            resume.show();
        }
    }

    public void setMole () {
        if (random == 0) {
            mole0 = true;
            ImageButton btn = (ImageButton) findViewById(R.id.button0);
            btn.setImageResource(R.drawable.mole);
            random = new Random().nextInt((max - min) + 1) + min;
        }
        else if (random == 1) {
            mole1 = true;
            ImageButton btn = (ImageButton) findViewById(R.id.button1);
            btn.setImageResource(R.drawable.mole);
            random = new Random().nextInt((max - min) + 1) + min;
        }
        else if (random == 2) {
            mole2 = true;
            ImageButton btn = (ImageButton) findViewById(R.id.button2);
            btn.setImageResource(R.drawable.mole);
            random = new Random().nextInt((max - min) + 1) + min;
        }
        else if (random == 3) {
            mole3 = true;
            ImageButton btn = (ImageButton) findViewById(R.id.button3);
            btn.setImageResource(R.drawable.mole);
            random = new Random().nextInt((max - min) + 1) + min;
        }
        else if (random == 4) {
            mole4 = true;
            ImageButton btn = (ImageButton) findViewById(R.id.button4);
            btn.setImageResource(R.drawable.mole);
            random = new Random().nextInt((max - min) + 1) + min;
        }
        else if (random == 5) {
            mole5 = true;
            ImageButton btn = (ImageButton) findViewById(R.id.button5);
            btn.setImageResource(R.drawable.mole);
            random = new Random().nextInt((max - min) + 1) + min;
        }
        else if (random == 6) {
            mole6 = true;
            ImageButton btn = (ImageButton) findViewById(R.id.button6);
            btn.setImageResource(R.drawable.mole);
            random = new Random().nextInt((max - min) + 1) + min;
        }
        else if (random == 7) {
            mole7 = true;
            ImageButton btn = (ImageButton) findViewById(R.id.button7);
            btn.setImageResource(R.drawable.mole);
            random = new Random().nextInt((max - min) + 1) + min;
        }
        else if (random == 8) {
            mole8 = true;
            ImageButton btn = (ImageButton) findViewById(R.id.button8);
            btn.setImageResource(R.drawable.mole);
            random = new Random().nextInt((max - min) + 1) + min;
        } else {

        }
    }

    class task extends TimerTask {

        @Override
        public void run() {
            //setMole();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        timer.cancel();
        timer.purge();
    }
}

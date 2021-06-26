package com.example.laboratorio6;

// Import packages for android
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import java.util.Random;
import android.os.Handler;

import org.w3c.dom.Text;

// MainActivity class
public class MainActivity extends AppCompatActivity {
    public Button alarmButton, arcadeButton, dogButton, gooseButton, coinButton, whooshButton, startButton;
    public MediaPlayer arcadeSound, dogSound, gooseSound, whooshSound, coinSound, alarmSound;
    public int sequence[] = new int[4];
    public int currentPos;
    public int userSequence[] = new int[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare ALL buttons preemptively
        Button alarmButton = (Button) this.findViewById(R.id.alarmButton);
        Button arcadeButton = (Button) this.findViewById(R.id.arcadeButton);
        Button dogButton = (Button) this.findViewById(R.id.dogButton);
        Button gooseButton = (Button) this.findViewById(R.id.gooseButton);
        Button coinButton = (Button) this.findViewById(R.id.coinButton);
        Button whooshButton = (Button) this.findViewById(R.id.whooshButton);
        Button startButton = (Button) this.findViewById(R.id.startButton);

        // On startup, use color presets
        alarmButton.setBackgroundColor(getResources().getColor(R.color.DarkGoldenrod));
        arcadeButton.setBackgroundColor(getResources().getColor(R.color.DarkViolet));
        dogButton.setBackgroundColor(getResources().getColor(R.color.SaddleBrown));
        gooseButton.setBackgroundColor(getResources().getColor(R.color.SlateGray));
        coinButton.setBackgroundColor(getResources().getColor(R.color.Gold));
        whooshButton.setBackgroundColor(getResources().getColor(R.color.Plum));
        startButton.setBackgroundColor(getResources().getColor(R.color.SandyBrown));

        // Start button:
        startButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Declare sequence on start button click
                for (int i = 0; i < 4; i++) {
                    sequence[i] = (int) (Math.random() * 6) + 1;
                }
                currentPos = 0;
                // Set all buttons
                alarmButton.setBackgroundColor(getResources().getColor(R.color.DarkGoldenrod));
                arcadeButton.setBackgroundColor(getResources().getColor(R.color.DarkViolet));
                dogButton.setBackgroundColor(getResources().getColor(R.color.SaddleBrown));
                gooseButton.setBackgroundColor(getResources().getColor(R.color.SlateGray));
                coinButton.setBackgroundColor(getResources().getColor(R.color.Gold));
                whooshButton.setBackgroundColor(getResources().getColor(R.color.Plum));
                startButton.setBackgroundColor(getResources().getColor(R.color.Goldenrod));
                startButton.setEnabled(false);
                // Start button delay handler
                Handler handlerA = new Handler();
                handlerA.postDelayed(new Runnable() {
                    public void run() {
                        // set start button
                        startButton.setBackgroundColor(getResources().getColor(R.color.SandyBrown));
                    }
                }, 1000);
                // Pattern delay handler
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    public void run() {
                        button_show(sequence[0]);
                        Handler handler2 = new Handler();
                        handler2.postDelayed(new Runnable() {
                            public void run() {
                                button_show(sequence[1]);
                                Handler handler3 = new Handler();
                                handler3.postDelayed(new Runnable() {
                                    public void run() {
                                        button_show(sequence[2]);
                                        Handler handler4 = new Handler();
                                        handler4.postDelayed(new Runnable() {
                                            public void run() {
                                                button_show(sequence[3]);
                                                // re-enable start button
                                                startButton.setEnabled(true);
                                            }
                                        }, 2000);
                                    }
                                }, 2000);
                            }
                        }, 2000);
                    }
                }, 1000);

            }
        });

        // Pattern-Button onClick Listeners:

        // Arcade Sound:
        arcadeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                button_show(1);
                userSequence[currentPos] = 1;
                currentPos = currentPos + 1;
                // Time to check sequence
                int fail = 0;
                if (currentPos == 4){
                    currentPos = 0;
                    for (int i = 0; i < 4; i++)
                        if (userSequence[i] != sequence[i]) {
                            fail = 1;
                        }
                    // Outside for
                    if (fail == 0) {
                        startButton.setBackgroundColor(getResources().getColor(R.color.Green));
                    }
                    else {
                        startButton.setBackgroundColor(getResources().getColor(R.color.Red));
                    }
                }
            }
        });

        // Dog sound:
        dogButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                button_show(4);
                userSequence[currentPos] = 4;
                currentPos = currentPos + 1;
                // Time to check sequence
                int fail = 0;
                if (currentPos == 4){
                    currentPos = 0;
                    for (int i = 0; i < 4; i++)
                        if (userSequence[i] != sequence[i]) {
                            fail = 1;
                        }
                    // Outside for
                    if (fail == 0) {
                        startButton.setBackgroundColor(getResources().getColor(R.color.Green));
                    }
                    else {
                        startButton.setBackgroundColor(getResources().getColor(R.color.Red));
                    }
                }
            }
        });

        // Goose sound:
        gooseButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                button_show(3);
                userSequence[currentPos] = 3;
                currentPos = currentPos + 1;
                // Time to check sequence
                int fail = 0;
                if (currentPos == 4){
                    currentPos = 0;
                    for (int i = 0; i < 4; i++)
                        if (userSequence[i] != sequence[i]) {
                            fail = 1;
                        }
                    // Outside for
                    if (fail == 0) {
                        startButton.setBackgroundColor(getResources().getColor(R.color.Green));
                    }
                    else {
                        startButton.setBackgroundColor(getResources().getColor(R.color.Red));
                    }
                }
            }
        });

        // Coin sound:
        coinButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                button_show(5);
                userSequence[currentPos] = 5;
                currentPos = currentPos + 1;
                // Time to check sequence
                int fail = 0;
                if (currentPos == 4){
                    currentPos = 0;
                    for (int i = 0; i < 4; i++)
                        if (userSequence[i] != sequence[i]) {
                            fail = 1;
                        }
                    // Outside for
                    if (fail == 0) {
                        startButton.setBackgroundColor(getResources().getColor(R.color.Green));
                    }
                    else {
                        startButton.setBackgroundColor(getResources().getColor(R.color.Red));
                    }
                }
            }
        });

        // Whoosh sound:
        whooshButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                button_show(6);
                userSequence[currentPos] = 6;
                currentPos = currentPos + 1;
                // Time to check sequence
                int fail = 0;
                if (currentPos == 4){
                    currentPos = 0;
                    for (int i = 0; i < 4; i++)
                        if (userSequence[i] != sequence[i]) {
                            fail = 1;
                        }
                    // Outside for
                    if (fail == 0) {
                        startButton.setBackgroundColor(getResources().getColor(R.color.Green));
                    }
                    else {
                        startButton.setBackgroundColor(getResources().getColor(R.color.Red));
                    }
                }
            }
        });

        // Alarm sound:
        alarmButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                button_show(2);
                userSequence[currentPos] = 2;
                currentPos = currentPos + 1;
                // Time to check sequence
                int fail = 0;
                if (currentPos == 4){
                    currentPos = 0;
                    for (int i = 0; i < 4; i++)
                        if (userSequence[i] != sequence[i]) {
                            fail = 1;
                        }
                    // Outside for
                    if (fail == 0) {
                        startButton.setBackgroundColor(getResources().getColor(R.color.Green));
                    }
                    else {
                        startButton.setBackgroundColor(getResources().getColor(R.color.Red));

                    }
                }
            }
        });

        // OUTSIDE INITIALIZE:
    }

    // Button show method
    public void button_show(int num) {
        // Declare ALL buttons preemptively
        Button alarmButton = (Button) this.findViewById(R.id.alarmButton);
        Button arcadeButton = (Button) this.findViewById(R.id.arcadeButton);
        Button dogButton = (Button) this.findViewById(R.id.dogButton);
        Button gooseButton = (Button) this.findViewById(R.id.gooseButton);
        Button coinButton = (Button) this.findViewById(R.id.coinButton);
        Button whooshButton = (Button) this.findViewById(R.id.whooshButton);
        Button startButton = (Button) this.findViewById(R.id.startButton);

        // Declare ALL media players preemptively
        final MediaPlayer arcadeSound = MediaPlayer.create(this, R.raw.arcade);
        final MediaPlayer dogSound = MediaPlayer.create(this, R.raw.dog);
        final MediaPlayer gooseSound = MediaPlayer.create(this, R.raw.geese);
        final MediaPlayer whooshSound = MediaPlayer.create(this, R.raw.whoosh);
        final MediaPlayer coinSound = MediaPlayer.create(this, R.raw.coinwin);
        final MediaPlayer alarmSound = MediaPlayer.create(this, R.raw.alarm);

        // Multiples ifs
        if (num == 1) {
            arcadeSound.start();
            arcadeButton.setBackgroundColor(getResources().getColor(R.color.Lavender));
            arcadeButton.setEnabled(false);
            // clickability
            alarmButton.setClickable(false);
            arcadeButton.setClickable(false);
            dogButton.setClickable(false);
            gooseButton.setClickable(false);
            coinButton.setClickable(false);
            whooshButton.setClickable(false);
            Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                public void run() {
                    arcadeSound.pause();
                    arcadeButton.setEnabled(true);
                    alarmButton.setClickable(true);
                    arcadeButton.setClickable(true);
                    dogButton.setClickable(true);
                    gooseButton.setClickable(true);
                    coinButton.setClickable(true);
                    whooshButton.setClickable(true);
                    arcadeButton.setBackgroundColor(getResources().getColor(R.color.DarkViolet));
                }
            }, 1500);
        }
        else if (num == 2) {
            alarmSound.start();
            alarmButton.setBackgroundColor(getResources().getColor(R.color.Tan));
            alarmButton.setEnabled(false);
            // clickability
            alarmButton.setClickable(false);
            arcadeButton.setClickable(false);
            dogButton.setClickable(false);
            gooseButton.setClickable(false);
            coinButton.setClickable(false);
            whooshButton.setClickable(false);
            Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                public void run() {
                    alarmSound.pause();
                    alarmButton.setBackgroundColor(getResources().getColor(R.color.DarkGoldenrod));
                    alarmButton.setEnabled(true);
                    alarmButton.setClickable(true);
                    arcadeButton.setClickable(true);
                    dogButton.setClickable(true);
                    gooseButton.setClickable(true);
                    coinButton.setClickable(true);
                    whooshButton.setClickable(true);
                }
            }, 1500);
        }
        else if (num == 3) {
            gooseSound.start();
            gooseButton.setBackgroundColor(getResources().getColor(R.color.Silver));
            gooseButton.setEnabled(false);
            // clickability
            alarmButton.setClickable(false);
            arcadeButton.setClickable(false);
            dogButton.setClickable(false);
            gooseButton.setClickable(false);
            coinButton.setClickable(false);
            whooshButton.setClickable(false);
            Handler handler3 = new Handler();
            handler3.postDelayed(new Runnable() {
                public void run() {
                    gooseSound.pause();
                    gooseButton.setBackgroundColor(getResources().getColor(R.color.SlateGray));
                    gooseButton.setEnabled(true);
                    alarmButton.setClickable(true);
                    arcadeButton.setClickable(true);
                    dogButton.setClickable(true);
                    gooseButton.setClickable(true);
                    coinButton.setClickable(true);
                    whooshButton.setClickable(true);
                }
            }, 1500);
        }
        else if (num == 4){
            dogSound.start();
            dogButton.setBackgroundColor(getResources().getColor(R.color.RosyBrown));
            dogButton.setEnabled(false);
            // clickability
            alarmButton.setClickable(false);
            arcadeButton.setClickable(false);
            dogButton.setClickable(false);
            gooseButton.setClickable(false);
            coinButton.setClickable(false);
            whooshButton.setClickable(false);
            Handler handler4 = new Handler();
            handler4.postDelayed(new Runnable() {
                public void run() {
                    dogSound.pause();
                    dogButton.setBackgroundColor(getResources().getColor(R.color.SaddleBrown));
                    dogButton.setEnabled(true);
                    alarmButton.setClickable(true);
                    arcadeButton.setClickable(true);
                    dogButton.setClickable(true);
                    gooseButton.setClickable(true);
                    coinButton.setClickable(true);
                    whooshButton.setClickable(true);
                }
            }, 1500);
        }
        else if (num == 5) {
            coinSound.start();
            coinButton.setBackgroundColor(getResources().getColor(R.color.Wheat));
            coinButton.setEnabled(false);
            // clickability
            alarmButton.setClickable(false);
            arcadeButton.setClickable(false);
            dogButton.setClickable(false);
            gooseButton.setClickable(false);
            coinButton.setClickable(false);
            whooshButton.setClickable(false);
            Handler handler5 = new Handler();
            handler5.postDelayed(new Runnable() {
                public void run() {
                    coinSound.pause();
                    coinButton.setBackgroundColor(getResources().getColor(R.color.Gold));
                    coinButton.setEnabled(true);
                    alarmButton.setClickable(true);
                    arcadeButton.setClickable(true);
                    dogButton.setClickable(true);
                    gooseButton.setClickable(true);
                    coinButton.setClickable(true);
                    whooshButton.setClickable(true);
                }
            }, 1500);
        }
        else if (num == 6) {
            whooshSound.start();
            whooshButton.setBackgroundColor(getResources().getColor(R.color.MediumVioletRed));
            whooshButton.setEnabled(false);
            // clickability
            alarmButton.setClickable(false);
            arcadeButton.setClickable(false);
            dogButton.setClickable(false);
            gooseButton.setClickable(false);
            coinButton.setClickable(false);
            whooshButton.setClickable(false);
            Handler handler6 = new Handler();
            handler6.postDelayed(new Runnable() {
                public void run() {
                    whooshSound.pause();
                    whooshButton.setBackgroundColor(getResources().getColor(R.color.Plum));
                    whooshButton.setEnabled(true);
                    alarmButton.setClickable(true);
                    arcadeButton.setClickable(true);
                    dogButton.setClickable(true);
                    gooseButton.setClickable(true);
                    coinButton.setClickable(true);
                    whooshButton.setClickable(true);
                }
            }, 1500);
        }

    }

    // OUTSIDE MAINACTIVITY:
}
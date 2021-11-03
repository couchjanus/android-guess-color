package com.example.checkcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import android.os.CountDownTimer;

import android.graphics.Color;
import java.util.Random;

import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int currentColor;
    int guessColor;
    int scoreYes = 0;
    int scoreNo = 0;

    public void displayResult(String result){
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
    }

    public void guessYes(View view){
        if (guessColor == currentColor){
            scoreYes++;
        }
    }

    public void guessNo(View view){
        if (guessColor != currentColor){
            scoreNo++;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textHeader = findViewById(R.id.header);
        textHeader.setText("Чи співпадає назва кольору зліва з кольором техта зправа?");
        TextView textViewRight = findViewById(R.id.textViewRight);
        TextView textViewLeft = findViewById(R.id.textViewLeft);
        TextView textViewScore = findViewById(R.id.textViewScore);
        Random rand = new Random();
        currentColor = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        textViewLeft.setBackgroundColor(currentColor);

        new CountDownTimer(30000,1000){
            public void onTick(long millisUntilFinished){
                textViewRight.setText("seconds: " + millisUntilFinished / 1000);
                guessColor = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                textViewRight.setBackgroundColor(guessColor);
            }
            public void onFinish(){
                textViewScore.setText("score yes: " + scoreYes + " score no: " + scoreNo);
                displayResult("All done: ");
            }
        }.start();
//        displayResult("All done: ");

    }
}
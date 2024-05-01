package com.example.zdravy_dnevnik;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private int score = 0;
    private TextView scoreTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button buttonMain = findViewById(R.id.buttonMain);
        Button buttonTraining = findViewById(R.id.buttonTraining);
        Button buttonJokes = findViewById(R.id.buttonJokes);
        scoreTextView = findViewById(R.id.scoreTextView);

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на activity_main
                Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        buttonTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на activity_main2
                Intent intent = new Intent(MainActivity2.this, TrainingActivity.class);
                startActivity(intent);
            }
        });

        buttonJokes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на activity_main3
                Intent intent = new Intent(MainActivity2.this, MotivationActivity.class);
                startActivity(intent);
            }
        });
        ImageView giriImageView = findViewById(R.id.giriImageView);
        giriImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обработка клика на изображение гири
                incrementScore();
            }
        });
    }

    private void incrementScore() {
        score++;
        scoreTextView.setText("Счёт: " + score);
    }
}
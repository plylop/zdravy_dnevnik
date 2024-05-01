package com.example.zdravy_dnevnik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MotivationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Button buttonMain = findViewById(R.id.buttonMain);
        Button buttonTraining = findViewById(R.id.buttonTraining);
        Button buttonJokes = findViewById(R.id.buttonJokes);

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на activity_main
                Intent intent = new Intent(MotivationActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        buttonTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на activity_main2
                Intent intent = new Intent(MotivationActivity.this, TrainingActivity.class);
                startActivity(intent);
            }
        });

        buttonJokes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на activity_main3
                Intent intent = new Intent(MotivationActivity.this, MotivationActivity.class);
                startActivity(intent);
            }
        });
    }
}

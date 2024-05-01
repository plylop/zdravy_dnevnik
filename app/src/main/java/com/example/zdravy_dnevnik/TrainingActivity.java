package com.example.zdravy_dnevnik;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TrainingActivity extends AppCompatActivity {
    private EditText timeInput;
    private Button startButton;
    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long timeLeftInMillis;
    private MediaPlayer mediaPlayer;
    private int counter = 0;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        timeInput = findViewById(R.id.timeInput);
        startButton = findViewById(R.id.startButton);
        mediaPlayer = MediaPlayer.create(this, R.raw.alert_sound); // Поместите ваш звуковой файл в папку res/raw и назовите его alert_sound
        counterTextView = findViewById(R.id.counterTextView);

        startButton.setOnClickListener(v -> startStop());

        Button buttonMain = findViewById(R.id.buttonMain);
        Button buttonTraining = findViewById(R.id.buttonTraining);
        Button buttonJokes = findViewById(R.id.buttonJokes);
        Button incrementButton = findViewById(R.id.incrementButton);
        Button resetButton = findViewById(R.id.resetButton);

        buttonMain.setOnClickListener(v -> {
            // Переход на activity_main
            Intent intent = new Intent(TrainingActivity.this, MainActivity2.class);
            startActivity(intent);
        });

        buttonTraining.setOnClickListener(v -> {
            // Переход на activity_main2
            Intent intent = new Intent(TrainingActivity.this, TrainingActivity.class);
            startActivity(intent);
        });

        buttonJokes.setOnClickListener(v -> {
            // Переход на activity_main3
            Intent intent = new Intent(TrainingActivity.this, MotivationActivity.class);
            startActivity(intent);
        });

        incrementButton.setOnClickListener(v -> incrementCounter());
        resetButton.setOnClickListener(v -> resetCounter());
    }

    private void startStop() {
        if (timerRunning) {
            stopTimer();
        } else {
            String input = timeInput.getText().toString();
            if (input.isEmpty()) {
                Toast.makeText(this, "Введите время", Toast.LENGTH_SHORT).show();
                return;
            }
            long millisInput = Long.parseLong(input) * 1000;
            if (millisInput == 0) {
                Toast.makeText(this, "Введите положительное число", Toast.LENGTH_SHORT).show();
                return;
            }
            setTime(millisInput);
            startTimer();
        }
    }

    private void setTime(long milliseconds) {
        timeLeftInMillis = milliseconds;
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                updateWatchInterface();
                playAlarmSound();
            }
        }.start();

        timerRunning = true;
        updateWatchInterface();
    }

    private void stopTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        updateWatchInterface();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
        timeInput.setText(timeLeftFormatted);
    }

    private void updateWatchInterface() {
        if (timerRunning) {
            timeInput.setEnabled(false);
            startButton.setText("Пауза");
        } else {
            timeInput.setEnabled(true);
            startButton.setText("Старт");
        }
    }

    private void playAlarmSound() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    private void incrementCounter() {
        counter++;
        updateCounterText();
    }

    private void resetCounter() {
        counter = 0;
        updateCounterText();
    }

    private void updateCounterText() {
        counterTextView.setText(String.valueOf(counter));
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

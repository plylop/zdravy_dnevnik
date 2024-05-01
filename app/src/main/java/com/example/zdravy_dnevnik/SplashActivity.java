package com.example.zdravy_dnevnik;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_TIME_OUT = 2000; // Время задержки в миллисекундах

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Используйте Handler для задержки перехода к основной активити
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Создайте Intent для перехода к основной активити
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Закройте текущую активити, чтобы пользователь не мог вернуться назад
            }
        }, SPLASH_TIME_OUT);
    }
}

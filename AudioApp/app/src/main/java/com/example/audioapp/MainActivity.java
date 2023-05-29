package com.example.audioapp;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
    private Button playButton;
    private Button pauseButton;
    private Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.sound); // Замените "song" на имя вашего аудиофайла в папке res/raw

        playButton = findViewById(R.id.play_button);
        pauseButton = findViewById(R.id.pause_button);
        stopButton = findViewById(R.id.stop_button);

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (R.id.play_button == v.getId()) {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        } else if (R.id.pause_button == v.getId()) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        } else if (R.id.stop_button == v.getId()) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(this, R.raw.sound); // Создаем новый объект MediaPlayer для повторного проигрывания
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Освобождаем ресурсы MediaPlayer при закрытии приложения
        }
    }
}
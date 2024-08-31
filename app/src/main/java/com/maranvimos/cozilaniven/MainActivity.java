package com.maranvimos.cozilaniven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;

import com.maranvimos.cozilaniven.databinding.ActivityMainBinding;
import com.maranvimos.cozilaniven.databinding.ActivityPolicyBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean active = true;
    int id = 0;
    int[] logos = {R.drawable.name1, R.drawable.name2, R.drawable.name3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        windowSettings();
        audioSettings();
        checkOpenActivities();
    }

    public void audioSettings() {
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
    }

    public void windowSettings() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                binding.logo.setImageResource(logos[id++ % 3]);
                if (active) {
                    new Handler().postDelayed(this, 500);
                }
            }
        });
    }

    public void checkOpenActivities() {
        if (GameActivity.active) {
            Intent intent = new Intent(this, GameActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
            finish();
            return;
        }
        if (SettingsActivity.active) {
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
            finish();
            return;
        }
        if (PolicyActivity.active) {
            Intent intent = new Intent(this, PolicyActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
            finish();
            return;
        }
    }

    public void settings(View v) {
        Settings.action(MainActivity.this);
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void play(View v) {
        Settings.action(MainActivity.this);
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void policy(View v) {
        Settings.action(MainActivity.this);
        Intent intent = new Intent(this, PolicyActivity.class);
        startActivity(intent);
    }

    public void close(View v) {
        Settings.action(MainActivity.this);
        finishAffinity();
    }

    @Override public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        active = false;
    }


}
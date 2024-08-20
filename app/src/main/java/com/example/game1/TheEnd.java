package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class TheEnd extends AppCompatActivity {
    MediaPlayer menu, click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_end);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        //Linkings
        Button next = (Button) findViewById(R.id.Next1);
        next.setOnClickListener(v -> openStartActivityGreeceStageFive());

        menu = MediaPlayer.create(TheEnd.this, R.raw.sceneone);
        menu.setLooping(true);
        menu.start();
        //open animation
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        //fullscreen display
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        //typewriter
        TypeWriter txtView = findViewById(R.id.typeCharacters);
        txtView.setText("");
        txtView.setCharacterDelay(250);
        txtView.animateText("The End.");
    }

    protected void openStartActivityGreeceStageFive() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        click = MediaPlayer.create(TheEnd.this, R.raw.press);
        click.start();
    }
    protected void onPause(){
        super.onPause();
        menu.release();
        finish();
    }
}
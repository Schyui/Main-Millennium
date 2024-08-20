package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ChapterTwo extends AppCompatActivity {
    MediaPlayer menu, click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two);
        //open animation
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        //Linkings
        Button next = (Button) findViewById(R.id.Next1);
        next.setOnClickListener(v -> openStartActivityStageTwo());

        menu = MediaPlayer.create(ChapterTwo.this, R.raw.sceneone);
        menu.setLooping(true);
        menu.start();

        //fullscreen display
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        //typewriter

        TypeWriter txtView2 = findViewById(R.id.ChapterOneStory);
        txtView2.setText("");
        txtView2.setCharacterDelay(50);
        txtView2.animateText("CHAPTER 2");
    }

    protected void openStartActivityStageTwo() {
        Intent intent = new Intent(this, StartActivityItalyStageTwo.class);
        startActivity(intent);
        click = MediaPlayer.create(ChapterTwo.this, R.raw.press);
        click.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        menu.release();
        finish();
    }
}
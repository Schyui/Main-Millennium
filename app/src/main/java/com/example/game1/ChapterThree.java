package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ChapterThree extends AppCompatActivity {
    MediaPlayer menu, click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_three);

        //open animation
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        //Linkings
        Button next = (Button) findViewById(R.id.Next1);
        next.setOnClickListener(v -> openStartActivityChinaStageThree());

        menu = MediaPlayer.create(ChapterThree.this, R.raw.sceneone);
        menu.setLooping(true);
        menu.start();

        //fullscreen display
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        //typewriter
        TypeWriter txtView2 = findViewById(R.id.ChapterOneStory);
        txtView2.setText("");
        txtView2.setCharacterDelay(50);
        txtView2.animateText("CHAPTER 3");
    }

    protected void openStartActivityChinaStageThree() {
        Intent intent = new Intent(this, StartActivityChinaStageThree.class);
        startActivity(intent);
        click = MediaPlayer.create(ChapterThree.this, R.raw.press);
        click.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        menu.release();
        finish();
    }
}
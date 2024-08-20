package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class TutorialPageTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_page_two);
        //Screen
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button Next1 = (Button) findViewById(R.id.Next1);
        Next1.setOnClickListener(v -> openTutorialPageThree());
        Button Previous = (Button) findViewById(R.id.Previous1);
        Previous.setOnClickListener(v -> openPrevious());
    }

    public void openTutorialPageThree() {
        Intent intent = new Intent(this, TutorialPageThree.class);
        startActivity(intent);

    }
    public void openPrevious() {
        Intent intent = new Intent(this, TutorialPageOne.class);
        startActivity(intent);
    }
}
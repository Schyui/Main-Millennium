package com.example.game1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Dialog myDialog;

    MediaPlayer menu, click;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        myDialog = new  Dialog(this);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        myDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // Music
        menu = MediaPlayer.create(MainActivity.this, R.raw.menu);
        menu.setLooping(true);
        menu.start();


        Button start = (Button) findViewById(R.id.startbtn);
        Button practice = (Button) findViewById(R.id.practicebtn);
        Button settings = (Button) findViewById(R.id.settingsbtn);
        ImageButton exit = (ImageButton) findViewById(R.id.exit);

        start.setOnClickListener(v -> openActivityStart());
        practice.setOnClickListener(v -> openActivityStages1());


    }


    // Linkings
    public void openActivityStages1() {
        Intent intent = new Intent(this, ActivityStages1.class);
        startActivity(intent);
        click = MediaPlayer.create(MainActivity.this, R.raw.press);
        click.start();
    }


    public void openActivityStart() {
        Intent intent = new Intent(this, ActivityBeginning.class);
        startActivity(intent);
        click = MediaPlayer.create(MainActivity.this, R.raw.startsound);
        click.start();
    }



    @Override
    protected void onPause(){
        super.onPause();
        menu.release();
        finish();
    }

    protected void RemoveTask (View view){
        finishAndRemoveTask();
    }

    public void show_Dialog(View v){

        TextView close_btn;

        myDialog.setContentView(R.layout.custom_popup);
        close_btn = (TextView) myDialog.findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = MediaPlayer.create(MainActivity.this, R.raw.press);
                click.start();
                myDialog.dismiss();

            }
        });
        myDialog.show();
        click = MediaPlayer.create(MainActivity.this, R.raw.press);
        click.start();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        this.getWindow().getDecorView().setSystemUiVisibility(uiOptions);
        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }

}


package com.example.game1;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ActivityPractice extends AppCompatActivity {
    MediaPlayer lunatic;
    ImageView imageView, imageView2, imageView3, imageView4, idlemcanim, idleitalyanim;
    Button enote, fnote, gnote, anote;
    AnimationDrawable animateidle;

    ImageButton Pausebtn;

    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        myDialog = new  Dialog(this);
        myDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // music
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        lunatic = MediaPlayer.create(ActivityPractice.this, R.raw.tutorialmusic);
        lunatic.setLooping(true);
        lunatic.start();

        //Linkings
        Button Finishbtn = (Button) findViewById(R.id.finish);
        ImageButton Pausebtn = (ImageButton)findViewById(R.id.pause);
        Finishbtn.setOnClickListener(v -> openActivityStages1());

        //animation idle
        idlemcanim = (ImageView) findViewById(R.id.idleImageView);
        idlemcanim.setBackgroundResource(R.drawable.idlemc);
        animateidle = (AnimationDrawable) idlemcanim.getBackground();
        animateidle.start();



        //Pattern1
        imageView = findViewById(R.id.Ebilog);
        enote = findViewById(R.id.enote);
        imageView2 = findViewById(R.id.Fbilog);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3 = findViewById(R.id.Gbilog);
        imageView3.setVisibility(View.INVISIBLE);
        imageView4 = findViewById(R.id.Abilog);
        imageView4.setVisibility(View.INVISIBLE);
        fnote = findViewById(R.id.fnote);
        gnote = findViewById(R.id.gnote);
        anote = findViewById(R.id.anote);
        gnote.setEnabled(false);
        anote.setEnabled(false);
        fnote.setEnabled(false);

        enote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id =v.getId();

                imageView.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.VISIBLE);
                enote.setEnabled(true);
                fnote.setEnabled(true);
                gnote.setEnabled(true);
                anote.setEnabled(true);

            }

        });



        imageView2 = findViewById(R.id.Fbilog);
        fnote = findViewById(R.id.fnote);

        fnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView2.setVisibility(View.INVISIBLE);
                imageView3.setVisibility(View.VISIBLE);
                enote.setEnabled(false);
                fnote.setEnabled(false);
                gnote.setEnabled(true);
                anote.setEnabled(false);

            }
        });

        imageView3 = findViewById(R.id.Gbilog);
        gnote = findViewById(R.id.gnote);


        gnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView3.setVisibility(View.INVISIBLE);
                imageView4.setVisibility(View.VISIBLE);
                enote.setEnabled(false);
                fnote.setEnabled(false);
                gnote.setEnabled(false);
                anote.setEnabled(true);
            }
        });


        imageView4 = findViewById(R.id.Abilog);
        anote = findViewById(R.id.anote);


        anote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView4.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.VISIBLE);
                enote.setEnabled(true);
                fnote.setEnabled(false);
                gnote.setEnabled(false);
                anote.setEnabled(false);

            }
        });

    }

    protected void onPause () {
        super.onPause();
        lunatic.release();
        finish();
    }
    public void openActivityStages1() {
        Intent intent = new Intent(this, ActivityStages1.class);
        startActivity(intent);
    }



    public void OnClickpause(View v){
        TextView close_btn;

        myDialog.setContentView(R.layout.custom_popup);
        close_btn = (TextView) myDialog.findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }


}
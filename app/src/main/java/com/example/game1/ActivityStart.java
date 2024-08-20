package com.example.game1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class ActivityStart extends AppCompatActivity {
    MediaPlayer lunatic;
    ImageView imageView, imageView2, imageView3, imageView4;
    Button enote, fnote, gnote, anote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        lunatic = MediaPlayer.create(ActivityStart.this, R.raw.lunatic);
        lunatic.setLooping(true);
        lunatic.start();


        {
            imageView = findViewById(R.id.yup);
            enote = findViewById(R.id.enote);

            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
            imageView.setAnimation(animation);

            enote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                    imageView.startAnimation(animation1);
                }
            });

            imageView2 = findViewById(R.id.yupp);
            fnote = findViewById(R.id.fnote);

            Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
            imageView2.setAnimation(animation2);

            fnote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                    imageView2.startAnimation(animation3);
                }
            });
            imageView3 = findViewById(R.id.yuppp);
            gnote = findViewById(R.id.gnote);

            Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
            imageView3.setAnimation(animation4);

            gnote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                    imageView3.startAnimation(animation5);
                }
            });


            imageView4 = findViewById(R.id.yupppp);
            anote = findViewById(R.id.anote);

            Animation animation6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
            imageView4.setAnimation(animation6);

            anote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation7 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                    imageView4.startAnimation(animation7);
                }
            });
        }
    }

    protected void onPause () {
        super.onPause();
        lunatic.release();
        finish();
    }

    public void previous (View view){
        startActivity(new Intent(ActivityStart.this, MainActivity.class));
    }



}
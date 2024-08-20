package com.example.game1;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivityChinaStageThree extends AppCompatActivity {
    Timer timer;
    MediaPlayer lunatic, click, click2, menu, mediaPlayer;
    ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, idlemcanim, idlejapananim, atkanim, atkjapananim, deadboss, slash;

    AnimationDrawable animateidle, animateidle2, animateatk, animateatk2, animatedead, animateslash;
    Button enote, fnote, gnote, anote, bnote, cnote, dnote;

    ImageButton Pausebtn;

    TextView tv_time, tv_clicks, scoreview, fightview;

    CountDownTimer timercount;
    int time = 114;
    int clicks = 0;

    Dialog myDialog;

    AlphaAnimation alphaAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity_china_stage_three);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        //Popup
        myDialog = new Dialog(this);
        myDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        //Restart button
        ImageView restartsize = findViewById(R.id.restart);
        restartsize.getLayoutParams().width = 130;
        restartsize.getLayoutParams().height = 130;

        //Screen
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //music before battle
        menu = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.intense);
        menu.setLooping(true);
        menu.start();

        //Linkings
        Button Finishbtn = (Button) findViewById(R.id.finish);
        ImageButton Pausebtn = (ImageButton) findViewById(R.id.pause);
        Finishbtn.setOnClickListener(v -> openChapterFour());
        ImageButton Restartbtn = (ImageButton) findViewById(R.id.restart);
        Restartbtn.setOnClickListener(v -> openStartActivityChinaStageThree());

        Button next = (Button) findViewById(R.id.Next1);
        next.setOnClickListener(v -> openStartActivityGreeceStageFive());


        //animation idle
        idlemcanim = (ImageView) findViewById(R.id.idleImageView);
        idlemcanim.setBackgroundResource(R.drawable.idlemc);
        animateidle = (AnimationDrawable) idlemcanim.getBackground();
        animateidle.start();

        idlejapananim = (ImageView) findViewById(R.id.JapanBossImageView);
        idlejapananim.setBackgroundResource(R.drawable.idlejapanboss);
        animateidle2 = (AnimationDrawable) idlejapananim.getBackground();
        animateidle2.start();

        atkanim = (ImageView) findViewById(R.id.attackImageView);
        atkanim.setBackgroundResource(R.drawable.testatkmc);
        animateatk = (AnimationDrawable) atkanim.getBackground();
        animateatk.start();

        atkjapananim = (ImageView) findViewById(R.id.JapanBossAtk);
        atkjapananim.setBackgroundResource(R.drawable.idlejapanboss);
        animateatk2 = (AnimationDrawable) atkjapananim.getBackground();
        animateatk2.start();

        deadboss = (ImageView) findViewById(R.id.JapanBossDead);
        deadboss.setBackgroundResource(R.drawable.dead);
        animatedead = (AnimationDrawable) deadboss.getBackground();
        animatedead.start();

        slash = (ImageView) findViewById(R.id.slash);
        slash.setBackgroundResource(R.drawable.slasheffect);
        animateslash = (AnimationDrawable) slash.getBackground();
        animateslash.start();

        ImageView idleBoss = findViewById(R.id.JapanBossImageView);
        ImageView attackMc = findViewById(R.id.attackImageView);
        ImageView idleMc = findViewById(R.id.idleImageView);
        ImageView attackBoss = findViewById(R.id.JapanBossAtk);
        ImageView deadBoss = findViewById(R.id.JapanBossDead);

        TextView scoreview = findViewById(R.id.scoreview);
        TextView fightview = findViewById(R.id.fightview);

        //scoring id
        tv_time = (TextView) findViewById(R.id.timer);
        tv_clicks = (TextView) findViewById(R.id.clickview);
        Button b_start = (Button) findViewById(R.id.startbtn);

        //timer
        timercount = new CountDownTimer(114000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time--;
                tv_time.setText("Time: "+ time);
            }

            @Override
            public void onFinish() {
                b_start.setEnabled(true);
                enote.setEnabled(false);
                fnote.setEnabled(false);
                gnote.setEnabled(false);
                anote.setEnabled(false);
                bnote.setEnabled(false);
                cnote.setEnabled(false);
                dnote.setEnabled(false);
                deadBoss.setVisibility(View.VISIBLE);
                attackMc.setVisibility(View.INVISIBLE);
                attackBoss.setVisibility(View.INVISIBLE);
                idleBoss.setVisibility(View.VISIBLE);
                idleMc.setVisibility(View.VISIBLE);
                slash.setVisibility(View.INVISIBLE);
                fightview.setVisibility(View.INVISIBLE);
                scoreview.setText("Score: " + clicks);
                scoreview.setVisibility(View.VISIBLE);

            }
        };
        b_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                timercount.start();
                b_start.setEnabled(false);

                clicks = 0;
                time = 114;
                lunatic = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.chinaboss);
                lunatic.setLooping(false);
                lunatic.start();
                b_start.setVisibility(View.INVISIBLE);

                enote.setEnabled(false);
                fnote.setEnabled(false);
                gnote.setEnabled(false);
                anote.setEnabled(false);
                bnote.setEnabled(false);
                cnote.setEnabled(false);
                dnote.setEnabled(true);

                slash.setVisibility(View.INVISIBLE);
                imageView = findViewById(R.id.Ebilog);
                imageView.setVisibility(View.INVISIBLE);
                imageView2 = findViewById(R.id.Fbilog);
                imageView2.setVisibility(View.INVISIBLE);
                imageView3 = findViewById(R.id.Gbilog);
                imageView3.setVisibility(View.INVISIBLE);
                imageView4 = findViewById(R.id.Abilog);
                imageView4.setVisibility(View.INVISIBLE);
                imageView5 = findViewById(R.id.Bbilog);
                imageView5.setVisibility(View.INVISIBLE);
                imageView6 = findViewById(R.id.Cbilog);
                imageView6.setVisibility(View.INVISIBLE);
                imageView7 = findViewById(R.id.Dbilog);
                imageView7.setVisibility(View.VISIBLE);
                scoreview.setVisibility(View.INVISIBLE);
                click = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.battlestartsound);
                click.start();
                fightview.setVisibility(View.VISIBLE);


                menu.stop();

                fightview.postDelayed(new Runnable() {
                    public void run() {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                        alphaAnimation.setDuration(400);
                        fightview.startAnimation(alphaAnimation);
                        fightview.setVisibility(View.INVISIBLE);
                    }
                }, 1000);




            }
        });



        //Pattern1
        imageView = findViewById(R.id.Ebilog);
        imageView.setVisibility(View.INVISIBLE);
        imageView2 = findViewById(R.id.Fbilog);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3 = findViewById(R.id.Gbilog);
        imageView3.setVisibility(View.INVISIBLE);
        imageView4 = findViewById(R.id.Abilog);
        imageView4.setVisibility(View.INVISIBLE);
        imageView5 = findViewById(R.id.Bbilog);
        imageView5.setVisibility(View.INVISIBLE);
        imageView6 = findViewById(R.id.Cbilog);
        imageView6.setVisibility(View.INVISIBLE);
        imageView7 = findViewById(R.id.Dbilog);
        imageView7.setVisibility(View.INVISIBLE);
        scoreview.setVisibility(View.INVISIBLE);
        fightview.setVisibility(View.INVISIBLE);
        slash.setVisibility(View.INVISIBLE);
        attackMc.setVisibility(View.INVISIBLE);
        attackBoss.setVisibility(View.INVISIBLE);
        idleBoss.setVisibility(View.VISIBLE);
        deadBoss.setVisibility(View.INVISIBLE);

        enote = findViewById(R.id.enote);
        fnote = findViewById(R.id.fnote);
        gnote = findViewById(R.id.gnote);
        anote = findViewById(R.id.anote);
        bnote = findViewById(R.id.bnote);
        cnote = findViewById(R.id.cnote);
        dnote = findViewById(R.id.dnote);


        enote.setEnabled(false);
        fnote.setEnabled(false);
        gnote.setEnabled(false);
        anote.setEnabled(false);
        bnote.setEnabled(false);
        cnote.setEnabled(false);
        dnote.setEnabled(false);

        dnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idleMc.setVisibility(View.VISIBLE);
                idleBoss.setVisibility(View.VISIBLE);
                attackMc.setVisibility(View.INVISIBLE);
                attackBoss.setVisibility(View.INVISIBLE);
                imageView7.setVisibility(View.INVISIBLE);
                imageView4.setVisibility(View.VISIBLE);
                slash.setVisibility(View.INVISIBLE);
                enote.setEnabled(false);
                fnote.setEnabled(false);
                gnote.setEnabled(false);
                anote.setEnabled(true);
                bnote.setEnabled(false);
                cnote.setEnabled(false);
                dnote.setEnabled(false);


                mediaPlayer = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.correctsound);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.reset();
                        mp.release();
                        mediaPlayer = null;
                    }
                });
                mediaPlayer.start();
                clicks+=15;
                tv_clicks.setText("Score: "+ clicks);

            }

        });



        anote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackMc.setVisibility(View.INVISIBLE);
                idleBoss.setVisibility(View.VISIBLE);
                imageView4.setVisibility(View.INVISIBLE);
                imageView6.setVisibility(View.VISIBLE);
                attackBoss.setVisibility(View.INVISIBLE);
                slash.setVisibility(View.INVISIBLE);
                enote.setEnabled(false);
                fnote.setEnabled(false);
                gnote.setEnabled(false);
                anote.setEnabled(false);
                bnote.setEnabled(false);
                cnote.setEnabled(true);
                dnote.setEnabled(false);

                mediaPlayer = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.correctsound);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.reset();
                        mp.release();
                        mediaPlayer = null;
                    }
                });
                mediaPlayer.start();
                clicks+=15;
                tv_clicks.setText("Score: "+ clicks);
            }
        });



        cnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackMc.setVisibility(View.INVISIBLE);
                idleBoss.setVisibility(View.VISIBLE);
                imageView6.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.VISIBLE);
                attackBoss.setVisibility(View.INVISIBLE);
                slash.setVisibility(View.INVISIBLE);
                enote.setEnabled(true);
                fnote.setEnabled(false);
                gnote.setEnabled(false);
                anote.setEnabled(false);
                bnote.setEnabled(false);
                cnote.setEnabled(false);
                dnote.setEnabled(false);

                mediaPlayer = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.correctsound);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.reset();
                        mp.release();
                        mediaPlayer = null;
                    }
                });
                mediaPlayer.start();
                clicks+=15;
                tv_clicks.setText("Score: "+ clicks);
            }
        });




        enote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackMc.setVisibility(View.INVISIBLE);
                idleBoss.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                imageView5.setVisibility(View.VISIBLE);
                attackBoss.setVisibility(View.VISIBLE);
                slash.setVisibility(View.VISIBLE);
                enote.setEnabled(false);
                fnote.setEnabled(false);
                gnote.setEnabled(false);
                anote.setEnabled(false);
                bnote.setEnabled(true);
                cnote.setEnabled(false);
                dnote.setEnabled(false);

                click2 = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.slash);
                click2.start();

                mediaPlayer = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.correctsound);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.reset();
                        mp.release();
                        mediaPlayer = null;
                    }
                });
                mediaPlayer.start();
                clicks+=15;
                tv_clicks.setText("Score: "+ clicks);

                slash.postDelayed(new Runnable() {
                    public void run() {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                        alphaAnimation.setDuration(400);
                        slash.startAnimation(alphaAnimation);
                        slash.setVisibility(View.INVISIBLE);
                    }
                }, 350);
            }
        });



        bnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackMc.setVisibility(View.INVISIBLE);
                idleBoss.setVisibility(View.VISIBLE);
                imageView5.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.VISIBLE);
                attackBoss.setVisibility(View.INVISIBLE);
                slash.setVisibility(View.INVISIBLE);
                enote.setEnabled(false);
                fnote.setEnabled(true);
                gnote.setEnabled(false);
                anote.setEnabled(false);
                bnote.setEnabled(false);
                cnote.setEnabled(false);
                dnote.setEnabled(false);

                mediaPlayer = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.correctsound);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.reset();
                        mp.release();
                        mediaPlayer = null;
                    }
                });
                mediaPlayer.start();
                clicks+=15;
                tv_clicks.setText("Score: "+ clicks);
            }
        });



        fnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackMc.setVisibility(View.INVISIBLE);
                idleBoss.setVisibility(View.VISIBLE);
                imageView2.setVisibility(View.INVISIBLE);
                slash.setVisibility(View.INVISIBLE);
                imageView3.setVisibility(View.VISIBLE);
                enote.setEnabled(false);
                fnote.setEnabled(false);
                gnote.setEnabled(true);
                anote.setEnabled(false);
                bnote.setEnabled(false);
                cnote.setEnabled(false);
                dnote.setEnabled(true);

                mediaPlayer = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.correctsound);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.reset();
                        mp.release();
                        mediaPlayer = null;
                    }
                });
                mediaPlayer.start();
                clicks+=15;
                tv_clicks.setText("Score: "+ clicks);
            }
        });


        gnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idleMc.setVisibility(View.VISIBLE);
                idleBoss.setVisibility(View.VISIBLE);
                attackMc.setVisibility(View.VISIBLE);
                attackBoss.setVisibility(View.INVISIBLE);
                imageView3.setVisibility(View.INVISIBLE);
                imageView7.setVisibility(View.VISIBLE);
                slash.setVisibility(View.INVISIBLE);
                enote.setEnabled(false);
                fnote.setEnabled(false);
                gnote.setEnabled(false);
                anote.setEnabled(false);
                bnote.setEnabled(false);
                cnote.setEnabled(false);
                dnote.setEnabled(true);

                click = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.bulletlaser);
                click.setLooping(false);
                click.start();
                mediaPlayer = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.correctsound);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.reset();
                        mp.release();
                        mediaPlayer = null;
                    }
                });
                mediaPlayer.start();

                clicks+=30;
                tv_clicks.setText("Score: "+ clicks);

                attackMc.postDelayed(new Runnable() {
                    public void run() {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                        alphaAnimation.setDuration(400);
                        attackMc.startAnimation(alphaAnimation);
                        attackMc.setVisibility(View.INVISIBLE);
                    }
                }, 500);
            }
        });
    }



    //Music Stops after opening new activity

    protected void onPause() {
        super.onPause();
        lunatic.release();
        finish();
    }
    //Back-finish Button
    protected void openChapterFour() {
        Intent intent = new Intent(this, ChapterFour.class);
        startActivity(intent);
        click = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.press);
        click.start();
    }
    protected void openStartActivityChinaStageThree() {
        Intent intent = new Intent(this, StartActivityChinaStageThree.class);
        startActivity(intent);
        click = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.press);
        click.start();
    }

    //Popup Settings and Pause
    public void OnClickpause(View v) {
        TextView close_btn;

        myDialog.setContentView(R.layout.custom_popup);
        close_btn = (TextView) myDialog.findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                click = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.press);
                click.start();
            }
        });
        myDialog.show();
        click = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.press);
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
    public void openStartActivityGreeceStageFive() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        click = MediaPlayer.create(StartActivityChinaStageThree.this, R.raw.press);
        click.start();
    }
}



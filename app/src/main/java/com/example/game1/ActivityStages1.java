package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ActivityStages1 extends AppCompatActivity {

    Button StageBackbtn, StageOnebtn, StaveTutorialbtn;

    MediaPlayer menu, click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stages1);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


        Button StageBackbtn = (Button) findViewById(R.id.StageBackBtn);
        Button StageTutorialbtn = (Button) findViewById(R.id.tutorial1);
        Button StageOnebtn = (Button) findViewById(R.id.stage1);
        Button StageTwobtn = (Button) findViewById(R.id.stage2);
        Button StageThreebtn = (Button) findViewById(R.id.stage3);
        Button StageFourbtn = (Button) findViewById(R.id.stage4);
        Button StageFivebtn = (Button) findViewById(R.id.stage5);

        StageBackbtn.setOnClickListener(v -> openMainActivity());
        StageTutorialbtn.setOnClickListener(v -> openCheatSheet());
        StageOnebtn.setOnClickListener(v -> openActivityJapanStageOne());
        StageTwobtn.setOnClickListener(v -> openActivityItalyStageTwo());
        StageThreebtn.setOnClickListener(v -> openActivityChinaStageThree());
        StageFourbtn.setOnClickListener(v -> openActivityEgyptStageFour());
        StageFivebtn.setOnClickListener(v -> openActivityGreeceStageFive());



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        //Music
        menu = MediaPlayer.create(ActivityStages1.this, R.raw.menu);
        menu.setLooping(true);
        menu.start();

    }
        //Linkings
        public void openMainActivity() {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            click = MediaPlayer.create(ActivityStages1.this, R.raw.press);
            click.start();
        }
        public void openCheatSheet() {
            Intent intent = new Intent(this, CheatSheet.class);
            startActivity(intent);
            click = MediaPlayer.create(ActivityStages1.this, R.raw.press);
            click.start();
    }
        public void openActivityJapanStageOne() {
            Intent intent = new Intent(this, ActivityJapanStageOne.class);
            startActivity(intent);
            click = MediaPlayer.create(ActivityStages1.this, R.raw.press);
            click.start();
    }
        public void openActivityItalyStageTwo() {
            Intent intent = new Intent(this, ActivityItalyStageTwo.class);
            startActivity(intent);
            click = MediaPlayer.create(ActivityStages1.this, R.raw.press);
            click.start();
    }
    public void openActivityChinaStageThree() {
        Intent intent = new Intent(this, ActivityChinaStageThree.class);
        startActivity(intent);
        click = MediaPlayer.create(ActivityStages1.this, R.raw.press);
        click.start();
    }
    public void openActivityEgyptStageFour() {
        Intent intent = new Intent(this, ActivityEgyptStageFour.class);
        startActivity(intent);
        click = MediaPlayer.create(ActivityStages1.this, R.raw.press);
        click.start();
    }
    public void openActivityGreeceStageFive() {
        Intent intent = new Intent(this, ActivityGreeceStageFive.class);
        startActivity(intent);
        click = MediaPlayer.create(ActivityStages1.this, R.raw.press);
        click.start();
    }


    protected void onPause(){
        super.onPause();
        menu.release();
        finish();
    }
}
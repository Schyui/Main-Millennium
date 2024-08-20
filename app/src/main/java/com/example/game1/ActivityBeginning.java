package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class ActivityBeginning extends AppCompatActivity {

    MediaPlayer menu, click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginning);

        menu = MediaPlayer.create(ActivityBeginning.this, R.raw.sceneone);
        menu.setLooping(true);
        menu.start();

        //Linkings
        Button next = (Button) findViewById(R.id.Next1);
        next.setOnClickListener(v -> openStartActivityJapanStageOne());

        //open animation
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        //fullscreen display
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //typewriter

        TypeWriter txtView2 = findViewById(R.id.ChapterOneStory);
        txtView2.setText("");
        txtView2.setCharacterDelay(50);
        txtView2.animateText("CHAPTER 1");



        TypeWriter txtView = findViewById(R.id.typeCharacters);
        txtView.setText("");
        txtView.setCharacterDelay(20);
        txtView.animateText("\n                   It is in the era of Medieval Greece, where it is governed by elite groups of aristocrats. Somewhere in the Kingdom of Thessalonica, in the shadows of the underground of the castle, a goddess disguised as a human regent, is weakened and slumped by a great yet broken monster. Connected by their past, the unrecognizable friend of a monster betrays its friend, the goddess, by its cruel greediness, to regain what it has lost in order to truly find its only source of happiness. With the goddess so outraged, so disappointed, and so betrayed, she tried to talk it out to her old friend but failed. It is no longer the friend she knew, and it is too late to bring back the old good bond of a connection they had. So close to the taste of reclaiming its passion, the monster held the goddess so tight, so frightful, it thought that the goddess was fully wrapped around his finger, that it could finally have the power it always craved for. With remaining strength and magic in her pocket, the goddess managed to escape from its grasp and vanish into thin air.\n\n                   There is a boy, a lost one, who is trying to escape from its past, trying to start anew, in a place where the people are cold, harsh and empty. Under the modern city lights, the boy wonders if he could ever find peace within himself. With a few cash on his pockets, he made his way back to the place he is considering as his current shelter. With a heavy heart and a clouded mind, boxes sprawled around his dimmed room, containing the overwhelming memories of the past. Not wanting to remember, he copes his worries away by letting his mind drift to slumber.\n\n                    With the goddess trapped in her own magical space, her body falls from exhaustion at not knowing what to do. Out of nowhere, a vision appeared as she wished for someone, she knew to be there for her. She sees a chance, an escape, a familiar face, and a boy. The goddess has no idea how she came upon this guy, and it is strange to see his condition and appearance. Nevertheless, as the boy sleeps, she casts her spell and whispers in the boy's dream with all her last strength. This goes on for days, and the boy does not reply to her. He would refuse to acknowledge her presence, and when he awoke, he would have forgotten about an angel speaking to his dreams. Until one night, he spoke back. The goddess found a sense of light, a sense of being loosen off, a sense of liberation. She was acknowledged by someone who she now considers as a person who can help with her troubles, and she is fully dependent on him. She can finally set her foot on the ground once again, completely free. ");



    }

    public void openStartActivityJapanStageOne() {
        Intent intent = new Intent(this, StartActivityJapanStageOne.class);
        startActivity(intent);
        click = MediaPlayer.create(ActivityBeginning.this, R.raw.press);
        click.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        menu.release();
        finish();
    }
}
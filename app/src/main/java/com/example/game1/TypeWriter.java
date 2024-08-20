package com.example.game1;

import android.widget.TextView;
import android.util.AttributeSet;
import android.content.Context;

import androidx.annotation.Nullable;
import android.os.Handler;


public class TypeWriter extends androidx.appcompat.widget.AppCompatTextView{

    private CharSequence myText;
    private int myIndex;
    private long myDelay = 70;

    public TypeWriter(Context context){
        super(context);
    }
    public TypeWriter(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    private Handler myHandler = new Handler();

    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(myText.subSequence(0, myIndex++));
            if (myIndex <= myText.length()) {
                myHandler.postDelayed(characterAdder, myDelay);
            }
        }
    };

    public void animateText(CharSequence myTxt){
        myText = myTxt;
        myIndex = 0;

        setText("");

        myHandler.removeCallbacks(characterAdder);
        myHandler.postDelayed(characterAdder, myDelay);
    }
    public void setCharacterDelay(long m){
        myDelay = m;

    }
}


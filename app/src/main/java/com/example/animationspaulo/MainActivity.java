package com.example.animationspaulo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable batAnimation;    //As we are going to animate via drawable.
    private ImageView batImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batImage = findViewById(R.id.bat_id);
        batImage.setBackgroundResource(R.drawable.bat_anim);  // Even after removing the source of the imageView , we are able to see the initial image on the UI cuz of this line of code.

        batAnimation = (AnimationDrawable) batImage.getBackground();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {  //Ths will allow us to grab the event wherever the user types on screen
        batAnimation.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                batAnimation.stop();
            }
        } , 5000);

        return super.onTouchEvent(event);

    }
}
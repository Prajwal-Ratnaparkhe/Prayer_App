package com.msquare.prarthananjali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.window.SplashScreen;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {

    Animation anim;
    ImageView imageView;



    int value;


    private Timer timer;
    private ProgressBar progressBar;
    private int i=0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


//
//        imageView=(ImageView)findViewById(R.id.SplashScreenImage); // Declare an imageView to show the animation.
//        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.side_slide);
//
//
//
//
//getSupportActionBar().hide();
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(splash.this,MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },3000);
//    }
//}
//


        progressBar = findViewById(R.id.progressBarId);
        textView = findViewById(R.id.textViewId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (value = 0; value<=100; value++){
                    try {
                        Thread.sleep(30);
                        progressBar.setProgress(value);
                        setText(textView, String.valueOf(value)+"%" );

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

        int secondsDelayed = 3;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(splash.this,   Lanselect.class));
                finish();
            }
        }, secondsDelayed * 1000);

    }

    private void setText(final TextView text,final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }

}


package com.example.fishmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declaration of the status time for the splash screen.
     private  static  int Splash_Screen_Status_time = 5000;

   //hooks and their id.
     View image;
     TextView appName, developerTag;

    //animations declaration.
     Animation entranceAnimation, rightAnimation,bottomAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
         entranceAnimation = AnimationUtils.loadAnimation(this,R.anim.entrance_animation);
         rightAnimation=AnimationUtils.loadAnimation(this,R.anim.right_animation);
         bottomAnimation=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

// hooks assign their ids.
        image=findViewById(R.id.fish_image);
        appName=findViewById(R.id.text_fishmob);
        developerTag=findViewById(R.id.developer_tag);

        //asignation of animation to the element(hooks)
        appName.setAnimation(entranceAnimation);
        image.setAnimation(rightAnimation);
        developerTag.setAnimation(bottomAnimation);

        //splash screen to dashboard screen.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,dashboardActivity.class);
                startActivity(intent);
                finish();
            }
        },
                Splash_Screen_Status_time
        );


    }
}
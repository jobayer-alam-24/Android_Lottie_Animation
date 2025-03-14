package com.example.lottieanimation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView boatAnimation;
    AppCompatButton play, pause, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        boatAnimation = findViewById(R.id.boatAnimation);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent second = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(second);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!boatAnimation.isAnimating())
                {
                    boatAnimation.playAnimation();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Animation is already playing", Toast.LENGTH_SHORT).show();
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boatAnimation.isAnimating())
                {
                    boatAnimation.pauseAnimation();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Animation is already paused", Toast.LENGTH_SHORT).show();
                }
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
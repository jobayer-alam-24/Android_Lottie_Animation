package com.example.lottieanimation;

import android.annotation.SuppressLint;
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

public class FourthActivity extends AppCompatActivity {

    LottieAnimationView waterAnimation;
    AppCompatButton play, pause, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);

        waterAnimation = findViewById(R.id.waterAnimation);
        pause = findViewById(R.id.pause);
        play = findViewById(R.id.play);
        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fifth = new Intent(FourthActivity.this, FifthActivity.class);
                startActivity(fifth);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!waterAnimation.isAnimating())
                {
                    waterAnimation.playAnimation();
                }
                else
                {
                    Toast.makeText(FourthActivity.this, "Animation is already playing", Toast.LENGTH_LONG).show();
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(waterAnimation.isAnimating())
                {
                    waterAnimation.pauseAnimation();
                }
                else
                {
                    Toast.makeText(FourthActivity.this, "Animation is already paused", Toast.LENGTH_LONG).show();
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
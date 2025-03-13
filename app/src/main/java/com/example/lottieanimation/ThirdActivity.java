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

public class ThirdActivity extends AppCompatActivity {

    LottieAnimationView countToTenAnimation;
    AppCompatButton play, pause, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);

        countToTenAnimation = findViewById(R.id.countToTenAnimation);
        pause = findViewById(R.id.pause);
        play = findViewById(R.id.play);
        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fourth = new Intent(ThirdActivity.this, FourthActivity.class);
                startActivity(fourth);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!countToTenAnimation.isAnimating())
                {
                    countToTenAnimation.playAnimation();
                }
                else
                {
                    Toast.makeText(ThirdActivity.this, "Animation is already playing", Toast.LENGTH_LONG).show();
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countToTenAnimation.isAnimating())
                {
                    countToTenAnimation.pauseAnimation();
                }
                else
                {
                    Toast.makeText(ThirdActivity.this, "Animation is already paused", Toast.LENGTH_LONG).show();
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
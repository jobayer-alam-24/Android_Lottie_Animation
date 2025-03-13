package com.example.lottieanimation;

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

public class FifthActivity extends AppCompatActivity {

    AppCompatButton play, pause;
    LottieAnimationView deskAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fifth);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        deskAnimation = findViewById(R.id.deskAnimation);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!deskAnimation.isAnimating())
                {
                    deskAnimation.playAnimation();
                }
                else
                {
                    Toast.makeText(FifthActivity.this, "Animation is already playing", Toast.LENGTH_LONG).show();
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(deskAnimation.isAnimating())
                {
                    deskAnimation.pauseAnimation();
                }
                else
                {
                    Toast.makeText(FifthActivity.this, "Animation is already paused", Toast.LENGTH_LONG).show();
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
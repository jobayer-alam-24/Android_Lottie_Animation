Lottie Animation in Android

Introduction

This project demonstrates how to integrate and control Lottie animations in an Android app using Gradle Version Catalog (TOML) for dependency management. It covers adding the dependency, setting up XML layouts, and controlling animations using Java.

1️⃣ Adding Lottie Dependency

Step 1: Open gradle/libs.versions.toml

Add the Lottie library under the [versions] section:

[versions]
lottie = "6.0.0"

Step 2: Define the Dependency

Under [libraries], add:

[libraries]
lottie = { module = "com.airbnb.android:lottie", version.ref = "lottie" }

Step 3: Use the Dependency in build.gradle.kts (Module: app)

dependencies {
    implementation(libs.lottie)
}

2️⃣ Playing, Pausing, and Stopping Animations

Step 1: Modify activity_main.xml

Add buttons for Play, Pause, and Stop controls:

<Button
    android:id="@+id/playButton"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Play Animation"
    android:layout_marginTop="20dp"/>

<Button
    android:id="@+id/pauseButton"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Pause Animation"
    android:layout_marginTop="20dp"/>

<Button
    android:id="@+id/stopButton"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Stop Animation"
    android:layout_marginTop="20dp"/>

Step 2: Control Animation in MainActivity.java

Add click listeners to play, pause, and stop the animation:

package com.example.lottiedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.airbnb.lottie.LottieAnimationView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LottieAnimationView lottieAnimationView;
    private Button playButton, pauseButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieAnimationView = findViewById(R.id.lottieAnimationView);
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.stopButton);

        // Play Animation
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.playAnimation();
            }
        });

        // Pause Animation
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.pauseAnimation();
            }
        });

        // Stop Animation (Reset to Start)
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.cancelAnimation();
                lottieAnimationView.setProgress(0); // Reset animation
            }
        });
    }
}

🎉 Conclusion

You have successfully:

Added Lottie dependency using Version Catalog (TOML)

Set up UI buttons for animation control

Implemented play, pause, and stop features in Java

✅ Next Steps:

Add animation speed control

Implement event listeners

Load animations dynamically

🚀 Happy coding! 🎨

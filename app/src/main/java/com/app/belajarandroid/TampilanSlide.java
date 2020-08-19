package com.app.belajarandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class TampilanSlide extends AppCompatActivity {
    ViewFlipper viewFlipper;
    Animation fadein, fadeout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_slide);

        viewFlipper = (ViewFlipper) findViewById(R.id.vieFlipper);

        fadein = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        fadein = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();
    }
}

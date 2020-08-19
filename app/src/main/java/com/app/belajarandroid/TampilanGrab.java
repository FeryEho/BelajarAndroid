package com.app.belajarandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class TampilanGrab extends AppCompatActivity {
    ImageView greetImg;
    TextView greetText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_grab);

        greetImg = findViewById(R.id.greeting_img);
        greetText = findViewById(R.id.greeting_text);

        greeting();

    }
    @SuppressLint("SetTextI18n")
    private void greeting() {
        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12){
            greetText.setText("Selamat Pagi\nADMINISTRATOR");
            greetImg.setImageResource(R.drawable.logo_kotak);
        } else if (timeOfDay >= 12 && timeOfDay < 15) {
            greetText.setText("Selamat Siang\nADMINISTRATOR");
            greetImg.setImageResource(R.drawable.logo_kotak);
        } else if (timeOfDay >= 15 && timeOfDay < 18) {
            greetText.setText("Selamat Sore\nADMINISTRATOR");
            greetImg.setImageResource(R.drawable.logo_kotak);
        } else if (timeOfDay >= 18 && timeOfDay < 24) {
            greetText.setText("Selamat Malam\nADMINISTRATOR");
            greetText.setTextColor(Color.WHITE);
            greetImg.setImageResource(R.drawable.logo_kotak);
        }
    }
}

package com.app.belajarandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGrab = findViewById(R.id.btn_tampilan_grab);
        btnGrab.setOnClickListener(this);

        Button btnslide = findViewById(R.id.btn_slide);
        btnslide.setOnClickListener(this);

        Button btnratingbar = findViewById(R.id.btn_ratingbar);
        btnratingbar.setOnClickListener(this);

        Button btnuploadgambar = findViewById(R.id.btn_uploadgambar);
        btnuploadgambar.setOnClickListener(this);

        Button btninsertgambar = findViewById(R.id.btn_insertgambar);
        btninsertgambar.setOnClickListener(this);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveWithDataActivity = findViewById(R.id.btn_move_activity_data);
        btnMoveWithDataActivity.setOnClickListener(this);

        Button btnMoveWithObject = findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);

        Button btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);

        Button btnMoveForResult = findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tampilan_grab:
                Intent i = new Intent(MainActivity.this, TampilanGrab.class);
                startActivity(i);
                break;
            case R.id.btn_ratingbar:
                Intent c = new Intent(MainActivity.this, RatingBar.class);
                startActivity(c);
                break;
            case R.id.btn_slide:
                Intent s = new Intent(MainActivity.this, TampilanSlide.class);
                startActivity(s);
                break;
            case R.id.btn_uploadgambar:
                Intent b = new Intent(MainActivity.this, UploadGambar.class);
                startActivity(b);
                break;
            case R.id.btn_insertgambar:
                Intent e = new Intent(MainActivity.this, InsertDataGambar.class);
                startActivity(e);
                break;
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Fery Febrianto");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 22);
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_move_activity_object:
                Person person = new Person();
                person.setName("DicodingAcademy");
                person.setAge(5);
                person.setEmail("academy@dicoding.com");
                person.setCity("Bandung");
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
                startActivity(moveWithObjectIntent);
                break;
            case R.id.btn_dial_number:
                String phoneNumber = "081210841382";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}

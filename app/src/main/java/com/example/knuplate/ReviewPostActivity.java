package com.example.knuplate;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.InputStream;

public class ReviewPostActivity extends AppCompatActivity {

    final int GET_IMAGE_GALLERY = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_post);


        ImageView review_picadd_but = findViewById(R.id.review_picadd_but);

        Spinner menu_spinner = findViewById(R.id.menu_spinner);
        Button menu_add_but = findViewById(R.id.menu_add_but);
        EditText review_et = findViewById(R.id.review_et);




        review_picadd_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, GET_IMAGE_GALLERY);
            }
        });

        menu_add_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override //갤러리에서 이미지 불러온 후 행동
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        ImageView review_picadd_but = findViewById(R.id.review_picadd_but);

        // Check which request we're responding to
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_IMAGE_GALLERY) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지뷰에 세팅
                    review_picadd_but.setImageBitmap(img);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
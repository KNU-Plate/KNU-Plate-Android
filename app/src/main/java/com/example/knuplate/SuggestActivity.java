package com.example.knuplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

public class SuggestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);

        EditText tv_suggest = findViewById(R.id.tv_suggest);
        Button bt_suggest = findViewById(R.id.bt_suggest);
    }
}
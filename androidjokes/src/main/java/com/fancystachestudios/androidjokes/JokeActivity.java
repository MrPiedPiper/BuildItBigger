package com.fancystachestudios.androidjokes;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Intent intent = getIntent();

        if(intent != null){
            TextView jokeTextView = (TextView) findViewById(R.id.joke_text);
            jokeTextView.setText(intent.getStringExtra(getString(R.string.jokeId)));
        }
    }
}

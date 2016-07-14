package com.example.abirshukla.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GoodGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_game);
        Bundle info = getIntent().getExtras();
        String userWord = "";
        userWord = info.getString("word");
        TextView word = (TextView) findViewById(R.id.word);
        word.setText(userWord);
    }
    public void menu(View view) {

        Intent i = new Intent(this,MainActivity.class);

        startActivity(i);
    }
}

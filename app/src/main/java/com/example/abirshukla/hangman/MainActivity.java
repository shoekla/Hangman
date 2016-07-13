package com.example.abirshukla.hangman;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        WordInfo.letters.add("e");
        WordInfo.letters.add("t");
        WordInfo.letters.add("a");
        WordInfo.letters.add("o");
        WordInfo.letters.add("i");
        WordInfo.letters.add("n");
        WordInfo.letters.add("s");
        WordInfo.letters.add("h");
        WordInfo.letters.add("r");
        WordInfo.letters.add("d");
        WordInfo.letters.add("l");
        WordInfo.letters.add("c");
        WordInfo.letters.add("u");
        WordInfo.letters.add("m");
        WordInfo.letters.add("w");
        WordInfo.letters.add("f");
        WordInfo.letters.add("g");
        WordInfo.letters.add("y");
        WordInfo.letters.add("p");
        WordInfo.letters.add("b");
        WordInfo.letters.add("v");
        WordInfo.letters.add("k");
        WordInfo.letters.add("j");
        WordInfo.letters.add("x");
        WordInfo.letters.add("q");
        WordInfo.letters.add("z");
    }

    public void IGuess(View view) {

        Intent i = new Intent(this,MyGuessGame.class);


        startActivity(i);
    }

}

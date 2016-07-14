package com.example.abirshukla.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class youGuess extends AppCompatActivity {
    TextView myGuess;
    TextView incorrect;
    TextView currentWord;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_guess);
        Bundle info = getIntent().getExtras();
        String userWord = "";

        myGuess = (TextView) findViewById(R.id.textView3);
        incorrect = (TextView) findViewById(R.id.textView5);
        currentWord = (TextView) findViewById(R.id.textView7);
        editText = (EditText) findViewById(R.id.editText);
        if (info != null)
            userWord = info.getString("name");

    }
}

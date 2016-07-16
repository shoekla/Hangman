package com.example.abirshukla.hangman;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class youGuess extends AppCompatActivity {

    TextView incorrect;
    TextView currentWord;
    EditText editText;
    String userWord;
    String show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_guess);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Bundle info = getIntent().getExtras();
        userWord = "";
        show = "";
        incorrect = (TextView) findViewById(R.id.textView5);
        currentWord = (TextView) findViewById(R.id.textView7);
        editText = (EditText) findViewById(R.id.editText);
        if (info != null) {
            userWord = info.getString("name").toLowerCase();
            show = info.getString("show").toLowerCase();
        }
        incorrect.setText(WordInfo.incorrectWords.toString());
        currentWord.setText(show);
    }
    public void update(View view) {
        String userW = editText.getText().toString().toLowerCase();
        if (userW.length() == 0) {
            Toast.makeText(getApplicationContext(), "Please Enter a letter", Toast.LENGTH_LONG).show();
            return;
        }
        char c = userW.charAt(0);
        if (WordInfo.incorrectWords.contains(Character.toString(c)) || show.contains(Character.toString(c))) {
            Toast.makeText(getApplicationContext(), "You already submitted this letter", Toast.LENGTH_LONG).show();
            return;
        }
        String updatedShow = "";
        for (int k = 0; k < userWord.length();k++) {
            if (userWord.charAt(k) == c) {
                updatedShow = updatedShow + c;
            }
            else {
                if (show.charAt(k) != '#') {
                    updatedShow = updatedShow + show.charAt(k);
                }
                else {
                    updatedShow = updatedShow + "#";
                }
            }
        }
        if (updatedShow.toLowerCase().equals(show.toLowerCase())) {

                WordInfo.incorrectWords.add(Character.toString(c));
        }
        if (updatedShow.contains("#")) {
            Intent i = new Intent(this,youGuess.class);
            i.putExtra("name", userWord);
            i.putExtra("show", updatedShow);
            startActivity(i);
        }
        else {
            Intent i = new Intent(this,GoodGame.class);
              WordInfo.incorrectWords.clear();
            i.putExtra("word",userWord);
            startActivity(i);

        }

    }
}

package com.example.abirshukla.hangman;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MyGuessGame extends AppCompatActivity {
    TextView myGuess;
    TextView incorrect;
    TextView currentWord;
    EditText editText;
    String userWord;
    String currentGuess = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_my_guess_game);
        Bundle info = getIntent().getExtras();
        userWord = "";

        myGuess = (TextView) findViewById(R.id.textView3);
        incorrect = (TextView) findViewById(R.id.textView5);
        currentWord = (TextView) findViewById(R.id.textView7);
        editText = (EditText) findViewById(R.id.editText);
        incorrect.setText(WordInfo.incorrectWords.toString());
        myGuess.setText("Making Guess ...");
        if (info != null)
            userWord = info.getString("name");

        if (userWord.length() > 1) {
            if (!userWord.contains("#")) {
                Intent f = new Intent(MyGuessGame.this, GoodGame.class);
                f.putExtra("word",userWord);
                startActivity(f);
            }
            editText.setText(userWord);
            System.out.println("Url length ");
            currentWord.setText(userWord);
        } else {
            currentWord.setText("No Word Detected");
        }
        if (WordInfo.wordGuesses.isEmpty()) {
            if (WordInfo.letters.size() > 20) {
                currentGuess = WordInfo.letters.get(0);
                myGuess.setText(currentGuess);
                WordInfo.letters.remove(0);
                System.out.println("Url letter size ");
            } else {
                WordInfo.correctLetters.clear();
                userWord = userWord.toLowerCase();
                for (int i = 0; i <userWord.length();i++) {
                    if (!userWord.substring(i,i+1).equals("#"))
                        WordInfo.correctLetters.add(userWord.substring(i,i+1));
                }
                WordInfo.sort();
                String ht = "";
                for (int i = 0; i < WordInfo.correctLetters.size();i++) {
                    ht = ht+WordInfo.correctLetters.get(i);
                }
                String ur = "http://www.wordhippo.com/what-is/containing-the-letters/"+userWord.length()+"-letter-words-" + ht + ".html";
                ur.replace("Begin", "");
                System.out.println("Url Ur :" + ur);
                getHTML(ur,userWord.length());

            /*

            if (WordInfo.correctLetters.size() < 1) {

                myGuess.setText(WordInfo.letters.get(0));
                WordInfo.letters.remove(0);
                System.out.println("Url Correct Length ");
            }
            else {



             }
            */

            }


    } else {
            WordInfo.filter(userWord);
            currentGuess = WordInfo.getGuess();
            myGuess.setText(currentGuess);
        }

        }
       // Random rn = new Random();
        //int index = rn.nextInt(WordInfo.wordGuesses.size() + 1) + 0;
        //currentWord.setText(WordInfo.wordGuesses.get(index));

    public void update(View view) {

        String userW = editText.getText().toString();
        if (userW.toLowerCase().equals(userWord.toLowerCase())) {
            if (!userWord.contains(currentGuess)) {
                WordInfo.incorrectWords.add(currentGuess);
            }
        }
        else {

                WordInfo.correctLetters.add(currentGuess);

        }
        if (WordInfo.wordGuesses.size() > 1) {
            WordInfo.filter(userWord);
        }
        if (WordInfo.wordGuesses.size() == 1) {
            Intent f = new Intent(MyGuessGame.this, GoodGame.class);
            f.putExtra("word",WordInfo.wordGuesses.get(0));
            startActivity(f);
        }
        Intent i = new Intent(this,MyGuessGame.class);
        i.putExtra("name", userW);
        startActivity(i);
    }
    public void getHTML(final String url, final int len) {
        System.out.println("Begin HTML");
        System.out.println("Final Url: " + url);
        final String[] d = new String[1];
        Ion.with(getApplicationContext())
                .load(url)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        Intent tee = new Intent(MyGuessGame.this, te.class);
                        tee.putExtra("list",result);
                        tee.putExtra("userWord",userWord);
                        startActivity(tee);


                    }
                });
    }
    public String takeOutHtml(String str) {
        int check = 0;
        String res = "";
        for (int i = 0; i < str.length();i++) {
            if (str.charAt(i) == '<') {
                check = 1;
            }
            if (str.charAt(i) == '>') {
                check = 0;
            }
            if (check == 0) {
                res = res + str.charAt(i);
            }
        }
        res = res.replace(">","");
        res = res.replace("  ","");
        String adjusted = res.replaceAll("(?m)^[ \t]*\r?\n", "");

        return adjusted;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}

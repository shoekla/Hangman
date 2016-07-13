package com.example.abirshukla.hangman;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.Random;

public class MyGuessGame extends AppCompatActivity {
    TextView myGuess;
    TextView incorrect;
    TextView currentWord;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_my_guess_game);
        Bundle info = getIntent().getExtras();
        String userWord = "";

        myGuess = (TextView) findViewById(R.id.textView3);
        incorrect = (TextView) findViewById(R.id.textView5);
        currentWord = (TextView) findViewById(R.id.textView7);
        editText = (EditText) findViewById(R.id.editText);

        if (info != null)
            userWord = info.getString("name");
        if (userWord.length() >1) {
            editText.setText(userWord);
            System.out.println("Url length ");
            currentWord.setText(userWord);
        }
        else {
            currentWord.setText("No Word Detected");
        }
        if (WordInfo.letters.size() > 20) {
            myGuess.setText(WordInfo.letters.get(0));
            WordInfo.letters.remove(0);
            System.out.println("Url letter size ");
        }
        else {
            WordInfo.correctLetters.clear();
            userWord = userWord.toLowerCase();
            for (int i = 0; i <userWord.length();i++) {
                    if (!userWord.substring(i,i+1).equals("#"))
                        WordInfo.correctLetters.add(userWord.substring(i,i+1));

            }
            WordInfo.sort();
            if (WordInfo.correctLetters.size() < 1) {

                myGuess.setText(WordInfo.letters.get(0));
                WordInfo.letters.remove(0);
                System.out.println("Url Correct Length ");
            }
            else{
                if (WordInfo.wordGuesses.size() < 1) {
                    String ht = "";
                    for (int i = 0; i < WordInfo.correctLetters.size(); i++) {
                        ht = ht + WordInfo.correctLetters.get(i);
                    }
                    String ur = "http://www.bestwordlist.com/c/" + WordInfo.correctLetters.get(0) + "/" + WordInfo.correctLetters.size() + "/"+userWord.length()+"letterwordswith" + ht + ".txt";
                    ur.replace("Begin", "");
                    System.out.println("Url Ur :" + ur);
                    try {
                        getHTML(ur);
                    }
                    catch (Exception e) {
                        try {
                            ur = ur.replace(".txt",".htm");
                            getHTML(ur);
                        }
                        catch (Exception e1) {

                        }
                    }
                    if (WordInfo.wordGuesses.size()  < 2) {
                        String ura = "http://www.bestwordlist.com/c/" + WordInfo.correctLetters.get(0) + "/" + WordInfo.correctLetters.size() + "/"+userWord.length()+"letterwordswith" + ht + ".htm";
                        ur.replace("Begin", "");
                        System.out.println("Url Ur :" + ura);
                        try {
                            getHTML(ura);
                        }
                        catch (Exception e) {
                            try {
                                ura = ura.replace(".txt",".htm");
                                getHTML(ur);
                            }
                            catch (Exception e1) {

                            }
                        }
                    }
                    WordInfo.filter(userWord);
                    for (int w = 0; w < WordInfo.wordGuesses.size();w++) {

                        System.out.println("Word Info Index "+w+": "+WordInfo.wordGuesses.get(w));
                    }


                }
                else if (WordInfo.wordGuesses.size() == 1) {
                    myGuess.setText(WordInfo.wordGuesses.get(0));
                }
                else {
                     Random rn = new Random();
                    int index = rn.nextInt(WordInfo.wordGuesses.size() + 1) + 0;
                    currentWord.setText(WordInfo.wordGuesses.get(index));
                }
            }


        }
       // Random rn = new Random();
        //int index = rn.nextInt(WordInfo.wordGuesses.size() + 1) + 0;
        //currentWord.setText(WordInfo.wordGuesses.get(index));
    }
    public void update(View view) {
        Intent i = new Intent(this,MyGuessGame.class);
        String userW = editText.getText().toString();
        i.putExtra("name", userW);
        startActivity(i);
    }
    public void getHTML(final String url) {
        System.out.println("Begin HTML");
        System.out.println("Final Url: " + url);
        final String[] d = new String[1];
        Ion.with(getApplicationContext())
                .load(url)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        result = takeOutHtml(result);
                        String arr[] = result.split(" ");
                        try {
                            for (int i = 0; i < arr.length; i++) {
                                WordInfo.wordGuesses.add(arr[i]);
                            }
                        }
                        catch (Exception exc) {

                        }

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
}

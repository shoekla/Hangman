package com.example.abirshukla.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class te extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_te);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle w = getIntent().getExtras();
        String wordList = w.getString("list");
        String userWord = w.getString("userWord");
        TextView wo = (TextView) findViewById(R.id.words);
        wo.setText("Aggregating Words...");
        getWords(wordList,userWord);
    }
    public void getWords(String code,String userWord) {
        code = code.substring(code.indexOf("onClick=\"pushRel();\""));
        String[] arr = code.split(" ");
        for (int i = 0; i < arr.length;i++) {
            if (arr[i].contains("onClick=\"pushRel();\"")) {
                i = i+1;
                if (i < arr.length) {
                    if (arr[i].contains("href=\"/what-is/another-word-for/")) {
                        int index = arr[i].indexOf(">");
                        int index2 = arr[i].indexOf("</a>",index);
                        System.out.println("Index Te Activity " + i + ": " + arr[i].substring(index+1,index2));
                        WordInfo.wordGuesses.add(arr[i].substring(index+1,index2));
                    }
                }
            }


        }
        WordInfo.filter(userWord);
        Intent b = new Intent(te.this,MyGuessGame.class);
        b.putExtra("name",userWord);
        startActivity(b);
    }

}

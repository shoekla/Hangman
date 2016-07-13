package com.example.abirshukla.hangman;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by abirshukla on 7/9/16.
 */
public class WordInfo {
    public static ArrayList<String> incorrectWords = new ArrayList<>();

    public static ArrayList<String> wordGuesses = new ArrayList<>();

    public static ArrayList<String> letters = new ArrayList<>();

    public static ArrayList<String> correctLetters = new ArrayList<>();

    public static void sort() {
        Collections.sort(correctLetters);
    }
    public static void filter(String word) {
        for (int i = 0; i < wordGuesses.size();i++) {
            if (word.length() != wordGuesses.get(i).length()) {
                wordGuesses.remove(i);
                continue;
            }
            for (int l = 0; l < incorrectWords.size();l++) {
                if (wordGuesses.get(i).contains(incorrectWords.get(l))) {
                    wordGuesses.remove(i);
                    continue;
                }
            }
            for (int w = 0; w < word.length(); w++) {
                if (word.charAt(w) != '#') {
                    if (wordGuesses.get(i).charAt(w) != word.charAt(w)) {
                        wordGuesses.remove(i);
                        continue;
                    }
                }
                else {
                    for (int c = 0; c < correctLetters.size(); c++) {
                        if (wordGuesses.get(i).charAt(w) == correctLetters.get(c).charAt(0)) {
                            wordGuesses.remove(i);
                            continue;
                        }
                    }
                }
            }
        }
    }
}

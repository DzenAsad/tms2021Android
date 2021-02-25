package com;


import java.util.Arrays;

public class TextFormatter {

    public static int getNumbWords(String string) {
        String[] formattedData = string.split("\\W+");
        return formattedData.length;
    }

    public static boolean checkPalindrome(String string) {
        String[] formattedData = string.split("\\W+");
        for (String word : formattedData) {
            if (word.toLowerCase().equals(new StringBuilder(word.toLowerCase()).reverse().toString()) && word.toCharArray().length > 1) {
                return true;
            }
        }
        return false;
    }

    public static String[] getSentences(String string) {
        String[] formattedData = string.split("\\.\\s+");
        return formattedData;
    }
}

package com.handlers;

import com.TextFormatter;
import com.tms.io.output.TmsFileWriter;
import com.tms.io.output.TmsWriter;

import java.io.IOException;

public class HandlerLesson2 implements MyHandler {
    final String OUTPUT_PATH;

    public HandlerLesson2(String filePath) {
        OUTPUT_PATH = filePath;
    }

    public void handleSomeString(String string) throws IOException {
        String[] formattedData = TextFormatter.getSentences(string);
        TmsWriter anotherWriter = new TmsFileWriter(OUTPUT_PATH);
        for (String sentence: formattedData){
            System.out.println(TextFormatter.getNumbWords(sentence));
            if (TextFormatter.checkPalindrome(sentence)){
                anotherWriter.append(sentence);
            }
        }
    }
}

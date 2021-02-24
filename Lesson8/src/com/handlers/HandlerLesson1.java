package com.handlers;

import com.Readers.MyReader;
import com.tms.io.output.TmsFileWriter;
import com.tms.io.output.TmsWriter;

import java.io.IOException;

public class HandlerLesson1 implements MyHandler {
    final String OUTPUT_PATH;

    public HandlerLesson1(String filePath) {
        OUTPUT_PATH = filePath;
    }

    @Override
    public void handleSomeString(String string) throws IOException {
        TmsWriter tmsWriter = new TmsFileWriter(OUTPUT_PATH);
        tmsWriter.write(new StringBuilder(string).reverse().toString());
    }
}

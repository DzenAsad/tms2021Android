package com.home.UI.Readers;

import com.home.UI.Readers.MyReader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileMyReader implements MyReader {
    public List<String> someRead() throws IOException {
        System.out.println("-Insert path to file-");
        Scanner consoleScanner = new Scanner(System.in);
        List<String> data = new LinkedList<>();
        String fileName = consoleScanner.nextLine();
        Path path = Paths.get(fileName);
        Scanner fileScanner = new Scanner(path);
        fileScanner.useDelimiter(System.getProperty("line.separator"));
        while (fileScanner.hasNext()) {
            data.add(fileScanner.next());
        }
        fileScanner.close();
        return data;
    }
}
